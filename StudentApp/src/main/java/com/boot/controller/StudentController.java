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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.boot.entity.Student;
import com.boot.exception.ApiResponse;
import com.boot.service.StudentService;

@RestController
@RequestMapping("/stuednt")
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	public StudentService service;
	
	@PostMapping("/")
	public ResponseEntity<Student> adStudent(@RequestBody Student student) {
		Student s = this.service.aadStudent(student);
		
		return new ResponseEntity<Student>(s,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> s = this.service.getStudents();
		return new ResponseEntity<List<Student>>(s,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable("studentId") int id){
		
		Student s = this.service.getStudentById(id);
		
		return new ResponseEntity<Student>(s,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable("studentId") int id){
	
		Student s = this.service.updateStudentById(student, id);
		
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable("studentId") int id) {
		
		
		
		this.service.deleteStudent(id);
		
		ApiResponse response = new ApiResponse();
		response.setMessage("Record has been deleted successfully with Id :"+id);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/check")
	public ResponseEntity<Student> checkLogin(@RequestParam("email") String mail,@RequestParam("password") String password){
		Student s = this.service.login(mail, password);
		if(s != null) {
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		}
		return null;
		
	}
	
	

}
