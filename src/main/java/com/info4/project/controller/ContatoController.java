package com.info4.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info4.project.exception.ContatoExistenteException;
import com.info4.project.exception.ContatoInexistenteException;
import com.info4.project.model.Contato;
import com.info4.project.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	ContatoService service;
	
	@GetMapping
	public List<Contato> findAll() {
		return service.listarTudo();
	}

	@GetMapping(value = "/{id}")
	public Contato findById(@PathVariable Integer id) throws ContatoInexistenteException {
		return service.listarPorId(id);
	}
	@PostMapping
	public Contato insert( @RequestBody Contato contato) throws ContatoExistenteException {
		return service.inserir(contato);
			
		
	}

}
