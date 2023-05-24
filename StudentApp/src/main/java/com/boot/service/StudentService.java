package com.boot.service;

import com.boot.entity.Student;
import java.util.*;

public interface StudentService {
	
	Student aadStudent(Student student);
	
	List<Student> getStudents(); 
	
	Student getStudentById(int id);
	
	Student updateStudentById(Student student, int id);
	
	void deleteStudent(int id);
	
	Student login(String studentEmail,String studentPassword);
	
	

}
