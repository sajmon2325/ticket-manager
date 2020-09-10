package com.opensourcedev.ticketmanager.repository;

import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRepository extends CrudRepository<ChangeTicket, String> {
}
