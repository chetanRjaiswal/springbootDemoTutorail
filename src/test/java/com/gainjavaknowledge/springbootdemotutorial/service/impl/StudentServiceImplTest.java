package com.gainjavaknowledge.springbootdemotutorial.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gainjavaknowledge.springbootdemotutorial.entity.StudentEntity;
import com.gainjavaknowledge.springbootdemotutorial.repository.StudentRepository;
import com.gainjavaknowledge.springbootdemotutorial.service.StudentService;

@SpringBootTest
class StudentServiceImplTest {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	@BeforeEach
	void setup() {
		Optional<StudentEntity> st = Optional.of(new StudentEntity(1, "abc", 100, "dlh"));
		Mockito.when(studentRepository.findById(1)).thenReturn(st);
	}
	
	@Test
	public void testGetStudentById() {
		String name = "abc";
		StudentEntity stObj = studentService.getStudentById(1);
		assertEquals(name, stObj.getName());
	}
}
