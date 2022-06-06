package com.teste.ezequiel.alugueja.exceptions.aluguel;

import com.teste.ezequiel.alugueja.exceptions.NotFoundException;

public class AluguelNotFoundException extends NotFoundException {
    private static final String MESSAGE = "O Aluguel com o id %s nao existe";
    public AluguelNotFoundException(Long message) {
        super(String.format(MESSAGE, message));
    }
}
