package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.dto.EnrollmentDTO;
import com.example.studentManagementSystem.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO enrollStudent(EnrollmentDTO enrollmentDTO);

    List<EnrollmentDTO> getEnrollmentByStudent(Long studentId);

    List<EnrollmentDTO> getEnrollmentByCourse(Long courseId);

    EnrollmentDTO updateEnrollmentStatus(Long id, String status);

}
