package com.codebrain.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codebrain.teste.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
