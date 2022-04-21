package com.codebrain.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codebrain.teste.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
