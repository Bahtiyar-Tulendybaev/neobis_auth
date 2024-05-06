package com.example.neo_auth_project.exception;

public class RegistrationTokenExpiredException extends RuntimeException{
    public RegistrationTokenExpiredException(String message) {
        super(message);
    }

}
