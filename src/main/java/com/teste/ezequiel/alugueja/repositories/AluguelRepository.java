package com.teste.ezequiel.alugueja.repositories;

import com.teste.ezequiel.alugueja.entities.Aluguel;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface AluguelRepository extends JpaRepositoryImplementation<Aluguel, Long> {
}
