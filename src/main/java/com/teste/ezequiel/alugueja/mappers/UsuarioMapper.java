package com.teste.ezequiel.alugueja.mappers;

import com.teste.ezequiel.alugueja.dto.inputs.UsuarioDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioIniDTOOutput;
import com.teste.ezequiel.alugueja.entities.Usuario;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    Usuario toUsuario(UsuarioDTOInput input);

    UsuarioDTOOutput toUsuarioOutPut(Usuario usuario);

    UsuarioIniDTOOutput toUsuarioIniOutput(Usuario usuario);
}
