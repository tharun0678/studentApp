package com.boot.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.boot.entity.Student;
import com.boot.exception.StudentException;
import com.boot.repository.StudentRepository;
import com.boot.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public Student aadStudent(Student student) {
		// TODO Auto-generated method stub
		return this.repository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).orElseThrow(()-> new StudentException("Student", "Student ID", id));
	}

	@Override
	public Student updateStudentById(Student student, int id) {
		// TODO Auto-generated method stub
		if(!this.repository.existsById(id)) {
			throw new StudentException("Student","Student Id", id);
		}
		
		return this.repository.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		
		if(!this.repository.existsById(id)) {
			throw new StudentException("Student", "Student ID", id);
		}
		else {
		this.repository.deleteById(id);
		}
		
	}

	@Override
	public Student login(String studentEmail, String studentPassword) {
		// TODO Auto-generated method stub
	
			return this.repository.findByStudentEmailAndStudentPassword(studentEmail, studentPassword);
		
	}

}
