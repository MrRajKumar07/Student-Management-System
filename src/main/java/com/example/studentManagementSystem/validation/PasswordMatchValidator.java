package com.example.studentManagementSystem.validation;

import com.example.studentManagementSystem.dto.RegisterDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterDTO> {
    @Override
    public boolean isValid(RegisterDTO dto, ConstraintValidatorContext context) {
        if (dto.getPassword() == null || dto.getConfirmPassword() == null) return false;
        return dto.getPassword().equals(dto.getConfirmPassword());
    }
}