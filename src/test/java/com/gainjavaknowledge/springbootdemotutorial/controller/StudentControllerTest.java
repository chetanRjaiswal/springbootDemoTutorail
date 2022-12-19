package com.gainjavaknowledge.springbootdemotutorial.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.gainjavaknowledge.springbootdemotutorial.entity.StudentEntity;
import com.gainjavaknowledge.springbootdemotutorial.service.StudentService;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	private StudentEntity student;

	@BeforeEach
	void setup() {
		student = new StudentEntity(44, "xyz", 9999, "dlh");
	}

	@Test
	public void testAddStudent() throws Exception {
		StudentEntity studentEntity = new StudentEntity(1, "abc", 101, "hyd");
		Mockito.when(studentService.addStudent(studentEntity)).thenReturn(student);
		mockMvc.perform(MockMvcRequestBuilders.post("/student/").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "  \"id\": 1,\r\n" + "  \"name\": \"abc\",\r\n" + "  \"rollNo\": 101,\r\n"
						+ "  \"address\": \"hyd\"\r\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
