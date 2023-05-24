package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Course;
import com.boot.entity.Student;


public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	List<Course> findByStudent1(Student student);

}
