package com.dvptest.miapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import com.dvptest.miapp.model.Usuario;
import com.dvptest.miapp.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@Validated
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Operation(
        summary = "Registrar un nuevo usuario",
        description = "Crea un nuevo usuario en la base de datos y retorna el JSON con los atributos del usuario registrado",
        responses = {
            @ApiResponse(responseCode = "400", description = "Error en los valores especificados para el usuario"),
            @ApiResponse(responseCode = "403", description = "Error en los parámetros especificados"),
            @ApiResponse(responseCode = "200", description = "Usuario registrado en la base de datos")
        }
    )
    @PostMapping
    public Usuario crearUsuario(@Valid @RequestBody Usuario usuario) {
        //TODO: process POST request
        
        return usuarioService.crearUsuario(usuario);
    }

    @Operation(
        summary = "Actualizar una propiedad de un usuario existente",
        description = "Actualiza las propiedades de un usuario existente en la base de datos y retorna el JSON con los nuevos atributos del usuario",
        responses = {
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "200", description = "Usuario actualizado en la base de datos")
        }
    )
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@Valid @PathVariable UUID id, @RequestBody Usuario usuario) {
        //TODO: process PUT request
        
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @Operation(
        summary = "Obtener todos los usuarios",
        description = "Retorna la lista de todos los usuarios registrados en BD",
        responses = {
            @ApiResponse(responseCode = "400", description = "Error en los valores especificados para el usuario"),
            @ApiResponse(responseCode = "200", description = "Usuarios obtenidos en la base de datos")
        }
    )
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
    
    @Operation(
        summary = "Obtener un usuario por id",
        description = "Busca la información de un usuario registrado en la BD.",
        responses = {
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "200", description = "Usuario encontrado en la base de datos",
                content = @Content(schema = @Schema(implementation = Usuario.class)))
        }
    )
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuario(@PathVariable UUID id) {
        return usuarioService.obtenerUsuarioxId(id);
    }
    
}
