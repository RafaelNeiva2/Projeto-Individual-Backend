package com.info4.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info4.project.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByEmail(String email);

}
