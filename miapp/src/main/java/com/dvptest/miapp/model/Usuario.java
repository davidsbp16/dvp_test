package com.dvptest.miapp.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID idUsuario;
    private String nombres;
    private String apellidos;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    @OneToMany(mappedBy = "idTicket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
