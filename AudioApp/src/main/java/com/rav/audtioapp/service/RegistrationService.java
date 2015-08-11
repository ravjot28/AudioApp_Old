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
		if (!password.equals(rePassword))
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
		System.out.println("Processing Request");
		if (validateEmail(dto.getEmailAddress()) && validatePassword(dto.getPassword(), dto.getRepassword())) {
			RegistrationDAO dao = new RegistrationDAO();
			System.out.println("RegistrationDAO object created");
			if (!dao.userNameExists(dto.getUserName()) && !dao.emailAddressExists(dto.getEmailAddress())) {

				try {
					dto.setPassword(SaltTextEncryption.getInstance().createHash(dto.getPassword()));
					System.out.println("Password encrypted");
					dao.insertNewuser(dto.getEmailAddress(), dto.getUserName(), dto.getPassword());
					System.out.println("Inserted");
					return true;
				} catch (NoSuchAlgorithmException e) {
					System.err.println(e);
				} catch (InvalidKeySpecException e) {
					System.err.println(e);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
		return result;
	}

}