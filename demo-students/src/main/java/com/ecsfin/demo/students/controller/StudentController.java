package com.ecsfin.demo.students.controller;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecsfin.demo.students.model.Student;
import com.ecsfin.demo.students.model.Students;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	final Students students = new Students(Arrays.asList(
			new Student("S1","Ram", "4th", 9, "M"),
			new Student("S2","Sam", "5th", 10, "M"),
			new Student("S3","Diya", "10th", 13, "F"),
			new Student("S4","Arya", "12th", 15, "F"),
			new Student("S5","Rahul", "12th", 15, "M")
			));
	
	@GetMapping
	public ResponseEntity<Students> getStudents(){
		return new ResponseEntity<Students>(students, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable String id) throws InterruptedException{
		Optional<Student> opsStudent = students.getStudents().stream()
							.filter(s->s.getId().equals(id))
							.findFirst();
		
		Student student = opsStudent.get();
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}