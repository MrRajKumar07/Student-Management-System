package com.example.studentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

	
	//Field Based 
//	@Autowired
//	StudentService studentService;
	
	//Constructor Based
	private final StudentService studentService;
	
	@GetMapping()
	public String test() {
		return "This is my First Api Testing";
	}
	
	@PostMapping("/save")
	public Student addStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
}
