package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.dto.inputs.AluguelDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;

public interface AluguelService {

    UsuarioDTOOutput createAluguel(AluguelDTOInput input);
    String findUrlVideoById(Long id);
}
