package com.verinite.bookstore.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Registration;
import com.verinite.bookstore.repository.RegistrationRepository;
import com.verinite.bookstore.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	Registration registrationData;

	@Override
	public List<Registration> getRegistrations() {
		List<Registration> registrationlist = new ArrayList<>();
		registrationRepository.findAll().forEach(registrations -> registrationlist.add(registrations));
		return registrationlist;
	}

	@Override
	public Object getRegistrationById(int register_id) {
		try {
			registrationRepository.findById(register_id).get();
			return registrationRepository.getById(register_id);
		} catch (Exception e) {
			return "Id not Found";
		}
	}

	@Override
	public Registration saveRegistration(Registration registration) {
		return registrationRepository.save(registration);
	}

	@Override
	public String deleteById(int register_id) {
		Registration registration = new Registration();
		try {
			registration = registrationRepository.getById(register_id);
		}catch (Exception e) {
			return "Registration id "+register_id+" is not present";
		}
		if(0!=registration.getRegister_id()&&registration.isIs_delete()==false) {
			registration.setIs_delete(true);
			registrationRepository.save(registration);
			return "Deleted succuessfully";
		}
		else if(registration.isIs_delete()==true) {
			return "Data already deleted";
		}
		else{
			return "No such data found in database";
		}

//	@Override
//	public Object updateRegistration(int registerId, Registration registration) {
//		try {
//			registrationData = registrationRepository.findById(register_id).get();
//
//			if (registrationData.isIs_delete() == true) {
//				return "Error : There is no Data with this id  " + register_id;
//			}
//			registrationData.setUser_name(registrationData.getUser_name());
//			registrationData.setEmailaddress(registrationData.getEmailaddress());
//			registrationData.setMobile_number(registrationData.getMobile_number());
//			registrationData.setPassword(registrationData.getPassword());
//			registrationData.setConfirm_password(registrationData.getConfirm_password());
//			registrationData.setUpdated_on(new Date());
//
//			return registrationRepository.save(registrationData);
//		} catch (Exception e) {
//
//			String message = "Error:  no data is present ";
//			return (Object) message;
//		}
	}

	@Override
	public Object updateRegistration(int register_id, Registration registration) {
		try {
			registrationData = registrationRepository.findById(register_id).get();

			if (registrationData.isIs_delete() == true) {
				return "Error : There is no Data with this id  " + register_id;
			}
			registrationData.setUser_name(registration.getUser_name());
			registrationData.setEmailaddress(registration.getEmailaddress());
			registrationData.setMobile_number(registration.getMobile_number());
			registrationData.setPassword(registration.getPassword());
			registrationData.setConfirm_password(registration.getConfirm_password());
			registrationData.setUpdated_on(new Date());

			return registrationRepository.save(registrationData);
		} catch (Exception e) {

			String message = "Error:  no data is present ";
			return (Object) message;
		}
	}
}