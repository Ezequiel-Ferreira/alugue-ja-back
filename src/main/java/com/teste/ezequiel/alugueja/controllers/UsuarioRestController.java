package com.teste.ezequiel.alugueja.controllers;

import com.teste.ezequiel.alugueja.dto.inputs.UsuarioDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioIniDTOOutput;
import com.teste.ezequiel.alugueja.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    private static final int COD_USUARIO_ADM = 1;

    private static final int COD_USUARIO_COMUN = 2;

    @Value("${token.adm}")
    private String tokenAdm;

    @PostMapping
    public ResponseEntity<UsuarioDTOOutput> create(@RequestBody UsuarioDTOInput input){
        return ResponseEntity.of(Optional.of(usuarioService.create(input, COD_USUARIO_COMUN)));
    }

    @PostMapping("/{codigo}")
    public ResponseEntity<UsuarioDTOOutput> createADM(@RequestBody UsuarioDTOInput input, @PathVariable("codigo") String codigo){
        if(codigo.equals(tokenAdm)){
            return ResponseEntity.of(Optional.of(usuarioService.create(input, COD_USUARIO_ADM)));
        }
       return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTOOutput> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping("/ini/{email}")
    public ResponseEntity<UsuarioIniDTOOutput> findByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(usuarioService.findIniByEmail(email));
    }


}
