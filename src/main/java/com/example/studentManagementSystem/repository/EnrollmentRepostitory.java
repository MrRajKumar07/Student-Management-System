package com.example.studentManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentManagementSystem.model.Enrollment;

@Repository
public interface EnrollmentRepostitory extends JpaRepository<Enrollment, Long> {

	boolean existsByStudentIdAndCourseId(Long StudentId, Long CourseId);
	long countByCourseId(Long courseId);
	List<Enrollment> findByStudentId(Long studentId);
	List<Enrollment> findByCourseId(Long courseId);
}
