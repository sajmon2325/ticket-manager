package com.opensourcedev.ticketmanager.exceptions.exceptionHandlers;

import com.opensourcedev.ticketmanager.exceptions.ChangeTicketException;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ChangeTicketException.class)
    public ResponseEntity<ChangeTicket> handleChangeTicketExceptions(WebRequest request, ChangeTicketException exception){
        
    }
}
