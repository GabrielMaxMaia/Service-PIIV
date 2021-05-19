package com.example.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.services.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query(value ="select * from pedido where comanda_id = :comanda_id", nativeQuery = true)
	List<Pedido> findPedidosByComandaId(@Param("comanda_id") Long comanda_id);
}
