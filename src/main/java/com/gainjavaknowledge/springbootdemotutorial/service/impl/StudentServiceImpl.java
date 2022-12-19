package com.gainjavaknowledge.springbootdemotutorial.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gainjavaknowledge.springbootdemotutorial.Exception.StudentNotFoundException;
import com.gainjavaknowledge.springbootdemotutorial.entity.StudentEntity;
import com.gainjavaknowledge.springbootdemotutorial.repository.StudentRepository;
import com.gainjavaknowledge.springbootdemotutorial.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentEntity addStudent(StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity getStudentById(Integer id) {
		Optional<StudentEntity> studentObj = studentRepository.findById(id);
		if(!studentObj.isPresent()) {
			throw new StudentNotFoundException("student not exists with Given id : "+id);
		}
		return studentObj.get();
	}

	@Override
	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
	}

	@Override
	public StudentEntity updateStudent(StudentEntity student, Integer id) {

		
			StudentEntity studentObj = studentRepository.findById(id).get();
			
			if (ObjectUtils.isNotEmpty(student.getName())) {
				studentObj.setName(student.getName());
			}
			if (ObjectUtils.isNotEmpty(student.getAddress())) {
				studentObj.setAddress(student.getAddress());
			}
			if (ObjectUtils.isNotEmpty(student.getId())) {
				studentObj.setId(student.getId());
			}
	
		return studentRepository.save(studentObj);
	}

	@Override
	public List<StudentEntity> getStudentByName(String name) {
		
		return studentRepository.findByName(name);
	}
}