package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	
	@javax.persistence.Id
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private Integer age;
	@Column(name="city")
	private String city;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student(Integer id, String name, Integer age, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public Student() {
		super();
	}
	
	
	

}
