package com.example.studentManagementSystem.controller;


import com.example.studentManagementSystem.dto.EnrollmentRequestDTO;
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
    public ResponseEntity<Enrollment> enrollStudent(
            @RequestBody EnrollmentRequestDTO request){
        Enrollment enrollment = enrollmentService.enrollStudent(request.getStudentById().request.getCourseId());

        return ResponseEntity.ok(enrollment);
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments(){
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok("Deleted");
    }

}
