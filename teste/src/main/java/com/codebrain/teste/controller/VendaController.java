package com.codebrain.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codebrain.teste.exception.VendaException;
import com.codebrain.teste.model.Venda;
import com.codebrain.teste.service.VendaService;

@RestController
public class VendaController {
	
	@Autowired
	VendaService vendaService;
	
	@PostMapping("/")
	public ResponseEntity<Object> cadastrar(@RequestBody Venda venda) {
		try {
			Venda _venda = vendaService.cadastrar(venda);
			return ResponseEntity.status(HttpStatus.CREATED).body(_venda);
		} catch (VendaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
