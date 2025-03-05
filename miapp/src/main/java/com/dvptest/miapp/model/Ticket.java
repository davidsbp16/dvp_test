package com.dvptest.miapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dvptest.miapp.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID idTicket;
    @Column(length = 500)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Status status;
}
