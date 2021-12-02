package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/getAllRegistration")
	public List<Registration> getAllRegistrations() {
		return registrationService.getRegistrations();
	}

	@GetMapping("/getRegistration/{register_id}")
	public Object getRegistrationById(@PathVariable("register_id") int register_id) {
		return registrationService.getRegistrationById(register_id);
	}

	@PostMapping("/saveRegistrations")
	public Registration saveRegistration(@RequestBody Registration registration) {
		return registrationService.saveRegistration(registration);
	}

	@DeleteMapping("/deleteRegistration/{register_id}")
	public String deleteRegistration(@PathVariable int register_id) {
		return registrationService.deleteRegistration(register_id);
	}

	@PutMapping("/updateRegistration/{register_id}")
	public Object updateRegistration(@PathVariable int register_id, @RequestBody Registration registration) {
		return registrationService.updateRegistration(register_id, registration);
	}
}
