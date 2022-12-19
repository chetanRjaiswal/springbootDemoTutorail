package com.gainjavaknowledge.springbootdemotutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gainjavaknowledge.springbootdemotutorial.entity.StudentEntity;

@Service
public interface StudentService {

	StudentEntity addStudent(StudentEntity student);

	List<StudentEntity> getAllStudent();

	StudentEntity getStudentById(Integer id);
	
	void deleteStudentById(Integer id);

	StudentEntity updateStudent(StudentEntity student, Integer id);

	List<StudentEntity> getStudentByName(String name);

	
}
