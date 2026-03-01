package com.example.studentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentManagementSystem.model.Enrollment;


public interface EnrollmentRepostitory extends JpaRepository<Enrollment, Long> {

}
