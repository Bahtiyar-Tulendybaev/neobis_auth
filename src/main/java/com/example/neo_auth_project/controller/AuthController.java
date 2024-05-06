package com.example.neo_auth_project.controller;

import com.example.neo_auth_project.entity.dto.request.LoginRequest;
import com.example.neo_auth_project.entity.dto.request.RegistrationRequest;
import com.example.neo_auth_project.entity.dto.response.LoginResponse;
import com.example.neo_auth_project.service.AuthService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public String registration(@RequestBody @Valid RegistrationRequest request) {
        return authService.registration(request);
    }

    @PutMapping("/confirm-registration")
    public String confirmRegistration(@RequestParam(name = "token") @NotBlank String token) {
        return authService.confirmRegistration(token);
    }

    @PutMapping("/send-message")
    public String resendMessage(@RequestBody @Valid RegistrationRequest request,
                                 @RequestParam(name = "link") String link) {
        return authService.sendMessage(request, link);
    }

    @PostMapping("/sign-in")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }
}
