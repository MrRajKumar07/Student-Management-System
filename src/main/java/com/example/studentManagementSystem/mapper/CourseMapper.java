package com.example.studentManagementSystem.mapper;

import com.example.studentManagementSystem.dto.CourseDTO;
import com.example.studentManagementSystem.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .duration(course.getDuration())
                .build();
    }

    public Course toEntity(CourseDTO dto) {
        return Course.builder()
                .id(dto.getId())
                .courseName(dto.getCourseName())
                .description(dto.getDescription())
                .credits(dto.getCredits())
                .duration(dto.getDuration())
                .build();
    }
}