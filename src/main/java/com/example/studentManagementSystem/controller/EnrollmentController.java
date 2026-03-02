package com.example.studentManagementSystem.controller;


import com.example.studentManagementSystem.dto.EnrollmentDTO;
import com.example.studentManagementSystem.model.Enrollment;
import com.example.studentManagementSystem.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDTO> enrollStudent(
            @RequestBody EnrollmentDTO request){
        EnrollmentDTO enrollment = enrollmentService.enrollStudent(request);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(
                enrollmentService.getEnrollmentByStudent(studentId)
        );

    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentByCourseId(@PathVariable Long courseId){
        return ResponseEntity.ok(
                enrollmentService.getEnrollmentByCourse(courseId)
        );

    }

    @PutMapping("/{id}/status")
    public ResponseEntity<List<Enrollment>> updateStatus(@PathVariable Long id, @RequestParam String status){
        return ResponseEntity.ok((List<Enrollment>) enrollmentService.updateEnrollmentStatus(id, status));
    }

}
