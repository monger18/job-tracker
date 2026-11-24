package com.satyam.jobtracker.common.exception;

// Thrown by services when something does not exist. Handled as HTTP 404.
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
