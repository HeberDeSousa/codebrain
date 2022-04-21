package com.codebrain.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebrain.teste.model.relatorio.RankingQuantidadeVendas;
import com.codebrain.teste.service.RankingService;

@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	RankingService rankingService;
	
	@GetMapping("/quantidadeVenda")
	public List<RankingQuantidadeVendas> listarVendedores() {
		return rankingService.listarVendedoresPorQuantidadeVenda();
	}
}
