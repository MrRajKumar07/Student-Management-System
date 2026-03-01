package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.CourseDTO;
import java.util.List;

public interface CourseService {

    CourseDTO saveCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id);

    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourse(Long id);
}