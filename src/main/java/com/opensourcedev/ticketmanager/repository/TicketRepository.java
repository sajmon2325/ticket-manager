package com.opensourcedev.ticketmanager.repository;

import com.opensourcedev.ticketmanager.model.items.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {
}
