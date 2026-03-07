package com.example.studentManagementSystem.mapper;

import org.springframework.stereotype.Component;

import com.example.studentManagementSystem.dto.RegisterDTO;
import com.example.studentManagementSystem.model.User;

@Component
public class AuthMapper {
	
    public User toEntity(RegisterDTO dto) {
    	if(dto == null) return null;
    	
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }

    public RegisterDTO toDTO(User user) {
    	if(user == null) return null;
    	
        RegisterDTO dto = new RegisterDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        
        if(user.getRole() != null) {
        	dto.setRoleName(user.getRole().getRoleName());
        }
        
        return dto;
    }
}
