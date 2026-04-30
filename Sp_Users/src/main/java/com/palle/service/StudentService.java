package com.palle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palle.entity.Student;
import com.palle.repository.StudentRepository;
@Service
public class StudentService {
	//service layer needs repository dependency
	@Autowired
	public StudentRepository repository;
	//Business logic
	//1.method to insert student data
	public Student insertStudent(Student s)
	{
		return repository.save(s);
	}
	//2.Read all student data
	public List<Student> readAllStudent(){
		return repository.findAll();
	}
	//3.Read one student
	public Optional<Student> readOneStudent(int id){
		Optional<Student> opt = repository.findById(id);
		return opt;
	}
	//4.updating a student data
	public Student updatestudent(int id, Student s) {
	Optional<Student> opt = repository.findById(id);
	Student existingStudent = null;
	if(opt.isPresent()) {
		existingStudent = opt.get();
		existingStudent.setsName(s.getsName());
		existingStudent.seteMail(s.geteMail());
		existingStudent.setMobile(s.getMobile());
		existingStudent.setAge(s.getAge());
		existingStudent.setGender(s.getGender());
		repository.save(existingStudent);
	}
	return existingStudent;
}

	//5.delete a student data
	public String deleteStudent(int id)
	{
		Optional<Student> opt = repository.findById(id);
		if(opt.isPresent())
		{
			Student student = opt.get();
			repository.delete(student);
			return "Student with id "+id+" is deleted";
		}
		return "Student with id "+id+" is not exist";
	}
}
	
		


