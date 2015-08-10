package com.rav.audtioapp.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.rav.audtioapp.dao.RegistrationDAO;
import com.rav.audtioapp.dto.RegistrationDTO;
import com.rav.audtioapp.util.SaltTextEncryption;

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
			RegistrationDAO dao = new RegistrationDAO();
			if (!dao.userNameExists(dto.getUserName()) && !dao.emailAddressExists(dto.getEmailAddress())) {

				try {
					dto.setPassword(SaltTextEncryption.getInstance().createHash(dto.getPassword()));
					dao.insertNewuser(dto.getEmailAddress(), dto.getUserName(), dto.getPassword());
					return true;
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}