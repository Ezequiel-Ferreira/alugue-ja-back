package com.teste.ezequiel.alugueja.exceptions.filme;

public class FilmeTimeOverException extends RuntimeException {

    private static final String MASSAGE = "O seu tempo com o filme %s se esgotou";

    public FilmeTimeOverException(String nome) {
        super(String.format(MASSAGE, nome));
    }
}
