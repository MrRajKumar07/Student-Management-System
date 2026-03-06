package com.example.studentManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
	
	@NotBlank(message="Username is required")
    String username;
	
	@NotBlank(message="password is required")
    String password;
}
