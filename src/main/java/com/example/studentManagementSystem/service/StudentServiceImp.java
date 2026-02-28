package com.example.studentManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

//  @Autowired
//	StudentRepository studentRepo;
	
	private final StudentRepository studentRepo;

	@Override
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student studentDetails) {
		Student student = studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found With id :"+id));
		student.setName(studentDetails.getName());
		student.setEmail(studentDetails.getEmail());
		student.setPhone(studentDetails.getPhone());
		student.setDepartment(studentDetails.getDepartment());
		
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
