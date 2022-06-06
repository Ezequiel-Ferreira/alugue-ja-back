package com.teste.ezequiel.alugueja.dto.outputs;

import com.teste.ezequiel.alugueja.entities.vo.enuns.Genero;

import java.math.BigDecimal;

public class FilmeDTOOutput {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String urlCapa;
    private Genero genero;

    public FilmeDTOOutput(Long id, String nome, String descricao, BigDecimal valor, String urlCapa,  Genero genero) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.urlCapa = urlCapa;
        this.genero = genero;
    }

    public FilmeDTOOutput() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUrlCapa() {
        return urlCapa;
    }

    public void setUrlCapa(String urlCapa) {
        this.urlCapa = urlCapa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
