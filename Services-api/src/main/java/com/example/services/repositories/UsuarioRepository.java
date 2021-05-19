package com.example.services.repositories;

import org.springframework.stereotype.Repository;

import com.example.services.Model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

	Optional<Usuario> findByEmail(String email);
}
