package com.example.neo_auth_project.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
    public UserNotFoundException(){
        super("Incorrect password or login");
    }
}
