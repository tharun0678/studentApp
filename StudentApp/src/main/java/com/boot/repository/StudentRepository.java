package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Student findByStudentEmailAndStudentPassword(String studentEmail,String studentPassword);

}
