package com.dvptest.miapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvptest.miapp.model.Usuario;
import com.dvptest.miapp.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario u){
        return usuarioRepository.save(u);
    }

    public Usuario actualizarUsuario(UUID id, Usuario usuarioActualizado){
        return usuarioRepository.findById(id)
            .map(u -> {
                u.setNombres(usuarioActualizado.getNombres());
                u.setApellidos(usuarioActualizado.getApellidos());
                u.setFechaActualizacion(LocalDateTime.now());
                return usuarioRepository.save(u);
            })
            .orElseThrow(() -> new RuntimeException("No se encontró el usuario a actualizar en los registros de BD"));
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioxId(UUID id){
        return usuarioRepository.findById(id);
    }
}
