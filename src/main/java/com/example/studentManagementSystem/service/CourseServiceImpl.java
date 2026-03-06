package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.service.CourseService;
import com.example.studentManagementSystem.dto.CourseDTO;
import com.example.studentManagementSystem.exception.ResourceNotFoundException;
import com.example.studentManagementSystem.mapper.CourseMapper;
import com.example.studentManagementSystem.model.Course;
import com.example.studentManagementSystem.repository.CourseRepository;
//.

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override

    public CourseDTO createCourse(CourseDTO dto) {

        Course course = courseMapper.toEntity(dto);
        Course saved = courseRepository.save(course);

        return courseMapper.toDTO(saved);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO dto) {

        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        existing.setCourseName(dto.getCourseName());
        existing.setDescription(dto.getDescription());
        existing.setCredits(dto.getCredits());
        existing.setDuration(dto.getDuration());

        Course updated = courseRepository.save(existing);

        return courseMapper.toDTO(updated);
    }

    @Override
    public void deleteCourse(Long id) {
    	if(!courseRepository.existsById(id)){
			throw new ResourceNotFoundException("Course Not Found");
		}
    	courseRepository.deleteById(id);
    }

    @Override
    public CourseDTO getCourseById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        return courseMapper.toDTO(course);
    }

    @Override
    public List<CourseDTO> getAllCourses() {

        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }
}