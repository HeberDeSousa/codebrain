package com.codebrain.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.codebrain.teste.exception.VendaException;
import com.codebrain.teste.model.Venda;
import com.codebrain.teste.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	VendaRepository vendaRepository;

	public Venda cadastrar(Venda venda) throws VendaException {
		try {
			return vendaRepository.save(venda);
		} catch (DataIntegrityViolationException e) {
			throw new VendaException("Já existe a venda informada.", e);
		}
	}

}
