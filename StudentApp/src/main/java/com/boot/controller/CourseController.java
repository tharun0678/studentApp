package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Course;
import com.boot.exception.ApiResponse;
import com.boot.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
	
	@Autowired
	public CourseService service;
	
	@PostMapping("/")
	public ResponseEntity<Course> addnew(@RequestBody Course course){
		Course c = this.service.addCourse(course);
		return new ResponseEntity<Course>(c, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Course>> getAll(){
		List<Course> c = this.service.getAllCourses();
		return new ResponseEntity<List<Course>>(c, HttpStatus.OK);
	}
	@GetMapping("/{studentid}")
	public ResponseEntity<List<Course>> getCoursesEnrolled(@PathVariable("studentid") int id){
		List<Course> c= this.service.getCoursedEnrolledByStudent(id);
		return new ResponseEntity<List<Course>>(c,HttpStatus.OK);
	}
	
	@PutMapping("/{courseid}")
	public ResponseEntity<Course> update(@RequestBody Course course,@PathVariable("courseid") int id){
		Course c = this.service.updateCourseById(course, id);
		
		return new ResponseEntity<Course>(c,HttpStatus.OK);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable("courseId") int id){
		this.service.deleteById(id);
		ApiResponse res = new ApiResponse();
		res.setMessage("Record has been deleted Successfull with CourseId:"+id);
		
		return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
	}

}
