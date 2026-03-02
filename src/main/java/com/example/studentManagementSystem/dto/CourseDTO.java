package com.example.studentManagementSystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {

    private Long id;
    private String courseName;
    private String description;
    private Integer credits;
    private String duration;
}
