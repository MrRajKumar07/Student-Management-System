package com.example.studentManagementSystem.service;

import java.util.List;

import com.example.studentManagementSystem.dto.StudentDTO;

public interface StudentService {

	  //Save Student Data 
	  StudentDTO createStudent(StudentDTO studentDTO);
	  
      //Update Student Data
      StudentDTO updateStudent(Long id, StudentDTO studentDTO);
	  
      //Delete Student
      void deleteStudent(Long id);
      
      //Search Student By Id
      StudentDTO getStudentById(Long id);
      
      //Get All Students
      List<StudentDTO> getAllStudent();
}
    