package com.info4.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info4.project.exception.ContatoExistenteException;
import com.info4.project.exception.ContatoInexistenteException;
import com.info4.project.exception.UsuarioExistenteException;
import com.info4.project.exception.UsuarioInexistenteException;
import com.info4.project.model.Contato;
import com.info4.project.model.Usuario;
import com.info4.project.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repositorio;

	public List<Usuario> listarTudo() {
		return repositorio.findAll();
	}

	public Usuario listarPorId(Integer id) throws UsuarioInexistenteException {
		Optional<Usuario> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new UsuarioInexistenteException("Usuario inexistente");
		}
		return optional.get();
	}

	public void verificarExiste(Usuario usuario) throws UsuarioExistenteException{
		Optional<Usuario> optional = repositorio.findByEmail(usuario.getEmail());
		if (optional.isPresent()) {
			throw new UsuarioExistenteException("Usuario já cadastrado");
		}
	}

	public Usuario inserir(Usuario usuario) throws UsuarioExistenteException{
		verificarExiste(usuario);
		 return repositorio.save(usuario);
	}
}
