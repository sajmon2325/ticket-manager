package com.opensourcedev.ticketmanager.controller;

import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.model.items.Ticket;
import com.opensourcedev.ticketmanager.service.IncidentInterface;
import com.opensourcedev.ticketmanager.service.TicketInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping({"/ticket", "/Ticket"})
public class TicketController {


    private final TicketInterface ticketInterface;
    public static final String BASE_URL = "http://localhost:8080/ticket/";


    public TicketController(TicketInterface ticketInterface) {
        this.ticketInterface = ticketInterface;
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Ticket>> findAllTickets(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ticketInterface.findAll());
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> findbyId(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ticketInterface.findById(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated Ticket ticket){  //TODO replace with mapstruct and DTO
        Ticket savedIncident = ticketInterface.save(ticket);
        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedIncident.getTicketId()))
                .body("Ticket has been saved");
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable String id){
        ticketInterface.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Ticket with ID: " + id + " has been deleted");
    }
}
