package com.example.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.services.Model.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	
	@Query(value ="select max(id) from comanda", nativeQuery = true)
	Long findComanda();
}
