package com.opensourcedev.ticketmanager.service;

import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class IncidentInterfaceImpl implements IncidentInterface {

    private final IncidentRepository incidentRepository;

    public IncidentInterfaceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }


    @Override
    public Set<Incident> findAll(String id) {
        Set<Incident> incidents = new HashSet<>();
        incidentRepository.findAll().forEach(incidents::add);
        return incidents;
    }

    @Override
    public Incident findById(String id) {
        return incidentRepository.findById(id).orElse(new Incident());
    }

    @Override
    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public void deleteById(String id) {
        incidentRepository.deleteById(id);
    }
}
