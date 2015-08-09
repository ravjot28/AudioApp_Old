package com.rav.audtioapp.service;

import com.rav.audtioapp.dto.RegistrationDTO;

public class RegistrationService {

	private boolean validatePassword(String password, String rePassword) {
		if (password.length() < 6)
			return false;
		if (password != rePassword)
			return false;
		else
			return true;
	}

	private boolean validateEmail(String email) {

		if (!(email.contains("@") || email.contains(".com") || email.contains(".in")))
			return false;
		else
			return true;
	}

	public boolean processRequest(RegistrationDTO dto) {
		boolean result = false;
		if (validateEmail(dto.getEmailAddress()) && validatePassword(dto.getPassword(), dto.getRepassword())) {
			return true;

		}
		return result;
	}

}