package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.CourseDTO;
import com.example.studentManagementSystem.mapper.CourseMapper;
import com.example.studentManagementSystem.model.Course;
import com.example.studentManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        return courseMapper.toDTO(courseRepository.save(course));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseMapper.toDTO(course);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {

        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existing.setCourseName(courseDTO.getCourseName());
        existing.setCourseCode(courseDTO.getCourseCode());
        existing.setInstructor(courseDTO.getInstructor());
        existing.setCredits(courseDTO.getCredits());

        return courseMapper.toDTO(courseRepository.save(existing));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}