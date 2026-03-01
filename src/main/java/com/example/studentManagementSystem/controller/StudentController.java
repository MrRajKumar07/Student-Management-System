package com.example.studentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

//	@Autowired
//	StudentService studentService;

	private final StudentService studentService;
	
	@GetMapping()
	public String test() {
		return "This is my First Api Testing";
	}
	
	@PostMapping("/save")
	public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.createStudent(studentDTO);
	}
	
	@PutMapping("/{id}")
	public StudentDTO updateStudent(@PathVariable("id") Long id, @RequestBody StudentDTO studentDTO) {
		return studentService.updateStudent(id, studentDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
	}
	
	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/all")
    public List<StudentDTO> getAllStudent() {
    	return studentService.getAllStudent();
    }
}
	
