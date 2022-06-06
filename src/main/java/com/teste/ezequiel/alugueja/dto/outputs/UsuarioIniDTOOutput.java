package com.teste.ezequiel.alugueja.dto.outputs;

import com.teste.ezequiel.alugueja.dto.outputs.enuns.TipoUsuarioDTOOutput;

import java.math.BigDecimal;

public class UsuarioIniDTOOutput {

    private Long id;

    private String email;

    private BigDecimal creditos;

    private TipoUsuarioDTOOutput tipo;

    public UsuarioIniDTOOutput() {
    }

    public UsuarioIniDTOOutput(Long id, String email, BigDecimal creditos, TipoUsuarioDTOOutput tipo) {
        this.id = id;
        this.email = email;
        this.creditos = creditos;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuarioDTOOutput getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuarioDTOOutput tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }
}
