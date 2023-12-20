package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
