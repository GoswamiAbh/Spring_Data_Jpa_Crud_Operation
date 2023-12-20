package com.abhi.restcontrollertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.abhi.controller.StudentController;
import com.abhi.entity.Student;
import com.abhi.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = StudentController.class)
public class testStudentController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService sService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void saveSuccess() throws Exception {
		
		Student s=new Student();
		s.setSid(1);
		s.setAge(25);
		s.setBranchName("CSE");
		s.setSEmail("amit@gmail.com");
		s.setSName("amit");
		s.setInstituteName("YIT");
		
		when(sService.saveStudent(any(Student.class))).thenReturn(s);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(s)));
	}
	
	
	@Test
	public void saveFailure() throws Exception {
		Student s=new Student();
		s.setSid(1);
		s.setAge(25);
		s.setBranchName("CSE");
		s.setSEmail("amit@gmail.com");
		s.setSName("amit");
		s.setInstituteName("YIT");
	    when(sService.saveStudent(any(Student.class))).thenReturn(null);

	    mockMvc.perform(MockMvcRequestBuilders.post("/save")).
		andExpect(MockMvcResultMatchers.status().isInternalServerError());
	}

}
