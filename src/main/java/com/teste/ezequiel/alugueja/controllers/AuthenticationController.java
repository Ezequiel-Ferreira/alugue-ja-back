package com.teste.ezequiel.alugueja.controllers;

import com.teste.ezequiel.alugueja.dto.inputs.CredenciaisDTO;
import com.teste.ezequiel.alugueja.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody CredenciaisDTO credenciaisDTO) throws Exception {
        return ResponseEntity.of(Optional.of(service.login(credenciaisDTO)));
    }
}
