package com.dvptest.miapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvptest.miapp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

    
}
