package com.satyam.jobtracker.common.exception;

// Thrown when the request clashes with existing data, e.g. email already registered. HTTP 409.
public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
