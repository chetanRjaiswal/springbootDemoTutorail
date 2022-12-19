package com.gainjavaknowledge.springbootdemotutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.gainjavaknowledge.springbootdemotutorial.entity.StudentEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
		
	@BeforeEach
	void setup() {
		StudentEntity stuObj =  new StudentEntity(44,"abc",999,"dlh");
		entityManager.persist(stuObj);
	}
	
	@Test
	public void testFindById() {
		StudentEntity student =  studentRepository.findById(44).get();
		assertEquals("abc", student.getName());
	}
	
}
