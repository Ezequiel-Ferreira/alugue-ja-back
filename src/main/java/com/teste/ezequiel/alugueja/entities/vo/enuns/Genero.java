package com.teste.ezequiel.alugueja.entities.vo.enuns;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genero {

    @JsonProperty("acao")
    ACAO("Acao"),
    @JsonProperty("aventura")
    AVENTURA("Aventura"),
    @JsonProperty("drama")
    DRAMA("Drama"),
    @JsonProperty("suspense")
    SUSPENSE("Suspense"),
    @JsonProperty("romance")
    ROMANCE("Romance"),
    @JsonProperty("terror")
    TERROR("Terror") ,
    @JsonProperty("comedia")
    COMEDIA("Comedia")
    ;

    private final String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
