package com.opensourcedev.ticketmanager.controller;

import com.opensourcedev.ticketmanager.dto.IncidentDto;
import com.opensourcedev.ticketmanager.mappers.IncidentMapper;
import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.service.IncidentService;
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
@RequestMapping({"/incident", "/Incident"})
public class IncidentController {

    private final IncidentMapper incidentMapper = Mappers.getMapper(IncidentMapper.class);
    private final IncidentService incidentService;
    public static final String BASE_URL = "http://localhost:8080/incident/";


    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }



    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<IncidentDto>> findAllTickets(){
        Set<IncidentDto> incidentDtos = new HashSet<>();
        incidentService.findAll().forEach(incident -> {
            IncidentDto incidentDto = incidentMapper.incidentToIncidentDto(incident);
            incidentDtos.add(incidentDto);
        });
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(incidentDtos);
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IncidentDto> findbyId(@PathVariable String id){
        IncidentDto incidentDto = incidentMapper.incidentToIncidentDto(incidentService.findById(id));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(incidentDto);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated IncidentDto incidentDto){
        Incident mappedIncident = incidentMapper.incidentDtoToIncident(incidentDto);
        Incident savedIncident = incidentService.save(mappedIncident);
        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedIncident.getIncidentId()))
                .body("Incident has been saved");
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable String id){
        incidentService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Incident with ID: " + id + " has been deleted");
    }
}
