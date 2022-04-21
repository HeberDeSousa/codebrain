package com.codebrain.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codebrain.teste.model.Vendedor;
import com.codebrain.teste.model.relatorio.RankingQuantidadeVendas;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	@Query(value="SELECT V1.MATRICULA, V1.NOME, COUNT(DISTINCT V2.ID) AS NUMEROVENDAS " +
			"FROM VENDEDOR V1 " + 
			"LEFT JOIN VENDA V2 " + 
			"ON V1.MATRICULA = V2.MATRICULA " + 
			"GROUP BY V1.MATRICULA, V1.NOME " + 
			"ORDER BY 3 DESC", nativeQuery = true)
	List<RankingQuantidadeVendas> rankingQuantidadeVendas();

}
