package com.opensourcedev.ticketmanager.exceptions;

import com.opensourcedev.ticketmanager.dto.IncidentDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class IncidentException extends RuntimeException{

    private final HttpStatus status;

    public IncidentException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public IncidentException(HttpStatus status, String message) {
        this.status = status;
    }

    private String errorMessage() {
        return status.value() + ":".concat(getMessage());
    }
}

