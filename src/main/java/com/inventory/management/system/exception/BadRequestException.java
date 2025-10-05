// Custom exception used when a client sends invalid or bad input.
package com.inventory.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) { // Constructor that accepts a custom error message.
        super(message); // Passes the message to the RuntimeException class
    }
}
