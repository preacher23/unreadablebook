package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Registration;
import com.verinite.bookstore.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/getAllRegistration")
	public List<Registration> getAllRegistrations() {
		return registrationService.getRegistrations();
	}

	@GetMapping("/getRegistration/{registerId}")
	public Object getRegistrationById(@PathVariable("registerId") int registerId) {
		return registrationService.getRegistrationById(registerId);
	}

	@PostMapping("/saveRegistrations")
	public Registration saveRegistration(@RequestBody Registration registration) {
		return registrationService.saveRegistration(registration);
	}

	@DeleteMapping("/deleteRegistration/{registerId}")
	public String deleteRegistration(@PathVariable int registerId) {
		return registrationService.deleteRegistration(registerId);
	}

	@PutMapping("/updateRegistration/{registerId}")
	public Object updateRegistration(@PathVariable int registerId, @RequestBody Registration registration) {
		return registrationService.updateRegistration(registerId, registration);
	}
	
	@GetMapping("/login/{userName}")
	public Object login(@PathVariable("userName") String username ) {
		Registration registration = new Registration();
		registration.setUserName(username);
		registration = registrationService.getRegistration(registration);
		return registration;
	}
}
