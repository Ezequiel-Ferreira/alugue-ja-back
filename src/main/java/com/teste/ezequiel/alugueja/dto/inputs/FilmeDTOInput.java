package com.teste.ezequiel.alugueja.dto.inputs;

import com.teste.ezequiel.alugueja.entities.vo.enuns.Genero;

import java.math.BigDecimal;

public class FilmeDTOInput {

    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String urlVideo;
    private String urlCapa;
    private Genero genero;

    public FilmeDTOInput() {
    }

    public FilmeDTOInput(String nome, String descricao, BigDecimal valor, String urlVideo, String urlCapa, Genero genero) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.urlVideo = urlVideo;
        this.urlCapa = urlCapa;
        this.genero = genero;
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

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
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
