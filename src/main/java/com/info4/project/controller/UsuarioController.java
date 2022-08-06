package com.info4.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info4.project.exception.UsuarioExistenteException;
import com.info4.project.exception.UsuarioInexistenteException;
import com.info4.project.model.Usuario;
import com.info4.project.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	
	@Autowired
	UsuarioService service;
	
	@GetMapping
	public List<Usuario> findAll() {
		return service.listarTudo();
	}

	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable Integer id) throws UsuarioInexistenteException {
		return service.listarPorId(id);
	}
	@PostMapping
	public Usuario insert( @RequestBody Usuario usuario) throws UsuarioExistenteException {
		return service.inserir(usuario);
			
		
	}
}
