package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO createCourse(CourseDTO dto);

    CourseDTO updateCourse(Long id, CourseDTO dto);

    void deleteCourse(Long id);

    CourseDTO getCourseById(Long id);

    List<CourseDTO> getAllCourses();
}