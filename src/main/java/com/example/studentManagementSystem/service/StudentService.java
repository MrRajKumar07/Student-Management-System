package com.example.studentManagementSystem.service;

import java.util.List;

import com.example.studentManagementSystem.model.Student;

public interface StudentService {

	  //Save Student Data 
      Student createStudent(Student student);
      
      //Update Student Data
      Student updateStudent(Long id, Student student);
      
      //Delete Student
      void deleteStudent(Long id);
      
      //Search Student By Id
      Student getStudentById(Long id);
      
      //Get All Students
      List<Student> getAllStudent();
}
    