package com.shailendra.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shailendra.student.entity.Student;
import com.shailendra.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class Controller {

	@Autowired
	StudentService studentService;

	@PostMapping("/insert")
	public Student insertEmployee(@RequestBody Student student) {
		return studentService.insertEmployee(student);
	}

	@GetMapping("/listOfStudent")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/studentById/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/studentByName/{name}")
	public Student getStudentById(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}

	@PutMapping("/update/{studentId}")
	public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
		return studentService.updateStudent(studentId, student);
	}

	@PatchMapping("/updateField/{studentId}")
	public Student updateField(@PathVariable int studentId, @RequestBody Student student) {
		return studentService.updateField(studentId, student);
	}

	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable int id) {
		return studentService.deleteById(id);
	}

}
