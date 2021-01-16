package com.opensourcedev.ticketmanager.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ChangeTicketException extends RuntimeException{

    private final HttpStatus status;

    public ChangeTicketException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public ChangeTicketException(HttpStatus status, String s) {
        this.status = status;
    }


    private String errorMessage() {
        return status.value() + ":".concat(getMessage());
    }
}

