package com.abhi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.entity.Student;
import com.abhi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student saveStudent(Student student) {
		Student save = repo.save(student);
		return save;
	}
	
	@Override
	public Student getPerticularRecord(Integer id) {

		Optional<Student> findById = repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			return null;
		}
		
	}

	@Override
	public List<Student> getStudentRecord() {
		List<Student> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public Student updateStudent(Student student) {
		 Student stu = repo.findById(student.getSid()).get();
		 
		 if(stu!=null) {
			 student.setSid(student.getSid());
			return  repo.save(student);
			 
		 }else {
			 return null;
		 }
		 
		/*
		if(student.getBranchName() != null && !student.getBranchName().isEmpty()) {
			updateId.setBranchName(updateId.getBranchName());
		}
		
		if(student.getSEmail() != null && !student.getSEmail().isEmpty()) {
			updateId.setSEmail(updateId.getSEmail());
		}
		
		if(student.getSPhoneNumber() != null) {
			updateId.setSPhoneNumber(updateId.getSPhoneNumber());
		}
		
		if(student.getInstituteName() != null && !student.getInstituteName().isEmpty()) {
			updateId.setInstituteName(updateId.getInstituteName());
		}
		
		if(student.getSName() !=null && !student.getSName().isEmpty()) {
			updateId.setSName(student.getSName());
		}
		
		return repo.save(updateId);
		*/
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
		
	}


}
