package com.example.studentManagementSystem.service;

import com.example.studentManagementSystem.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(Long studentId);

    void deleteEnrollment(Long id);

    List<Enrollment> getAllEnrollments();
}
