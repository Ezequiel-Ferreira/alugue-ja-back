package com.teste.ezequiel.alugueja.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Aluguel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "filme_id", unique = true)
    private Filme filme;

    @Column(name = "data_limite")
    private Date dataLimite;

    public Aluguel(Usuario usuario, Filme filme, Date dataLimite) {
        this.usuario = usuario;
        this.dataLimite = dataLimite;
        this.filme = filme;
    }

    public Aluguel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
