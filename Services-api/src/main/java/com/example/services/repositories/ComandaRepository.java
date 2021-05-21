package com.example.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.services.Model.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	
	@Query(value = "select max(id) from comanda", nativeQuery = true)
	Long findComanda();
	
	@Query(value = "select * from comanda where cod_mesa = :id_mesa and status = 'aberta' and usuario_codigo = :usuario_codigo", nativeQuery = true)
	List<Comanda> comandasPorMesa(@Param("id_mesa") Long id, @Param("usuario_codigo") Long id_usu);
}
