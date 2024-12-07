package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.doctor;
import com.klef.jfsd.springboot.repository.Doctor_Repository;

@Service
public class DoctorServiceImpl implements Doctor_Service {
	
	@Autowired
	private Doctor_Repository doctor_Repository;
	
	@Override
	public String DoctorRegistration(doctor d) {
		
		doctor_Repository.save(d);
		return "Doctor Registred Scucessfully";
	}

	@Override
	public doctor checkDoctorLogin(String email, String password) {
		
		return doctor_Repository.checkDoctorLogin(email, password);
	}
	
}
