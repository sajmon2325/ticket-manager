package com.opensourcedev.ticketmanager.controller;

import com.opensourcedev.ticketmanager.dto.IncidentDto;
import com.opensourcedev.ticketmanager.mappers.IncidentMapper;
import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.service.IncidentService;
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

@Api(tags = {"Incident REST API"})
@RestController
@Slf4j
@RequestMapping({"/incident"})
public class IncidentController {

    private final IncidentMapper incidentMapper = Mappers.getMapper(IncidentMapper.class);
    private final IncidentService incidentService;
    public static final String BASE_URL = "http://localhost:8080/incident/";


    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }


    @ApiOperation(value = "Returns a list of all incidents",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to find all Incidents was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<IncidentDto>> findAllTickets(){
        Set<IncidentDto> incidentDtos = new HashSet<>();
        incidentService.findAll().forEach(incident -> {
            IncidentDto incidentDto = incidentMapper.incidentToIncidentDto(incident);
            incidentDtos.add(incidentDto);
        });
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(incidentDtos);
    }

    @ApiOperation(value = "Returns a specific incident based on incident ID",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to find a specific Incident was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IncidentDto> findbyId(@PathVariable String id){
        IncidentDto incidentDto = incidentMapper.incidentToIncidentDto(incidentService.findById(id));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(incidentDto);
    }

    @ApiOperation(value = "Persists incident to database",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to save a specific Incident was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated IncidentDto incidentDto){
        Incident mappedIncident = incidentMapper.incidentDtoToIncident(incidentDto);
        Incident savedIncident = incidentService.save(mappedIncident);
        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedIncident.getIncidentId()))
                .body("Incident has been saved");
    }

    @ApiOperation(value = "Deletes a specific incident based on incident ID",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to delete a specific Incident was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        incidentService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK + " Incident with ID: " + id + " has been deleted");
    }
}
