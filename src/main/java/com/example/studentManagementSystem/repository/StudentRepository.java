package com.example.studentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentManagementSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

	
//	sql commands
}
