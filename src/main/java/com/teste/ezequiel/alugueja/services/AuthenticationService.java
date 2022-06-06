package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.dto.inputs.CredenciaisDTO;

public interface AuthenticationService {

    String login(CredenciaisDTO credenciaisDTO) throws Exception;
}
