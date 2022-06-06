package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.dto.inputs.FilmeDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.FilmeDTOOutput;

import java.util.List;

public interface FilmeService {
    FilmeDTOOutput create(FilmeDTOInput input);
    List<FilmeDTOOutput> findAll();
}
