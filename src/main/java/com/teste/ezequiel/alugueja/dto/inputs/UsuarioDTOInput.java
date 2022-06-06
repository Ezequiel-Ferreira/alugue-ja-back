package com.teste.ezequiel.alugueja.dto.inputs;

import java.math.BigDecimal;

public class UsuarioDTOInput {

    private String nome;
    private String email;
    private String senha;
    private BigDecimal creditos;

    public UsuarioDTOInput(String nome, String email, String senha, BigDecimal creditos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.creditos = creditos;
    }

    public UsuarioDTOInput() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }
}
