package com.codebrain.teste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.codebrain.teste.exception.ProdutoException;
import com.codebrain.teste.model.Produto;
import com.codebrain.teste.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto cadastrar(Produto produto) throws ProdutoException {
		try {
			return produtoRepository.save(produto);
		} catch (DataIntegrityViolationException e) {
			throw new ProdutoException("Já existe o produto informado.", e);
		}
	}

	public Produto buscar(Long matricula) throws ProdutoException {
		Optional<Produto> produtoOptional = produtoRepository.findById(matricula);
		if (!produtoOptional.isPresent()) {
			throw new ProdutoException("Produto não encontrado.");
		}
		return produtoOptional.get();
	}

	public Produto alterar(Produto produto, Long id) throws ProdutoException {
		Produto _produto = buscar(id);

		_produto.setNome(produto.getNome());
		_produto.setPreco(produto.getPreco());

		return produtoRepository.save(_produto);
	}

	public void deletar(Long matricula) throws ProdutoException {
		Produto _produto = buscar(matricula);

		produtoRepository.delete(_produto);
	}

}
