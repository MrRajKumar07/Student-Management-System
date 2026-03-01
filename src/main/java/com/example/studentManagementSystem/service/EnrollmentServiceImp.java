package com.example.studentManagementSystem.service;


import com.example.studentManagementSystem.model.Enrollment;
import com.example.studentManagementSystem.model.*;
import com.example.studentManagementSystem.repository.EnrollmentRepostitory;
import com.example.studentManagementSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImp implements EnrollmentService {

    private final EnrollmentRepostitory enrollmentRepo;
    private final StudentRepository studentRepo;
    private final CourserRepository courseRepo;

    @Override
    public Enrollment enrollStudent(Long studentId, Long courseId){

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // 2️⃣ Validate course exists
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // 3️⃣ Prevent duplicate enrollment
        boolean alreadyEnrolled = enrollmentRepo
                .existsByStudentIdAndCourseId(studentId, courseId);

        if (alreadyEnrolled) {
            throw new RuntimeException("Student already enrolled in this course");
        }

        // 4️⃣ Create enrollment
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepo.save(enrollment);

    }

    @Override
    public void deleteEnrollment(Long id) {
        if (!enrollmentRepo.existsById(id)) {
            throw new RuntimeException("Enrollment not found");
        }
        enrollmentRepo.deleteById(id);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

}
