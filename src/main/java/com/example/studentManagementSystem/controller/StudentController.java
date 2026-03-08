package com.example.studentManagementSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService studentService;

	@GetMapping
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("This is my First Api Testing");
	}

	@PostMapping("/save")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO) {
		StudentDTO student = studentService.createStudent(studentDTO);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id,
			@Valid @RequestBody StudentDTO studentDTO) {

		StudentDTO updated = studentService.updateStudent(id, studentDTO);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
		StudentDTO student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}

	@GetMapping("/all")
	public ResponseEntity<List<StudentDTO>> getAllStudent() {
		return ResponseEntity.ok(studentService.getAllStudent());
	}
}