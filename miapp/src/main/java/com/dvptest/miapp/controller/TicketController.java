package com.dvptest.miapp.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import com.dvptest.miapp.model.Ticket;
import com.dvptest.miapp.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
@Validated
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Operation(
        summary = "Registrar un nuevo ticket",
        description = "Registra un nuevo ticket asociado a un usuario existente en la base de datos y retorna el JSON con los atributos registrados",
        responses = {
            @ApiResponse(responseCode = "400", description = "Error en los valores especificados para el ticket"),
            @ApiResponse(responseCode = "200", description = "Ticket registrado en la base de datos")
        }
    )
    @PostMapping
    public Ticket crearTicket(@RequestBody Ticket ticket) {
        //TODO: process POST request
        
        return ticketService.crearTicket(ticket);
    }

    @Operation(
        summary = "Actualiza un ticket",
        description = "Actualiza un ticket existente y retorna el JSON con los atributos registrados",
        responses = {
            @ApiResponse(responseCode = "400", description = "Error en los valores especificados para el ticket"),
            @ApiResponse(responseCode = "200", description = "Ticket registrado en la base de datos")
        }
    )
    @PutMapping("/{id}")
    public Ticket actualizarTicket(@PathVariable UUID id, @RequestBody Ticket ticket) {
        //TODO: process PUT request
        
        return ticketService.actualizarTicket(id, ticket);
    }

    @Operation(
        summary = "Elimina un ticket por id",
        description = "Elimina un ticket basado en un id",
        responses = {
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado o no válido"),
            @ApiResponse(responseCode = "200", description = "Ticket eliminado de la base de datos")
        }
    )
    @DeleteMapping
    public void eliminarTicket(@PathVariable UUID id){
        ticketService.eliminarTicket(id);
    }

    @Operation(
        summary = "Obtener un ticket por id",
        description = "Obtiene un ticket basado en el id",
        responses = {
            @ApiResponse(responseCode = "400", description = "Error en los valores especificados para el ticket"),
            @ApiResponse(responseCode = "200", description = "Ticket registrado en la base de datos",
            content = @Content(schema = @Schema(implementation = Ticket.class)))
        }
    )
    @GetMapping("/{id}")
    public Optional<Ticket> obtenerTicket(@PathVariable UUID id) {
        return ticketService.obtenerTicketxId(id);
    }
    
    @Operation(
        summary = "Obtener tickets por página",
        description = "Obtener un listado de tickets por página",
        responses = {
            @ApiResponse(responseCode = "400", description = "Error en los valores especificados para el ticket"),
            @ApiResponse(responseCode = "200", 
                description = "Ticket registrado en la base de datos",
                content = @Content(mediaType = "application/json", 
                    array = @ArraySchema(schema = @Schema(implementation = Ticket.class)))
            )
        }
    )
    @GetMapping
    public Page<Ticket> listarTickets(@RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "5") int tamano) {
            Pageable paginable = PageRequest.of(pagina, tamano);
        return ticketService.obtenerTicketsxPagina(paginable);
    }
    
    
}
