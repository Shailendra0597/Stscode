package com.shailendra.student.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shailendra.student.entity.Student;
import com.shailendra.student.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ControllerTest.class})
@WebMvcTest(value=Controller.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private Controller controller;
	
	@MockBean
	private StudentService studentService;
	
	
	public void addStudent() throws Exception {
		
		
		Student student=new Student(99, "Shailendra", 55.5, 24, "05/03/1997", "Randhawapuram");
		
		Mockito.when(studentService.insertEmployee(student)).thenReturn(student);
		
		RequestBuilder request=MockMvcRequestBuilders.post("/student/insert").contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	
	}	
}
