package com.example.studentManagementSystem.controller;

import com.example.studentManagementSystem.dto.EnrollmentDTO;
import com.example.studentManagementSystem.service.EnrollmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDTO> enrollStudent(
            @Valid @RequestBody EnrollmentDTO request) {

        EnrollmentDTO enrollment = enrollmentService.enrollStudent(request);
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByStudentId(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                enrollmentService.getEnrollmentByStudent(studentId)
        );
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByCourseId(
            @PathVariable Long courseId) {

        return ResponseEntity.ok(
                enrollmentService.getEnrollmentByCourse(courseId)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<EnrollmentDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        EnrollmentDTO updated = enrollmentService.updateEnrollmentStatus(id, status);
        return ResponseEntity.ok(updated);
    }
}