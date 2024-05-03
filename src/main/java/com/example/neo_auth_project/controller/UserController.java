package com.example.neo_auth_project.controller;

import com.example.neo_auth_project.dto.AuthenticationResponse;
import com.example.neo_auth_project.dto.LoginRequest;
import com.example.neo_auth_project.dto.UserDto;
import com.example.neo_auth_project.exception.UserAlreadyExistsException;
import com.example.neo_auth_project.exception.UserNotFoundException;
import com.example.neo_auth_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllCustomer() {

        return ResponseEntity.ok().body(userService.getAllCustomer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(userService.deleteById(id));

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto request) {
        try {
            userService.register(request);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        AuthenticationResponse authenticationResponse;
        try {
            authenticationResponse = userService.login(request);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(authenticationResponse);
    }

}



