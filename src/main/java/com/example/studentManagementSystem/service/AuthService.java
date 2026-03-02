package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.LoginDTO;
import com.example.studentManagementSystem.dto.RegisterDTO;

public interface AuthService {
	
    String registerUser(RegisterDTO registerDTO);
    String loginUser(LoginDTO loginDTO);
}
