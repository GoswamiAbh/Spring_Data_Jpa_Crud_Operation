package com.abhi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.entity.Student;
import com.abhi.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	// Save Student Record
	@PostMapping("/save")
	public ResponseEntity<String> saveStudentRecord(@RequestBody @Valid Student student) {
		Student saveStudent = service.saveStudent(student);

		if (saveStudent!=null) {
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// read operation
	@GetMapping("/allRecord")
	public List<Student> getStudentRecord() {
		List<Student> studentRecord = service.getStudentRecord();
		return studentRecord;

	}

	@GetMapping("/SingleRecord/{id}")
	public Student getPerticularRecord(@PathVariable Integer id) {
		Student perticularRecord = service.getPerticularRecord(id);
		return perticularRecord;
	}

	@PutMapping("/update")
	public Student updateRecord(@RequestBody Student student) {
		Student updateStudent = service.updateStudent(student);
		return updateStudent;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteRecord(@PathVariable Integer id) {
		service.deleteStudent(id);
		return "Delete Successfully";

	}

}
