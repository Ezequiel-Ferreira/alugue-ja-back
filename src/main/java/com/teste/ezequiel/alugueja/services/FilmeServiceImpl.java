package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.dto.inputs.FilmeDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.FilmeDTOOutput;
import com.teste.ezequiel.alugueja.entities.Filme;
import com.teste.ezequiel.alugueja.exceptions.filme.FilmeAlreadyExistsException;
import com.teste.ezequiel.alugueja.mappers.FilmeMapper;
import com.teste.ezequiel.alugueja.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeServiceImpl implements FilmeService{

    @Autowired
    private FilmeRepository repository;

    @Autowired
    private FilmeMapper mapper;

    @Override
    public FilmeDTOOutput create(FilmeDTOInput input) {
        validDuplicity(input);
        Filme filme = repository.save(mapper.toFilme(input));
        return mapper.toFilmeOutPut(filme);
    }

    @Override
    public List<FilmeDTOOutput> findAll() {
        return repository.findAll().stream().map(mapper::toFilmeOutPut).collect(Collectors.toList());
    }

    private void validDuplicity(FilmeDTOInput input) {
        repository.findByNomeOrUrlVideo(input.getNome(), input.getUrlVideo())
                .ifPresent(filme -> {
                    throw new FilmeAlreadyExistsException(input.getNome());
                });
    }
}
