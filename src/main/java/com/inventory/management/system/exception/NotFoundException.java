// Custom exception used when a requested resource is not found in the system.
package com.inventory.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) { // Constructor that accepts a message which describes the missing resource.
        super(message); // Passes the message to the RuntimeException class
    }
}
