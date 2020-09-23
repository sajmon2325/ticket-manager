package com.opensourcedev.ticketmanager.service;

import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import com.opensourcedev.ticketmanager.repository.ChangeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ChangeInterfaceImpl implements ChangeInterface {

    private final ChangeRepository changeRepository;

    public ChangeInterfaceImpl(ChangeRepository changeRepository) {
        this.changeRepository = changeRepository;
    }



    @Override
    public Set<ChangeTicket> findAll(String id) {
        Set<ChangeTicket> changeTickets = new HashSet<>();
        changeRepository.findAll().forEach(changeTickets::add);
        return changeTickets;
    }

    @Override
    public ChangeTicket findById(String id) {
        return changeRepository.findById(id).orElse(new ChangeTicket());
    }

    @Override
    public ChangeTicket save(ChangeTicket changeTicket) {
        return changeRepository.save(changeTicket);
    }

    @Override
    public void deleteById(String id) {
        changeRepository.deleteById(id);
    }
}
