package com.example.studentManagementSystem.mapper;

import com.example.studentManagementSystem.dto.CourseDTO;
import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.model.Course;
import com.example.studentManagementSystem.model.Student;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if(course == null) return null;
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setCredits(course.getCredits());
        dto.setDuration(course.getDuration());

        return dto;
    }


    public Course toEntity(CourseDTO dto) {
        if(dto == null) return null;
        Course course = new Course();
        course.setId(dto.getId());
        course.setCourseName(dto.getCourseName());
        course.setDescription(dto.getDescription());
        course.setCredits(dto.getCredits());
        course.setDuration(dto.getDuration());

        return course;
    }



}