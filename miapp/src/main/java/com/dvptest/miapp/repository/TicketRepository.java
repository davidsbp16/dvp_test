package com.dvptest.miapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvptest.miapp.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, UUID>{
    
}
