package com.example.studentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagementSystem.dto.LoginDTO;
import com.example.studentManagementSystem.dto.RegisterDTO;
import com.example.studentManagementSystem.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
	@Autowired 
    private AuthService authService;

	@PostMapping("/register")
    public String register(@RequestBody RegisterDTO registerDTO) {
        return authService.registerUser(registerDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return authService.loginUser(loginDTO);
    }
}
