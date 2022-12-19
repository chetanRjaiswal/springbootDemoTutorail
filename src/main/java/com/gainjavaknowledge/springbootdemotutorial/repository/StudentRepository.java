package com.gainjavaknowledge.springbootdemotutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gainjavaknowledge.springbootdemotutorial.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

	List<StudentEntity> findByName(String name);

}
