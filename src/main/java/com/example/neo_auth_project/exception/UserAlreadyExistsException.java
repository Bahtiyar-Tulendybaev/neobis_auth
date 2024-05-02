package com.example.neo_auth_project.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message){
        super("User Already Exists" + message);
    }

    public UserAlreadyExistsException() {
        super("User Already Exists");
    }
}
