package com.teste.ezequiel.alugueja.exceptions;

public class InsufficientFunds extends RuntimeException {
    private static final String SALDO_INSUFICIENTE = "Saldo insuficiente";

    public InsufficientFunds(){
        super(SALDO_INSUFICIENTE);
    }
}
