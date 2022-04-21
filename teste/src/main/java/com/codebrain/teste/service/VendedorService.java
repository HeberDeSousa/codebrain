package com.codebrain.teste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.codebrain.teste.exception.VendedorException;
import com.codebrain.teste.model.Vendedor;
import com.codebrain.teste.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	VendedorRepository vendedorRepository;

	public Vendedor cadastrar(Vendedor vendedor) throws VendedorException {
		try {
			return vendedorRepository.save(vendedor);
		} catch (DataIntegrityViolationException e) {
			throw new VendedorException("Já existe o vendedor informado.", e);
		}
	}

	public Vendedor buscar(Long matricula) throws VendedorException {
		Optional<Vendedor> vendedorOptional = vendedorRepository.findById(matricula);
		if (!vendedorOptional.isPresent()) {
			throw new VendedorException("Vendedor não encontrado.");
		}
		return vendedorOptional.get();
	}

	public Vendedor alterar(Vendedor vendedor, Long matricula) throws VendedorException {
		Vendedor _vendedor = buscar(matricula);

		_vendedor.setNome(vendedor.getNome());

		return vendedorRepository.save(_vendedor);
	}

	public void deletar(Long matricula) throws VendedorException {
		Vendedor _vendedor = buscar(matricula);

		vendedorRepository.delete(_vendedor);
	}

}
