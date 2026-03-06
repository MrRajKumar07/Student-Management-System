package com.example.studentManagementSystem.controller;

import java.util.List;

import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping
	public StudentDTO createStudent(@Valid @RequestBody StudentDTO studentDTO) {
		return studentService.createStudent(studentDTO);
	}

	@PutMapping("/{id}")
	public StudentDTO updateStudent(@PathVariable Long id,
									@Valid @RequestBody StudentDTO studentDTO) {
		return studentService.updateStudent(id, studentDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@GetMapping
	public List<StudentDTO> getAllStudents() {
		return studentService.getAllStudent();
	}
}