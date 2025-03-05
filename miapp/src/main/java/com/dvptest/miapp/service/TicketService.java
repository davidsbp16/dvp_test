package com.dvptest.miapp.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dvptest.miapp.model.Ticket;
import com.dvptest.miapp.repository.TicketRepository;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket crearTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket actualizarTicket(UUID id, Ticket ticketActualizado){
        return ticketRepository.findById(id)
            .map(t -> {
                t.setDescripcion(ticketActualizado.getDescripcion());
                t.setIdUsuario(ticketActualizado.getIdUsuario());
                t.setFechaActualizacion(ticketActualizado.getFechaActualizacion());
                t.setStatus(ticketActualizado.getStatus());
                return ticketRepository.save(t);
            })
            .orElseThrow(() -> new RuntimeException("Ticket no encontrado en la base de datos. No se puede actualizar"));
    }

    public void eliminarTicket(UUID id){
        ticketRepository.deleteById(id);
    }

    public Optional<Ticket> obtenerTicketxId(UUID id){
        return ticketRepository.findById(id);
    }

    public Page<Ticket> obtenerTicketsxPagina(Pageable pagina){
        return ticketRepository.findAll(pagina);
    }
}
