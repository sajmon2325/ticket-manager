package com.opensourcedev.ticketmanager.controller;

import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import com.opensourcedev.ticketmanager.service.ChangeInterface;
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
@RequestMapping({"/change", "/Change"})
public class ChangeTicketController {

    private final ChangeInterface changeInterface;
    public static final String BASE_URL = "http://localhost:8080/change/";


    public ChangeTicketController(ChangeInterface changeInterface) {
        this.changeInterface = changeInterface;
    }



    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<ChangeTicket>> findAllTickets(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(changeInterface.findAll());
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChangeTicket> findById(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(changeInterface.findById(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated ChangeTicket changeTicket){  //TODO replace with mapstruct and DTO
        ChangeTicket savedTicket = changeInterface.save(changeTicket);
        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedTicket.getChangeId()))
                .body("Change Ticket has been saved");
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable String id){
        changeInterface.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Change Ticket with ID: " + id + " has been deleted");
    }
}
