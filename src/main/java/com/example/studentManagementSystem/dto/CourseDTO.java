package com.example.studentManagementSystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {

    private Long id;
    private String courseName;
    private String courseCode;
    private String instructor;
    private Integer credits;
}
