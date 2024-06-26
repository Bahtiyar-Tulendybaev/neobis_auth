package com.example.neo_auth_project.entity.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class RegistrationRequest {
    @Email
    String email;
    @Length(min = 8, max = 128)
    String password;
    @NotBlank
    String username;
}
