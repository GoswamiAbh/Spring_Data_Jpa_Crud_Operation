package com.abhi.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abhi.entity.Student;
import com.abhi.repository.StudentRepository;
import com.abhi.service.StudentService;

@SpringBootTest
public class StudentServiceTest {
	//we dont do autowired if we do that then we get actual data from database
	@Mock
	private StudentRepository repoTest;
	
	
	private StudentService serviceTest;
	
	
	
	@Test
	void saveStudent(Student student) {
		
	}

}
