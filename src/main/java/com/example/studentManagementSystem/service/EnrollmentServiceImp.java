package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.EnrollmentDTO;
import com.example.studentManagementSystem.exception.ResourceNotFoundException;
import com.example.studentManagementSystem.mapper.EnrollmentMapper;
import com.example.studentManagementSystem.model.Course;
import com.example.studentManagementSystem.model.Enrollment;
import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.repository.CourseRepository;
import com.example.studentManagementSystem.repository.EnrollmentRepostitory;
import com.example.studentManagementSystem.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImp implements EnrollmentService {

    private final EnrollmentRepostitory enrollmentRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public EnrollmentDTO enrollStudent(EnrollmentDTO enrollmentDTO){
    	
        Student student = studentRepo.findById(enrollmentDTO.getStudentId())
        		.orElseThrow(()-> new ResourceNotFoundException("Student Id "+enrollmentDTO.getStudentId()+"invalid"));
        
        Course course = courseRepo.findById(enrollmentDTO.getCourseId())
        		.orElseThrow(()->  new ResourceNotFoundException("Student Id "+enrollmentDTO.getCourseId()+"invalid"));
        

        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDTO);
        enrollment.setStudent(student); //establishing Many-to-one
        enrollment.setCourse(course); //establishing Many-to-one
        enrollment.setEnrollmentDate(LocalDate.now());
        
        return enrollmentMapper.toDTO(enrollmentRepo.save(enrollment));
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentByStudent(Long studentId) {
        return enrollmentRepo.findByStudentId(studentId)
                .stream()
                .map(enrollmentMapper::toDTO)
                .toList();
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentByCourse(Long courseId){
        return enrollmentRepo.findByCourseId(courseId)
                .stream()
                .map(enrollmentMapper::toDTO)
                .toList();
    }

    @Override
    public EnrollmentDTO updateEnrollmentStatus(Long id, String status) {
        Enrollment enrollment = enrollmentRepo.findById(id)
        		.orElseThrow(() ->new ResourceNotFoundException("Enrollment not found"));

        enrollment.setStatus(status);

        return enrollmentMapper.toDTO(enrollmentRepo.save(enrollment));
    }
}
