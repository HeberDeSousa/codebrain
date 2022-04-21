package com.codebrain.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebrain.teste.exception.VendedorException;
import com.codebrain.teste.model.Vendedor;
import com.codebrain.teste.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	VendedorService vendedorService;

	@PostMapping("/")
	public ResponseEntity<Object> cadastrar(@RequestBody Vendedor vendedor) {
		try {
			Vendedor _vendedor = vendedorService.cadastrar(vendedor);
			return ResponseEntity.status(HttpStatus.CREATED).body(_vendedor);
		} catch (VendedorException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/{matricula}")
	public ResponseEntity<Object> alterar(@RequestBody Vendedor vendedor, @PathVariable Long matricula) {

		try {
			Vendedor _vendedor = vendedorService.alterar(vendedor);
			return ResponseEntity.status(HttpStatus.OK).body(_vendedor);
		} catch (VendedorException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/{matricula}")
	public ResponseEntity<Object> deletar(@PathVariable Long matricula) {
		try {
			vendedorService.deletar(matricula);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (VendedorException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/{matricula}")
	public ResponseEntity<Object> buscar(@PathVariable Long matricula) {

		try {
			Vendedor vendedor = vendedorService.buscar(matricula);
			return ResponseEntity.status(HttpStatus.OK).body(vendedor);
		} catch (VendedorException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
