package com.teste.ezequiel.alugueja.exceptions.filme;

import com.teste.ezequiel.alugueja.exceptions.NotFoundException;

public class FilmeAlreadyExistsException extends NotFoundException {
    private static final String MESSAGE = "O Filme com o nome %s ja existente";

    public FilmeAlreadyExistsException(String message) {
        super(String.format(MESSAGE, message));
    }
}
