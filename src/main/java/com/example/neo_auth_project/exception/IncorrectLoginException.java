package com.example.neo_auth_project.exception;

public class IncorrectLoginException extends RuntimeException{
    public IncorrectLoginException(String message) {
        super(message);
    }
}
