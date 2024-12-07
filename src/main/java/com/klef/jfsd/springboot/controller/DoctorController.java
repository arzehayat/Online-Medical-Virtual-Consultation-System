package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.doctor;
import com.klef.jfsd.springboot.service.Doctor_Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorController {
	
	@Autowired
	private Doctor_Service doctor_Service;
	
	@GetMapping("doctorreg")
	public ModelAndView doctorreg() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("doctorreg");
		return mv;
	}
	
	@GetMapping("doctorlogin")
	public ModelAndView doctorlogin() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("doctorlogin");
		return mv;
	}
	
	@GetMapping("doctorhome")
	public ModelAndView doctorhome() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("doctorhome");
		return mv;
	}
	
	@GetMapping("doctorprofile")
	public ModelAndView doctorprofile() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("doctorprofile");
		return mv;
	}
	
	@GetMapping("doctorlogout")
	public ModelAndView doctorlogout() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("doctorlogin");
		return mv;
	}
	
	
	@PostMapping("insertdoctor")
	public ModelAndView insertdoctor(HttpServletRequest request) {
		
		String name=request.getParameter("dname");
		String gender=request.getParameter("dgender");
		String dob=request.getParameter("ddob");
		String email=request.getParameter("demail");
		String password=request.getParameter("dpwd");
		double salary=Double.parseDouble(request.getParameter("dsalary"));
		String contact=request.getParameter("dcontact");
		String qualification=request.getParameter("dqualification");
		Integer experience=Integer.parseInt(request.getParameter("dexperience"));
		String status="Registred";
		
		doctor d=new doctor();
		d.setName(name);
		d.setGender(gender);
		d.setDob(dob);
		d.setEmail(email);
		d.setPassword(password);
		d.setSalary(salary);
		d.setContact(contact);
		d.setQualification(qualification);
		d.setExperience(experience);
		d.setStatus(status);
		
		String message=doctor_Service.DoctorRegistration(d);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("doctorregsuccess");
		mv.addObject("message",message);
		
		return mv;	
		
	}
	
	@PostMapping("checkdoctorlogin")
	public ModelAndView checkdoctorlogin(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		
		String email=request.getParameter("demail");
		String pwd=request.getParameter("dpassword");
		
		doctor d=doctor_Service.checkDoctorLogin(email, pwd);
		
		if(d!=null) {
			
			HttpSession session =request.getSession();
			session.setAttribute("d", d);  //p is session object


			mv.setViewName("doctorhome");
		}
		else {
			mv.setViewName("doctorloginfail");
			mv.addObject("message","Login Fail");
		}
		
		return mv;
		
	}
	
	

}
