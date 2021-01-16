package com.opensourcedev.ticketmanager.exceptions.exceptionHandlers;

import com.opensourcedev.ticketmanager.exceptions.ChangeTicketException;
import com.opensourcedev.ticketmanager.exceptions.IncidentException;

import com.opensourcedev.ticketmanager.exceptions.TicketException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    Map<String, Object> body;


    @ExceptionHandler(ChangeTicketException.class)
    public ResponseEntity<Object> handleChangeTicketExceptions(ChangeTicketException exception){
        body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());
        body.put("status", exception.getStatus());

        return new ResponseEntity<>(body, exception.getStatus());
    }

    @ExceptionHandler(IncidentException.class)
    public ResponseEntity<Object> handleIncidentException(IncidentException exception){
        body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());
        body.put("status", exception.getStatus());

        return new ResponseEntity<>(body, exception.getStatus());
    }

    @ExceptionHandler(TicketException.class)
    public ResponseEntity<Object> handleTicketException(TicketException exception){
        body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());
        body.put("status", exception.getStatus());

        return new ResponseEntity<>(body, exception.getStatus());
    }
}
