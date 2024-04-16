package com.example.Omar.utils.Exceptions;

public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException() {
        super("Resource Already exists");
    }

    public ResourceExistsException(String message) {
        super(message);
    }

}