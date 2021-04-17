package com.example.services.repositories;

import org.springframework.stereotype.Repository;

import com.example.services.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface usuarioRepository extends JpaRepository <Usuario, Long>{

}
