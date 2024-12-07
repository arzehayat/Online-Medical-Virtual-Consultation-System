package com.klef.jfsd.springboot.service;

import com.klef.jfsd.springboot.model.doctor;

public interface Doctor_Service {
	
	public String DoctorRegistration(doctor d);
	public doctor checkDoctorLogin(String email,String password);
}
