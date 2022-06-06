package com.teste.ezequiel.alugueja.repositories;

import com.teste.ezequiel.alugueja.entities.Filme;
import com.teste.ezequiel.alugueja.entities.Usuario;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface FilmeRepository extends JpaRepositoryImplementation<Filme, Long> {
    Optional<Filme> findByNomeOrUrlVideo(String nome, String urlVideo);
    Optional<String> findUrlById(Long id);
}
