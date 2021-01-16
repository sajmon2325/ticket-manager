package com.opensourcedev.ticketmanager.controller;


import com.opensourcedev.ticketmanager.dto.ChangeTicketDto;
import com.opensourcedev.ticketmanager.exceptions.ChangeTicketException;
import com.opensourcedev.ticketmanager.mappers.ChangeTicketMapper;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import com.opensourcedev.ticketmanager.service.ChangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Api(tags = {"Change Ticker REST API"})
@RestController
@Slf4j
@RequestMapping({"/change"})
public class ChangeTicketController {
    // TODO add Request Param to advanced queries
    private final ChangeTicketMapper changeTicketMapper = Mappers.getMapper(ChangeTicketMapper.class);
    private final ChangeService changeService;
    public static final String BASE_URL = "http://localhost:8080/change/";


    public ChangeTicketController(ChangeService changeService) {
        this.changeService = changeService;
    }


    @ApiOperation(value = "Returns a list of all change tickets",
                  notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to find all Change tickets was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<ChangeTicketDto>> findAllTickets(){
        Set<ChangeTicketDto> changeTicketDtos = new HashSet<>();
        changeService.findAll().forEach(changeTicket -> {
            ChangeTicketDto changeTicketDto = changeTicketMapper.changeTicketToChangeTicketDto(changeTicket);
            changeTicketDtos.add(changeTicketDto);
        });

        if (changeTicketDtos.isEmpty()){
            throw new ChangeTicketException(HttpStatus.NOT_FOUND, "Unable to find change ticket entities");
        }else {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(changeTicketDtos);
        }

    }

    @ApiOperation(value = "Returns a change ticket based on his ID",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to find a specific Change ticket was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChangeTicketDto> findById(@PathVariable String id){
        ChangeTicketDto changeTicketDto = changeTicketMapper.changeTicketToChangeTicketDto(changeService.findById(id));

        if(changeTicketDto == null){
            throw new ChangeTicketException(HttpStatus.NOT_FOUND, "Unable to find Change Ticket with ID: ".concat(id));
        }else{
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(changeTicketDto);
        }
    }

    @ApiOperation(value = "Persists change ticket to database",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to save Change ticket was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })


   @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Validated ChangeTicketDto changeTicketDto, BindingResult bindingResult){
        ChangeTicket mappedChangeTicket = changeTicketMapper.changeTicketDtoToChangeTicket(changeTicketDto);
        ChangeTicket savedTicket = changeService.save(mappedChangeTicket);

        if (bindingResult.hasErrors()){
            throw new ChangeTicketException(HttpStatus.BAD_REQUEST, "Cannot save this type of change ticket");
        }

        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedTicket.getChangeId()))
                .body("Change Ticket has been saved");
    }

    @ApiOperation(value = "Deletes a change tickets based on his ID",
            notes = "${api.common.detailedDescription.notes}"
    )
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "OK, Request to delete a specific Change ticket was processed fine"),
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request"),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fail"),
            @ApiResponse(code = 401, message = "Unauthorized, this user is not authorized for this kind of operation")
    })
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        changeService.deleteById(id);

        if (id.isBlank()){
            throw new ChangeTicketException(HttpStatus.BAD_REQUEST, "URL doesn't contain id or unsupported id is used");
        }else {
            return ResponseEntity.ok(HttpStatus.OK + " Change Ticket with ID: " + id + " has been deleted");

        }
    }


}

//consumes = MediaType.APPLICATION_JSON_VALUE
