package com.dvptest.miapp.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID idUsuario;
    @NotNull(message= "El nombre debe estar definido en el request")
    @NotBlank(message= "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombres;
    @NotBlank(message= "El apellido no puede estar vacío")
    @Column(nullable = false)
    private String apellidos;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    @OneToMany(mappedBy = "idTicket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
