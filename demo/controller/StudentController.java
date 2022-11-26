package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping("/home")
	public ModelAndView homee()
	{
		System.out.println("Recieved home");
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("home.html");
	    return modelAndView;
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudents(@ModelAttribute("student") Student stuwrapper )
	{
		System.out.println("Recieved save");

		studentservice.saveStud(stuwrapper);
		return ResponseEntity.ok(stuwrapper);
	}
	
	@GetMapping("/getall/{id}")
	public ResponseEntity<Student> getStudents(@PathVariable Integer id)
	{
		Student stuwrappers=studentservice.getStud(id);
		return ResponseEntity.ok(stuwrappers);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudents(@RequestBody Student stuwrapper )
	{
		System.out.println("Recieved update");

		studentservice.updateStud(stuwrapper);
		return ResponseEntity.ok(stuwrapper);
	}
	
	@DeleteMapping("/delete/{id}")
	public String removeStudents(@PathVariable Integer id)
	{
		studentservice.deleteStud(id);
		return "Recored Removed";
	}

}
