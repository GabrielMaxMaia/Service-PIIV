package com.example.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.services.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
