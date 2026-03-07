package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.LoginDTO;
import com.example.studentManagementSystem.dto.RegisterDTO;
import com.example.studentManagementSystem.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        return authService.registerUser(registerDTO);
    }

    @PostMapping("/login")
    public String loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        return authService.loginUser(loginDTO);
    }
}