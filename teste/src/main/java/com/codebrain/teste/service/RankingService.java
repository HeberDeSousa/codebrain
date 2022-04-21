package com.codebrain.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebrain.teste.model.relatorio.RankingQuantidadeVendas;
import com.codebrain.teste.repository.VendedorRepository;

@Service
public class RankingService {
	
	@Autowired
	VendedorRepository vendedorRepository;
	
	public List<RankingQuantidadeVendas> listarVendedoresPorQuantidadeVenda() {
		return vendedorRepository.rankingQuantidadeVendas();
	}

}
