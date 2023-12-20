package com.abhi.service;

import com.abhi.entity.Student;

public interface StudentService {
	
	
	//Save Operation
	
	public Student saveStudent(Student student);
	
	//Read Student Record
	public java.util.List<Student> getStudentRecord();
	
	//Read Perticular Record
	public Student getPerticularRecord(Integer id);
	
	//update record
	public Student updateStudent(Student student);
	
	//delete Record
	public void deleteStudent(Integer id);
	
	
	

}
