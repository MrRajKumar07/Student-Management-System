package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.EnrollmentDTO;
import com.example.studentManagementSystem.service.EnrollmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    public ResponseEntity<EnrollmentDTO> enrollStudent(@Valid @RequestBody EnrollmentDTO request) {

        EnrollmentDTO enrollment = enrollmentService.enrollStudent(request);
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByStudentId(@PathVariable("studentId") Long studentId) {

        return ResponseEntity.ok(enrollmentService.getEnrollmentByStudent(studentId));
    }

    @GetMapping("/course/{courseId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByCourseId(@PathVariable("courseId") Long courseId) {

        return ResponseEntity.ok(enrollmentService.getEnrollmentByCourse(courseId));
    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EnrollmentDTO> updateStatus(@PathVariable("id") Long id,
            @RequestParam("status") String status) {

        EnrollmentDTO updated = enrollmentService.updateEnrollmentStatus(id, status);
        return ResponseEntity.ok(updated);
    }
}