package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Registration;

public interface RegistrationService {
	public List<Registration> getRegistrations();

	public Object getRegistrationById(int registerId);

	public Registration saveRegistration(Registration registration);

	public String deleteRegistration(int registerId);

	public Object updateRegistration(int registerId, Registration registration);
	
	public Registration getRegistration(Registration registration);

}
