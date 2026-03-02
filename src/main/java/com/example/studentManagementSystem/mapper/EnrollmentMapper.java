package com.example.studentManagementSystem.mapper;

import com.example.studentManagementSystem.dto.EnrollmentResponseDTO;
import com.example.studentManagementSystem.model.Enrollment;

import java.time.LocalDateTime;


public class EnrollmentMapper {

    public EnrollmentResponseDTO toResponseDTO(Enrollment enrollment) {

        EnrollmentResponseDTO dto = new EnrollmentResponseDTO();

        dto.setId(enrollment.getId());
        dto.setStudentName(String.valueOf(enrollment.getStudentId()));
        dto.setStatus(enrollment.getStatus());
        dto.setEnrolledAt(LocalDateTime.from(enrollment.getEnrollmentDate()));

        return dto;
    }
}
