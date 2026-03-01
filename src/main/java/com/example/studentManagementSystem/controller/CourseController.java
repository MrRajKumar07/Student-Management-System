package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.CourseDTO;
import com.example.studentManagementSystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.saveCourse(courseDTO);
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable Long id,
                                  @RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully!";
    }
}