package com.shailendra.student.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shailendra.student.entity.Student;
import com.shailendra.student.repository.StudentRepository;
import com.shailendra.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student insertEmployee(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		Student updatedStudent = studentRepository.findById(studentId).get();

		updatedStudent.setStudentName(student.getStudentName());
		updatedStudent.setStudentAddress(student.getStudentAddress());
		updatedStudent.setStudentAge(student.getStudentAge());
		updatedStudent.setStudentDOB(student.getStudentDOB());
		updatedStudent.setStudentMarks(student.getStudentMarks());
		return studentRepository.save(updatedStudent);
	}

	@Override
	public Student updateField(int studentId, Student student) {
		Student updatedField = studentRepository.findById(studentId).get();
		updatedField.setStudentName(student.getStudentName());
		return studentRepository.save(updatedField);
	}

	@Override
	public Student deleteById(int id) {
		Student deletedStudent = studentRepository.findById(id).get();
		studentRepository.delete(deletedStudent);

		return deletedStudent;
	}

	@Override
	public Student getStudentById(int id) {
		Student student = studentRepository.findById(id).get();

		return student;

		// return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student getStudentByName(String name) {

		return studentRepository.findBystudentName(name);
	}

}
