package com.teste.ezequiel.alugueja.exceptions.usuario;

import com.teste.ezequiel.alugueja.exceptions.AlreadyExistsException;

public class UsuarioAlreadyExistsException extends AlreadyExistsException {
    private static final String MESSAGE = "Usuario com o email %s existente";

    public UsuarioAlreadyExistsException(String message) {
        super(String.format(MESSAGE, message));
    }
}
