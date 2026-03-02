package com.example.studentManagementSystem.mapper;

import org.springframework.stereotype.Component;

import com.example.studentManagementSystem.dto.RegisterDTO;
import com.example.studentManagementSystem.model.User;

@Component
public class AuthMapper {
	
    public User toEntity(RegisterDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRoleName());
        return user;
    }

    public RegisterDTO toDTO(User user) {
        RegisterDTO dto = new RegisterDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRoleName(user.getRole());
        return dto;
    }
}
