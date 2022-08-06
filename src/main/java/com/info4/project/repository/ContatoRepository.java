package com.info4.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info4.project.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{

	Optional<Contato> findByTelefone(String telefone);

}
