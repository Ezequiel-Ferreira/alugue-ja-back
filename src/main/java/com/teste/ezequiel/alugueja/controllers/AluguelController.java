package com.teste.ezequiel.alugueja.controllers;

import com.teste.ezequiel.alugueja.dto.inputs.AluguelDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UrlDTOOutput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;
import com.teste.ezequiel.alugueja.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("aluguel")
public class AluguelController {
    @Autowired
    private AluguelService service;

    @PostMapping
    public ResponseEntity<UsuarioDTOOutput> create(@RequestBody AluguelDTOInput input){
        return ResponseEntity.ok(service.createAluguel(input));
    }

    @GetMapping("/{idAluguel}")
    public ResponseEntity<UrlDTOOutput> findUrlVideoById(@PathVariable("idAluguel") Long idAluguel) {
        UrlDTOOutput url = new UrlDTOOutput(service.findUrlVideoById(idAluguel));
        return ResponseEntity.of(Optional.of(url));
    }

}
