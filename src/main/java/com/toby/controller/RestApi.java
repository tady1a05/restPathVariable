package com.toby.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.toby.model.*;

@RestController
@RequestMapping("/api")
public class RestApi {
	private ArrayList<Student> studentList = null;
	
	@PostConstruct
	public void loadData() {
		studentList = new ArrayList<Student>();
		
		Student a = new Student("Toby","Cheung");
		Student b = new Student("Peter","Cheung");
		Student c = new Student("Kitty","Wong");
		
		studentList.add(a);
		studentList.add(b);
		studentList.add(c);
	}
	
	@GetMapping("/students")
	public ArrayList<Student> test() {
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student test(@PathVariable int studentId) {
		return studentList.get(studentId);
	}
}
