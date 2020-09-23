package com.opensourcedev.ticketmanager.service;

import com.opensourcedev.ticketmanager.model.items.Ticket;
import com.opensourcedev.ticketmanager.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TicketInterfaceImpl implements TicketInterface {

    private final TicketRepository ticketRepository;

    public TicketInterfaceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }



    @Override
    public Set<Ticket> findAll(String id) {
        Set<Ticket> tickets = new HashSet<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    @Override
    public Ticket findById(String id) {
        return ticketRepository.findById(id).orElse(new Ticket());
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(String id) {
        ticketRepository.deleteById(id);
    }
}
