package com.dvptest.miapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvptest.miapp.model.Ticket;
import com.dvptest.miapp.service.TicketService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Ticket crearTicket(@RequestBody Ticket ticket) {
        //TODO: process POST request
        
        return ticketService.crearTicket(ticket);
    }

    @PutMapping("/{id}")
    public Ticket actualizarTicket(@PathVariable UUID id, @RequestBody Ticket ticket) {
        //TODO: process PUT request
        
        return ticketService.actualizarTicket(id, ticket);
    }

    @DeleteMapping
    public void eliminarTicket(@PathVariable UUID id){
        ticketService.eliminarTicket(id);
    }

    @GetMapping("/{id}")
    public Optional<Ticket> obtenerTicket(@PathVariable UUID id) {
        return ticketService.obtenerTicketxId(id);
    }
    
    @GetMapping
    public Page<Ticket> listarTickets(@RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "5") int tamano) {
            Pageable paginable = PageRequest.of(pagina, tamano);
        return ticketService.obtenerTicketsxPagina(paginable);
    }
    
    
}
