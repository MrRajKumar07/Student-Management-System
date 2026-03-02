package com.example.studentManagementSystem.dto;

import lombok.Data;

@Data
public class RegisterDTO {
	
    String username;
    String password;
    String email;
    String roleName;
}
