package com.palle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palle.entity.Student;
import com.palle.service.StudentService;

@RestController
@RequestMapping("/studentapp")

public class StudentController {
	@Autowired
	private StudentService service;
	//1.REST API to insert voter
	@PostMapping("/insert")
	public Student insertStudent(@RequestBody Student v) {
		return service.insertStudent(v);
	}
	
	//2.REST API to readall Student
	@GetMapping("/readall")
	public List<Student> readAllStudent(){
		return service.readAllStudent();
		
	}
	//3.REST API to readone voter
	@GetMapping("/readone/{id}")
	public Optional<Student> readOneStudent(@PathVariable int id) {
		Optional<Student> opt = service.readOneStudent(id);
		return opt;
		
	}
	//4.REST API to update student
	@PutMapping("/update{id}")
	public Student updatestudent(@PathVariable int id, @RequestBody Student s) {
		Student opt = service.updatestudent(id, s);
		return opt;
	}
	
	//5.REST API to delete student
	@DeleteMapping("/delete{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	
	

}
