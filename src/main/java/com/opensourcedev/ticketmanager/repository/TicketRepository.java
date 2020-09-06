package com.opensourcedev.ticketmanager.repository;

import com.opensourcedev.ticketmanager.model.items.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, String> {
}
