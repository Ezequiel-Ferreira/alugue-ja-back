package com.teste.ezequiel.alugueja.entities;

import com.teste.ezequiel.alugueja.entities.vo.enuns.Genero;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String urlVideo;
    private String urlCapa;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany(mappedBy = "filme", fetch = FetchType.EAGER)
    private List<Aluguel> alugueis = new ArrayList<>();

    public Filme(Long id, String nome, String descricao, BigDecimal valor, String urlVideo, String urlCapa, List<Aluguel> alugueis, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.urlVideo = urlVideo;
        this.urlCapa = urlCapa;
        this.alugueis = alugueis;
        this.genero = genero;
    }

    public Filme() {
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

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
