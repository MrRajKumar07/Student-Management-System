package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.CourseDTO;
import com.example.studentManagementSystem.service.CourseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO dto) {
        return courseService.createCourse(dto);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable Long id,
                                  @RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }
}