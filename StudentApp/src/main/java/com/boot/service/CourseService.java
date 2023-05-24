package com.boot.service;

import java.util.List;

import com.boot.entity.Course;

public interface CourseService {
	
	Course addCourse(Course course);
	
	List<Course> getAllCourses();
	
	Course getCourseById(int id);
	
	Course updateCourseById(Course course, int id);
	
	List<Course> getCoursedEnrolledByStudent(int id);
	
	void deleteById(int id);
	

}
