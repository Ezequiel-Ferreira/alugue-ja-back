package com.teste.ezequiel.alugueja.dto.outputs;

public class AluguelDTOOutput {

    private Long id;
    private FilmeDTOOutput filme;

    public AluguelDTOOutput(FilmeDTOOutput filme) {
        this.filme = filme;
    }

    public AluguelDTOOutput() {
    }

    public FilmeDTOOutput getFilme() {
        return filme;
    }

    public void setFilme(FilmeDTOOutput filme) {
        this.filme = filme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
