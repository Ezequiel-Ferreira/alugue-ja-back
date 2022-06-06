package com.teste.ezequiel.alugueja.dto.outputs;

import java.math.BigDecimal;
import java.util.List;

public class UsuarioDTOOutput {
    private Long id;
    private String nome;
    private String email;
    private BigDecimal creditos;
    private List<AluguelDTOOutput> alugueis;

    public UsuarioDTOOutput(Long id, String nome, String email, BigDecimal creditos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.creditos = creditos;
    }

    public UsuarioDTOOutput() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public List<AluguelDTOOutput> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<AluguelDTOOutput> alugueis) {
        this.alugueis = alugueis;
    }
}
