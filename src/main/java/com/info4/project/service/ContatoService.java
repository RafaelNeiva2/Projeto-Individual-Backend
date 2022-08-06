package com.info4.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info4.project.exception.ContatoExistenteException;
import com.info4.project.exception.ContatoInexistenteException;
import com.info4.project.model.Contato;
import com.info4.project.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository repositorio;

	public List<Contato> listarTudo() {
		return repositorio.findAll();
	}

	public Contato listarPorId(Integer id) throws ContatoInexistenteException {
		Optional<Contato> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ContatoInexistenteException("Contato inexistente");
		}
		return optional.get();
	}

	public void verificarExiste(Contato contato) throws ContatoExistenteException{
		Optional<Contato> optional = repositorio.findByTelefone(contato.getTelefone());
		if (optional.isPresent()) {
			throw new ContatoExistenteException("Contato já cadastrado");
		}
	}

	public Contato inserir(Contato contato) throws ContatoExistenteException{
		verificarExiste(contato);
		 return repositorio.save(contato);
	}
}
