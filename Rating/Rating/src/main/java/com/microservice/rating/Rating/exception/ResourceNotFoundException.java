package com.microservice.rating.Rating.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource Not Found On the Server !!!!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
