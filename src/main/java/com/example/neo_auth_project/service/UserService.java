package com.example.neo_auth_project.service;


import com.example.neo_auth_project.config.JwtUtil;
import com.example.neo_auth_project.dto.AuthenticationResponse;
import com.example.neo_auth_project.dto.LoginRequest;
import com.example.neo_auth_project.dto.UserDto;
import com.example.neo_auth_project.entity.Role;
import com.example.neo_auth_project.entity.User;
import com.example.neo_auth_project.exception.ResourceNotFoundException;
import com.example.neo_auth_project.exception.UserAlreadyExistsException;
import com.example.neo_auth_project.exception.UserNotFoundException;
import com.example.neo_auth_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
@Autowired
    private  UserRepository userRepository;
@Autowired
    private PasswordEncoder passwordEncoder;
@Autowired
    private  JwtUtil jwtUtil;
@Autowired
    private AuthenticationManager authenticationManager;

public ResponseEntity<User> findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));
        return ResponseEntity.ok(user);
    }

    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> deleteById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));
        userRepository.deleteById(id);
        return ResponseEntity.ok(user);
    }

    public void register(UserDto userDto) throws UserAlreadyExistsException {
        User user = new User();
                user.setName(userDto.getName());
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                user.setEmail(userDto.getEmail());
                user.setRole(Role.USER);
                user.setDateOfBirth(userDto.getDateOfBirth());
                user.setPhoneNumber(userDto.getPhoneNumber());
        if(userRepository.findByName(userDto.getName()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        userRepository.save(user);
    }
    public AuthenticationResponse login(LoginRequest request) throws UserNotFoundException {
        User user = userRepository.findByName(request.getLogin())
                .orElseThrow(UserNotFoundException::new);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        String userEmail = user.getEmail();
        var jwtToken = jwtUtil.generateToken(userEmail);
        System.out.println(jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }


}
