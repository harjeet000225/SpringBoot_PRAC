package com.harjeet.ThymleafDemo;

//import java.lang.reflect.Array;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String Hello() {
		return "hello";
		
	}
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "take up one idea and make it your life");
		return mav;
	}
	
	@RequestMapping("/student")
	public ModelAndView getstudent(){
		ModelAndView mav=new ModelAndView("Student");
		Student student=new Student();
		student.setName("John");
		student.setScore(90);
		mav.addObject("Student", student);
		return mav;
	}
	@RequestMapping("/students")
	public ModelAndView getStudent(){
		ModelAndView mav=new ModelAndView("StudentList");
		Student student=new Student();
		student.setName("John");
		student.setScore(90);
		Student student2=new Student();
		student2.setName("harjeet");
		student2.setScore(80);
		List<Student> students=new ArrayList();
		mav.addObject("Student", students);
		return mav;
	}
	
	@RequestMapping("/studentform")
	    public ModelAndView displayStudentform() {	
		ModelAndView mav=new ModelAndView("StudentForm");
		Student student=new Student();
		student.setName("harjeet");
		student.setScore(90);
		mav.addObject("Student", student);
		return mav;
	}
	
	@RequestMapping("/savestudent")
    public ModelAndView savestudent(@ModelAttribute Student student) {	
	ModelAndView mav=new ModelAndView("result");
	System.out.println(student.getName());
	System.out.println(student.getScore());
	return mav;
}
}
