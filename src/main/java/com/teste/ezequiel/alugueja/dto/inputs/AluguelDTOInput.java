package com.teste.ezequiel.alugueja.dto.inputs;

import java.util.Date;

public class AluguelDTOInput {
    private Long idUsuario;
    private Long idFilme;
    private Integer quantidadeHoras;

    public AluguelDTOInput() {
    }

    public AluguelDTOInput(Long idUsuario, Long idFilme, Integer quantidadeHoras) {
        this.idUsuario = idUsuario;
        this.idFilme = idFilme;
        this.quantidadeHoras = quantidadeHoras;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
}