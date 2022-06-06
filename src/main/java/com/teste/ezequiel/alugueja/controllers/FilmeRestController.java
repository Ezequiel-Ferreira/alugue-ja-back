package com.teste.ezequiel.alugueja.controllers;

import com.teste.ezequiel.alugueja.dto.inputs.FilmeDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.FilmeDTOOutput;
import com.teste.ezequiel.alugueja.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("filme")
public class FilmeRestController {

    @Autowired
    private FilmeService service;

    @PostMapping
    public ResponseEntity<FilmeDTOOutput> create(@RequestBody FilmeDTOInput input) {
        return ResponseEntity.of(Optional.of(service.create(input)));
    }

    @GetMapping
    public ResponseEntity<List<FilmeDTOOutput>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
