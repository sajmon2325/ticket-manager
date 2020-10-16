package com.opensourcedev.ticketmanager.controller;

import com.opensourcedev.ticketmanager.dto.TicketDto;
import com.opensourcedev.ticketmanager.mappers.TicketMapper;
import com.opensourcedev.ticketmanager.model.items.Ticket;
import com.opensourcedev.ticketmanager.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping({"/ticket", "/Ticket"})
public class TicketController {

    private final TicketMapper ticketMapper = Mappers.getMapper(TicketMapper.class);
    private final TicketService ticketService;
    public static final String BASE_URL = "http://localhost:8080/ticket/";


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TicketDto>> findAllTickets(){
        Set<TicketDto> ticketDtos = new HashSet<>();
        ticketService.findAll().forEach(ticket -> {
            TicketDto ticketDto = ticketMapper.ticketToTicketDto(ticket);
            ticketDtos.add(ticketDto);
        });
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ticketDtos);
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDto> findbyId(@PathVariable String id){
        TicketDto ticketDto = ticketMapper.ticketToTicketDto(ticketService.findById(id));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ticketDto);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated TicketDto ticketDto){
        Ticket mappedTicket = ticketMapper.ticketDtoToTicket(ticketDto);
        Ticket savedIncident = ticketService.save(mappedTicket);
        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedIncident.getTicketId()))
                .body("Ticket has been saved");
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable String id){
        ticketService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Ticket with ID: " + id + " has been deleted");
    }
}
