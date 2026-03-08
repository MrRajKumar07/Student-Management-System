package com.example.studentManagementSystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {

    private Long id;
    
    @NotBlank(message="Course name is Required")
    private String courseName;
    
    @Size(min=20, max=120, message ="description must be between 20 and 120 charachters")
    private String description;
    
    @NotNull(message ="credits are required")
    @Min(value = 1, message="Course must be worth at least 1 credit")
    @Max(value= 6, message ="Course cannot exceed 6 credits")
    private Integer credits;
    
    @NotNull(message = "Course capacity is required")
    @Min(value = 4, message = "Minimum capacity must be 4 Student")
    private Integer capacity;
    
    @NotBlank(message ="Duration is required (e.g., '4 Months')")
    private String duration; // duration e.g 4 Months or 4 Days or 4 Weeks
}
