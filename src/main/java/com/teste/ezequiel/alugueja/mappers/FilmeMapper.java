package com.teste.ezequiel.alugueja.mappers;

import com.teste.ezequiel.alugueja.dto.inputs.FilmeDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.FilmeDTOOutput;
import com.teste.ezequiel.alugueja.entities.Filme;
import org.mapstruct.Mapper;

@Mapper
public interface FilmeMapper {

    Filme toFilme(FilmeDTOInput input);

    FilmeDTOOutput toFilmeOutPut(Filme filme);
}
