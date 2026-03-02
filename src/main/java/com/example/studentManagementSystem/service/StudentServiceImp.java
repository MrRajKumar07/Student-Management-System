package com.example.studentManagementSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.dto.StudentDTO;
import com.example.studentManagementSystem.mapper.StudentMapper;
import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

//  @Autowired
//	StudentRepository studentRepo;
	
	private final StudentRepository studentRepo;
	
	private final StudentMapper studentMapper;

    @Override
	public StudentDTO createStudent(StudentDTO studentDTO) {
    	Student student = studentMapper.toEntity(studentDTO);
    	Student saveStudent = studentRepo.save(student);
    	return studentMapper.toDTO(saveStudent);
	}
    
    @Override
	public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
		Student student = studentRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Student Not Found With id :"+id));
		
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPhone(studentDTO.getPhone());
		student.setDepartment(studentDTO.getDepartment());
		
		return studentMapper.toDTO(studentRepo.save(student));
	}

	@Override
	public void deleteStudent(Long id) {
		if(!studentRepo.existsById(id)){
			throw new RuntimeException("Student Not Found With id :"+id);
		}
		studentRepo.deleteById(id);
	}
	
	@Override
	public StudentDTO getStudentById(Long id) {
			return studentRepo.findById(id)
					.map(studentMapper::toDTO)
					.orElseThrow(() -> new RuntimeException("Student not found with id: "+ id));
	}
	

	@Override
	public List<StudentDTO> getAllStudent() {
		return studentRepo.findAll().stream()
				.map(studentMapper::toDTO)
				.toList();
				
	}

	
}
