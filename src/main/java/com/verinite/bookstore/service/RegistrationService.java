package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Registration;

public interface RegistrationService {
	public List<Registration> getRegistrations();

	public Object getRegistrationById(int register_id);

	public Registration saveRegistration(Registration registration);

	public String deleteById(int register_id);

	public Object updateRegistration(int register_id, Registration registration);
}
