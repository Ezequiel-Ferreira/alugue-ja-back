package com.teste.ezequiel.alugueja.services;


import com.teste.ezequiel.alugueja.dto.inputs.UsuarioDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioIniDTOOutput;
import com.teste.ezequiel.alugueja.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioService extends UserDetailsService {

    Usuario loadUserByUsername(String username) throws UsernameNotFoundException;

    UsuarioDTOOutput create(UsuarioDTOInput input, Integer codigo);

    UsuarioDTOOutput findById(Long id);

    UsuarioIniDTOOutput findIniByEmail(String email);
}
