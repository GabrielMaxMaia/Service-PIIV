package com.example.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.services.Model.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{

}
