package com.boot.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.controller.StudentController;
import com.boot.entity.Course;
import com.boot.entity.Student;
import com.boot.exception.StudentException;
import com.boot.repository.CourseRepository;
import com.boot.repository.StudentRepository;
import com.boot.service.CourseService;

@Service
public class CourseServiceImplementation implements CourseService{
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private StudentRepository sRepository;

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return this.repository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		if(!this.repository.existsById(id)) {
			throw new StudentException("Course","Course Id", id);
		}
		else {
		return this.repository.findById(id).get();
		}
	}

	@Override
	public Course updateCourseById(Course course, int id) {
		// TODO Auto-generated method stub
		if(!this.repository.existsById(id)) {
			throw new StudentException("Course","Course Id", id);
		}
		else {
		return this.repository.save(course);
		}
	}

	@Override
	public List<Course> getCoursedEnrolledByStudent(int id) {
		// TODO Auto-generated method stub
		Student s = this.sRepository.findById(id).orElseThrow(()-> new StudentException("Student", "Student ID", id));
		
		
		return this.repository.findByStudent1(s);
	}

	@Override
	public void deleteById(int id) {
		if(!this.repository.existsById(id)) {
			throw new StudentException("Course","Course Id", id);
		}
		else {
		 this.repository.deleteById(id);
		}
		
	}

}
