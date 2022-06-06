package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.dto.inputs.AluguelDTOInput;
import com.teste.ezequiel.alugueja.dto.outputs.UsuarioDTOOutput;
import com.teste.ezequiel.alugueja.exceptions.InsufficientFunds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AluguelServiceTest {

    @Autowired
    AluguelService service;

    private static AluguelDTOInput dtoInput;

    @BeforeAll
    public static void init(){
        dtoInput = new AluguelDTOInput(5L, 6L, 7);
    }

    @Test
    @DisplayName("Deve lançar a excersao quando valor pela quantidade de horas requesitado para o filme for maior")
    public void shouldThrowInsufficientFundsException() {
        Assertions.assertThrows(InsufficientFunds.class, () -> service.createAluguel(dtoInput));
    }

    @Test
    @DisplayName("Deve salvar o aluguel")
    public void shouldSaveAluguel() {
        dtoInput.setIdUsuario(6L);
        dtoInput.setQuantidadeHoras(1);
        UsuarioDTOOutput usuarioDTOOutput = service.createAluguel(dtoInput);
        Assertions.assertTrue(usuarioDTOOutput.getAlugueis().stream()
                .anyMatch(a -> a.getFilme().getId().equals(dtoInput.getIdFilme())));
    }

}
