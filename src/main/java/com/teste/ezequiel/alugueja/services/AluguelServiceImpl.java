package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.dto.inputs.AluguelDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;
import com.teste.ezequiel.alugueja.entities.Filme;
import com.teste.ezequiel.alugueja.entities.Usuario;
import com.teste.ezequiel.alugueja.entities.Aluguel;
import com.teste.ezequiel.alugueja.exceptions.aluguel.AluguelNotFoundException;
import com.teste.ezequiel.alugueja.exceptions.filme.FilmeAlreadyExistsException;
import com.teste.ezequiel.alugueja.exceptions.filme.FilmeNotFoundException;
import com.teste.ezequiel.alugueja.exceptions.filme.FilmeTimeOverException;
import com.teste.ezequiel.alugueja.exceptions.usuario.UsuarioNotFoundException;
import com.teste.ezequiel.alugueja.mappers.UsuarioMapper;
import com.teste.ezequiel.alugueja.repositories.AluguelRepository;
import com.teste.ezequiel.alugueja.repositories.FilmeRepository;
import com.teste.ezequiel.alugueja.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTOOutput createAluguel(AluguelDTOInput input) {
        Usuario usuario = findUsuario(input.getIdUsuario());
        Aluguel aluguel = findAluguel(usuario, input.getIdFilme());
        Filme filme = findFilme(input.getIdFilme());
        if (aluguel == null){
            aluguel = new Aluguel(usuario, filme, getDate(input.getQuantidadeHoras()));
            usuario.payFilme(filme.getValor().multiply(new BigDecimal(input.getQuantidadeHoras())));
        } else {
            usuario.payFilme(filme.getValor().multiply(new BigDecimal(input.getQuantidadeHoras())));
            aluguel.setDataLimite(addTime(aluguel, input.getQuantidadeHoras()));
        }


        aluguelRepository.save(aluguel);

        filme.getAlugueis().add(aluguel);
        usuario.getAlugueis().add(aluguel);

        usuarioRepository.save(usuario);
        filmeRepository.save(filme);

        return usuarioMapper.toUsuarioOutPut(usuario);
    }

    private Date addTime(Aluguel aluguel, Integer quantidadeHoras) {
        Calendar c = Calendar.getInstance();
        c.setTime(aluguel.getDataLimite());
        c.add(Calendar.HOUR_OF_DAY, quantidadeHoras);
        return c.getTime();
    }

    private Filme findFilme(Long idFilme) {
        return filmeRepository.findById(idFilme)
                .orElseThrow(() -> new FilmeNotFoundException(idFilme));
    }

    private Aluguel findAluguel(Usuario usuario, Long idFilme) {
        return usuario.getAlugueis().stream()
                .filter(aluguel ->  aluguel.getFilme().getId().equals(idFilme))
                .findFirst().orElse(null);
    }

    private Usuario findUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException(idUsuario.toString()));
    }

    private Date getDate(Integer quantidadeHoras) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.HOUR_OF_DAY, quantidadeHoras);
        return c.getTime();
    }

    @Override
    public String findUrlVideoById(Long idAluguel) {
        Aluguel aluguel = aluguelRepository.findById(idAluguel)
                .orElseThrow(() -> new AluguelNotFoundException(idAluguel));
        validLimitDate(aluguel);
        return aluguel.getFilme().getUrlVideo();
    }

    private void validLimitDate(Aluguel aluguel) {
        boolean isGreater = System.currentTimeMillis() > aluguel.getDataLimite().getTime();
        if (isGreater) {
            throw new FilmeTimeOverException(aluguel.getFilme().getNome());
        }
    }
}
