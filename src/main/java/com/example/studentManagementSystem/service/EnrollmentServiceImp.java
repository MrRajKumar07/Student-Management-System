package com.example.studentManagementSystem.service;


import com.example.studentManagementSystem.dto.EnrollmentDTO;
import com.example.studentManagementSystem.mapper.EnrollmentMapper;
import com.example.studentManagementSystem.model.Enrollment;
import com.example.studentManagementSystem.repository.EnrollmentRepostitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImp implements EnrollmentService {

    private final EnrollmentRepostitory enrollmentRepo;
    private final EnrollmentMapper enrollmentMapper;
    private static final Long DEFAULT_COURSE_ID = 1L;


    @Override
    public EnrollmentDTO enrollStudent(EnrollmentDTO enrollmentDTO){
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDTO);
        enrollment.setCourseId(DEFAULT_COURSE_ID);
        Enrollment savedEnrollment = enrollmentRepo.save(enrollment);
        return enrollmentMapper.toDTO(savedEnrollment);
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentByStudent(Long studentId) {
        return enrollmentRepo.findById(studentId)
                .stream()
                .map(enrollmentMapper::toDTO)
                .toList();
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentByCourse(Long courseId){
        return enrollmentRepo.findById(courseId)
                .stream()
                .map(enrollmentMapper::toDTO)
                .toList();
    }

    @Override
    public EnrollmentDTO updateEnrollmentStatus(Long id, String status) {
        Enrollment enrollment = enrollmentRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Enrollment not found with id: " + id));

        enrollment.setStatus(status);

        return enrollmentMapper.toDTO(enrollmentRepo.save(enrollment));
    }
}
