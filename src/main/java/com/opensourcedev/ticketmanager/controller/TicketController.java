package com.opensourcedev.ticketmanager.controller;

import com.opensourcedev.ticketmanager.dto.TicketDto;
import com.opensourcedev.ticketmanager.mappers.TicketMapper;
import com.opensourcedev.ticketmanager.model.items.Ticket;
import com.opensourcedev.ticketmanager.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@Api(tags = {"Ticker REST API"})
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


    @ApiOperation(value = "Returns a list of all tickets",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to find all Tickets was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TicketDto>> findAllTickets(){
        Set<TicketDto> ticketDtos = new HashSet<>();
        ticketService.findAll().forEach(ticket -> {
            TicketDto ticketDto = ticketMapper.ticketToTicketDto(ticket);
            ticketDtos.add(ticketDto);
        });
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ticketDtos);
    }

    @ApiOperation(value = "Returns a ticket based on ticket ID",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to find a specific Ticket was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDto> findbyId(@PathVariable String id){
        TicketDto ticketDto = ticketMapper.ticketToTicketDto(ticketService.findById(id));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ticketDto);
    }

    @ApiOperation(value = "Persists a ticket to database",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to save a Ticket was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated TicketDto ticketDto){
        Ticket mappedTicket = ticketMapper.ticketDtoToTicket(ticketDto);
        Ticket savedIncident = ticketService.save(mappedTicket);
        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedIncident.getTicketId()))
                .body("Ticket has been saved");
    }

    @ApiOperation(value = "Deletes a ticket based on ticket ID",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to delete a Ticket was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable String id){
        ticketService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Ticket with ID: " + id + " has been deleted");
    }
}
