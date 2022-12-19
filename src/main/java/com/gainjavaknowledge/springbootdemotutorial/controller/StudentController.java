package com.gainjavaknowledge.springbootdemotutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gainjavaknowledge.springbootdemotutorial.entity.StudentEntity;
import com.gainjavaknowledge.springbootdemotutorial.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@PostMapping("/")
	public StudentEntity addStudent(@Valid @RequestBody StudentEntity student) {
		logger.info("Inside StudentController addStudent method. student : {} ", student);
		return studentService.addStudent(student);
	}

	@GetMapping("/")
	public List<StudentEntity> getAllStudent() {
		logger.info("Inside StudentController getAllStudent method.");
		return studentService.getAllStudent();
	}

	@GetMapping("/{student-id}")
	public StudentEntity getStudentById(@PathVariable("student-id") Integer id) {
		logger.info("Inside StudentController getStudentById method. student id  : {}", id);
		return studentService.getStudentById(id);
	}

	@DeleteMapping("/{student-id}")
	public void deleteStudentById(@PathVariable("student-id") Integer id) {
		logger.info("Inside StudentController deleteStudentById method. student id  : {}", id);
		studentService.deleteStudentById(id);
	}

	@PutMapping("/{student-id}")
	public StudentEntity updateStudent(@RequestBody StudentEntity student, @PathVariable("student-id") Integer id) {
		logger.info("Inside StudentController updateStudent method. student id  : {}", id);
		return studentService.updateStudent(student, id);
	}

	@GetMapping("/name/{student-name}")
	public List<StudentEntity> getStudentByName(@PathVariable("student-name") String name) {
		return studentService.getStudentByName(name);
	}

}
