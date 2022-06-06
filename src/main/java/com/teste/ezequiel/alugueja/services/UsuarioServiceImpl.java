package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.dto.inputs.UsuarioDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioIniDTOOutput;
import com.teste.ezequiel.alugueja.entities.Usuario;
import com.teste.ezequiel.alugueja.exceptions.usuario.UsuarioAlreadyExistsException;
import com.teste.ezequiel.alugueja.exceptions.usuario.UsuarioNotFoundException;
import com.teste.ezequiel.alugueja.mappers.UsuarioMapper;
import com.teste.ezequiel.alugueja.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario Nao Encontrado"));
    }

    @Override
    public UsuarioDTOOutput create(UsuarioDTOInput input, Integer codigo) {
        validDuplicity(input);
        Usuario usuario = mapper.toUsuario(input);
        usuario.getTipos().add(codigo);
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        return mapper.toUsuarioOutPut(repository.save(usuario));
    }

    @Override
    public UsuarioDTOOutput findById(Long id) {
        return mapper.toUsuarioOutPut(
                repository.findById(id)
                        .orElseThrow(() -> new UsuarioNotFoundException(id.toString())));
    }

    @Override
    public UsuarioIniDTOOutput findIniByEmail(String email) {
        return mapper.toUsuarioIniOutput(repository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNotFoundException(email)));
    }

    private void validDuplicity(UsuarioDTOInput input) {
        repository.findByEmail(input.getEmail())
                .ifPresent(usuario -> {
                            throw new UsuarioAlreadyExistsException(input.getEmail());
                });
    }
}
