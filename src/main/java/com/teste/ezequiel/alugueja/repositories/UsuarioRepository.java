package com.teste.ezequiel.alugueja.repositories;

import com.teste.ezequiel.alugueja.entities.Usuario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
