package com.example.neo_auth_project.dto;

import lombok.Data;


@Data

public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private String role;



}
