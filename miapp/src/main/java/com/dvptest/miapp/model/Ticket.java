package com.dvptest.miapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.dvptest.miapp.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID idTicket;
    @NotBlank(message= "La descripción no puede estar en blanco")
    @Column(nullable = false, length = 500)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Status status;
}
