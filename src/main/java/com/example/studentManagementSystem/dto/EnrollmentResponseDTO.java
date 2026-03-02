package com.example.studentManagementSystem.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EnrollmentResponseDTO {

    private Long id;
    private String studentName;
    private String courseName;
    private String status;
    private LocalDateTime enrolledAt;
}