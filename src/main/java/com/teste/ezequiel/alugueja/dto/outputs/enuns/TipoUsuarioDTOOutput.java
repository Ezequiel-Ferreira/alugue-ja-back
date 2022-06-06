package com.teste.ezequiel.alugueja.dto.outputs.enuns;

import com.teste.ezequiel.alugueja.entities.vo.enuns.TipoUsuario;

public enum TipoUsuarioDTOOutput {
    ADMIN(1, "ADMINISTRADOR"),
    CLIENTE(2, "CLIENTE");

    private int codigo;
    private String descricao;

    private TipoUsuarioDTOOutput(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao () {
        return descricao;
    }

    public static TipoUsuario toEnum(Integer codigo) {

        if (codigo == null) {
            return null;
        }

        for (TipoUsuario x : TipoUsuario.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
