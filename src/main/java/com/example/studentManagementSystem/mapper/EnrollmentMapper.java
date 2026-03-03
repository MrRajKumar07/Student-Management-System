package com.example.studentManagementSystem.mapper;

import com.example.studentManagementSystem.dto.EnrollmentDTO;
import com.example.studentManagementSystem.model.Enrollment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EnrollmentMapper {

    public EnrollmentDTO toDTO(Enrollment enrollment) {
        if (enrollment == null) return null;
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setId(enrollment.getId());
        enrollmentDTO.setStudentId(enrollment.getStudentId());
        enrollmentDTO.setCourseId(enrollment.getCourseId());
        enrollmentDTO.setEnrollmentDate(enrollment.getEnrollmentDate());
        enrollmentDTO.setStatus(enrollment.getStatus());
        return enrollmentDTO;
    }

    public Enrollment toEntity(EnrollmentDTO enrollmentDTO) {
        if (enrollmentDTO == null) return null;

        Enrollment enrollment = new Enrollment();
        enrollment.setId(enrollmentDTO.getId());
        enrollment.setStudentId(enrollmentDTO.getStudentId());
        enrollment.setCourseId(enrollmentDTO.getCourseId());
        enrollment.setEnrollmentDate(enrollmentDTO.getEnrollmentDate());
        enrollment.setStatus(enrollmentDTO.getStatus());
        return enrollment;
    }

}
