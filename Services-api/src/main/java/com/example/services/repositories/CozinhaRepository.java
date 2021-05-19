package com.example.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.services.Model.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	@Query(value ="select pedido.id , produto.nome, pedido.quantidade, pedido.observacao, cozinha.finalizado from pedido, produto, cozinha"
			+ "  where pedido.produto_id = produto.id   and pedido.id = cozinha.cod_pedido and finalizado = 'nao'", nativeQuery = true)
	List<String> findPedidos();
	
}
