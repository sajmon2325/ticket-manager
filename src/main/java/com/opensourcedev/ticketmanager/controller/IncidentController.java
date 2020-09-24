package com.opensourcedev.ticketmanager.controller;

import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.service.IncidentInterface;
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
@RequestMapping({"/incident", "/Incident"})
public class IncidentController {

    private final IncidentInterface incidentInterface;
    public static final String BASE_URL = "http://localhost:8080/incident/";


    public IncidentController(IncidentInterface incidentInterface) {
        this.incidentInterface = incidentInterface;
    }



    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Incident>> findAllTickets(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(incidentInterface.findAll());
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Incident> findbyId(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(incidentInterface.findById(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated Incident incident){  //TODO replace with mapstruct and DTO
        Incident savedIncident = incidentInterface.save(incident);
        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedIncident.getIncidentId()))
                .body("Incident has been saved");
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable String id){
        incidentInterface.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Incident with ID: " + id + " has been deleted");
    }
}
