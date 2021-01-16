package com.opensourcedev.ticketmanager.exceptions;

import com.opensourcedev.ticketmanager.dto.TicketDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TicketException extends RuntimeException{

    private final HttpStatus status;
    private final TicketDto ticketDto;

    public TicketException(String message, Throwable cause, HttpStatus status, TicketDto ticketDto) {
        super(message, cause);
        this.status = status;
        this.ticketDto = ticketDto;
    }

    private String errorMessage() {
        return status.value() + ":".concat(getMessage());
    }
}
