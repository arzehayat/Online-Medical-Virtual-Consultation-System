package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.patient;
import com.klef.jfsd.springboot.repository.Patient_Repository;

@Service
public class PatientServiceImpl implements Patient_Service {
	
	@Autowired
	private Patient_Repository patient_Repository;

	@Override
	public String PatientRegistration(patient p) {
		
		patient_Repository.save(p);
		return "Patient Registred Successfully";
	}

	@Override
	public patient checkPatientLogin(String email, String password) {
		
		return patient_Repository.checkPatientLogin(email, password);
	}




}
