package com.example.studentManagementSystem.dto;

import lombok.Data;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
public class EnrollmentDTO {
    
	private Long id;
    
	@NotNull(message="Student id must be required for enrollment")
    private Long studentId;
	
	@NotNull(message="Course id must be required for enrollment")
    private Long courseId;
	
	@FutureOrPresent(message="Enrollment date cannot be in the past")
    private LocalDate enrollmentDate;
	
	@NotBlank(message="status is required")
	@Pattern(regexp ="^(ACTIVE|COMPLETED|DROPPED)$", message="Status must be ACTIVE, COMPLETED or DROPPED")
    private String status;

}
