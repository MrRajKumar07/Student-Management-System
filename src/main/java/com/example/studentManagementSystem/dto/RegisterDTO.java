package com.example.studentManagementSystem.dto;

import com.example.studentManagementSystem.validation.PasswordMatch;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatch(message = "Passwords do not match..!")
public class RegisterDTO {
	
	@NotBlank(message = "Username cannot be Empty")
	@Size(min=4, max=15, message = "Username Must be between 4 and 15 characters")
    private String username;
	
	@NotBlank(message = " password is required")
	@Size(min = 8, message ="password must be at least 8 charachters")
    private String password;
	
	@NotBlank(message = "please confirm your password")
	private String confirmPassword;
	
	@NotBlank(message ="Email is required")
	@Email(message = "please provide valid email address")
    String email;
	
	@NotBlank(message ="Role name is required")
    String roleName;
}
