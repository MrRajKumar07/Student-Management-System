package com.example.studentManagementSystem.mapper;

import org.springframework.stereotype.Component;

import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.model.Student;

@Component
public class StudentMapper {

//	entity->Dto = fetching data from database and sending it to frontend 
	public StudentDTO toDTO(Student student) {
		if(student == null) return null;
		StudentDTO dto = new StudentDTO();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setEmail(student.getEmail());
		dto.setPhone(student.getPhone());
		dto.setDepartment(student.getDepartment());
		
		return dto;
	}
	
//	dto->entity = Collect data from end user and send it database
	public Student toEntity(StudentDTO dto) {
		if(dto == null) return null;
		Student student = new Student();
		student.setId(dto.getId());
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		student.setPhone(dto.getPhone());
		student.setDepartment(dto.getDepartment());
		
		return student;
	}
}
