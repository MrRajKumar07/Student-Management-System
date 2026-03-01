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
                .courseCode(course.getCourseCode())
                .instructor(course.getInstructor())
                .credits(course.getCredits())
                .build();
    }

    public Course toEntity(CourseDTO dto) {
        return Course.builder()
                .id(dto.getId())
                .courseName(dto.getCourseName())
                .courseCode(dto.getCourseCode())
                .instructor(dto.getInstructor())
                .credits(dto.getCredits())
                .build();
    }
}