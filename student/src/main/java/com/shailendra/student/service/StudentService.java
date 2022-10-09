package com.shailendra.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shailendra.student.entity.Student;


public interface StudentService {

	Student insertEmployee(Student student);

	List<Student> getAllStudent();

	Student updateStudent(int studentId, Student student);

	Student updateField(int studentId, Student student);

	Student deleteById(int id);

	Student getStudentById(int id);

	List<Student> getStudentByName(String name);

	
}
