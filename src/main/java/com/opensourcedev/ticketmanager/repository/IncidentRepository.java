package com.opensourcedev.ticketmanager.repository;

import com.opensourcedev.ticketmanager.model.items.Incident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends CrudRepository<Incident, String> {
}
