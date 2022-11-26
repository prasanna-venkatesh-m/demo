package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.StudentWrapper;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	
	public String saveStud(Student inputs)
	{
		Student stu=new Student();
		stu.setId(inputs.getId());
		stu.setName(inputs.getName());
		stu.setAge(inputs.getAge());
		stu.setCity(inputs.getCity());
		repo.save(stu);
		
		return "Saved";
		
	}
	public Student getStud(Integer id)
	{
		Student stuOutputs = null;
		Optional<Student> lists=repo.findById(id);
		if(lists.isPresent())
		{
			stuOutputs = new Student();
			Student stu=lists.get();
			stuOutputs.setId(stu.getId());
			stuOutputs.setName(stu.getName());
			stuOutputs.setAge(stu.getAge());
			stuOutputs.setCity(stu.getCity());
		}
		return stuOutputs;
	}
	public String updateStud(Student inputs)
	{
		Optional<Student> lists=repo.findById(inputs.getId());
		
		if(lists.isPresent())
		{
		Student stu=lists.get();
		
		stu.setName(inputs.getName());
		stu.setAge(inputs.getAge());
		stu.setCity(inputs.getCity());
		repo.save(stu);
		}
		else {
			return "No record exists";
		}
		return "Saved";
		
	}
	
	public void deleteStud(Integer id)
	{
		Optional<Student> lists=repo.findById(id);
		if(lists.isPresent())
		{
			Student stu=lists.get();
			repo.delete(stu);
		}
	}

}
