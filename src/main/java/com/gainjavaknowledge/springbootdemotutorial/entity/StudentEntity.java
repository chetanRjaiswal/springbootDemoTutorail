package com.gainjavaknowledge.springbootdemotutorial.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	private Integer id;
	
	@NotBlank(message = "please add student name.")
	private String name;
	
	private Integer rollno;
	
	private String address;

	public StudentEntity() {
		
	}

	public StudentEntity(Integer id, @NotBlank(message = "please add student name.") String name, Integer rollno,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", rollno=" + rollno + ", address=" + address + "]";
	}
	
	
	
}
