package com.teste.ezequiel.alugueja.exceptions.usuario;

import com.teste.ezequiel.alugueja.exceptions.NotFoundException;

public class UsuarioNotFoundException extends NotFoundException {
    private static final String MESSAGE = "O Usuario %s nao existe";

    public UsuarioNotFoundException(String message) {
        super(String.format(MESSAGE, message));
    }
}
