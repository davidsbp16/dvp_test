package com.dvptest.miapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvptest.miapp.model.Usuario;
import com.dvptest.miapp.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        //TODO: process POST request
        
        return usuarioService.crearUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
        //TODO: process PUT request
        
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
    
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuario(@PathVariable UUID id) {
        return usuarioService.obtenerUsuarioxId(id);
    }
    
}
