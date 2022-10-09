package com.shailendra.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.shailendra.student.entity.Student;
import com.shailendra.student.repository.StudentRepository;
import com.shailendra.student.service.serviceImpl.StudentServiceImpl;

@SpringBootTest(classes = { ServiceImplTest.class })
public class ServiceImplTest {

	@InjectMocks
	private StudentServiceImpl studentServiceImpl;

	@Mock
	private StudentRepository studentRepository;

	public List<Student> studentList;

	@Test
	public void addStudent() {

		Student student = new Student(99, "Shailendra", 55.5, 24, "05/03/1997", "Randhawapuram");
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertEquals(student, studentServiceImpl.insertEmployee(student));

	}

	@Test
	public void ListOfStudent() {
		when(studentRepository.findAll()).thenReturn(Stream
				.of(new Student(99, "Shailendra", 55.5, 24, "05/03/1997", "Randhawapuram"),
						new Student(98, "Shailendra", 55.5, 24, "05/03/1997", "Randhawapuram"))
				.collect(Collectors.toList()));
		assertEquals(2, studentServiceImpl.getAllStudent().size());

	}

	@Test
	public void getUserByName() {
		String name = "abc";
		when(studentRepository.findBystudentName(name))
				.thenReturn(Stream.of(new Student(98, "Shailendra", 55.5, 24, "05/03/1997", "Randhawapuram"))
						.collect(Collectors.toList()));

		assertEquals(1, studentServiceImpl.getStudentByName(name).size());
	}

	@Test
	public void getUserById() { 
		Student student1=new Student(1, "Shailendra", 55.5, 24,"05/03/1997", "Randhawapuram"); 
		Student student2=new Student(2, "Shailendra",55.5, 24, "05/03/1997", "Randhawapuram");
	  
	  int id=1;
	  int id2=2;
	  Mockito.when(studentRepository.findById(id)).thenReturn(Optional.ofNullable(student1));
	  Mockito.when(studentRepository.findById(id2)).thenReturn(Optional.ofNullable(student2));
	  assertEquals(1, studentServiceImpl.getStudentById(id).getStudentId());
	  assertEquals(2, studentServiceImpl.getStudentById(id2).getStudentId());
	  
	  }

	@Test
	public void deleteById() {
		
		Student student1=new Student(1, "Shailendra", 55.5, 24,"05/03/1997", "Randhawapuram"); 
		
		int id=1;
		Mockito.when(studentRepository.findById(id)).thenReturn(Optional.ofNullable(student1));
		assertEquals(id, studentServiceImpl.deleteById(id).getStudentId());
	}
	
}
