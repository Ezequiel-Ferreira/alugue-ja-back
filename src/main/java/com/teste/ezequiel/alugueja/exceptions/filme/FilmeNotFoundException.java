package com.teste.ezequiel.alugueja.exceptions.filme;

import com.teste.ezequiel.alugueja.exceptions.AlreadyExistsException;

public class FilmeNotFoundException extends AlreadyExistsException {
    private static final String MESSAGE = "O Filme com o id %s nao existe";

    public FilmeNotFoundException(Long message) {
        super(String.format(MESSAGE, message));
    }
}
