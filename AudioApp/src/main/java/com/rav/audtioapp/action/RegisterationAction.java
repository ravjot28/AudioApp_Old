package com.rav.audtioapp.action;

import com.rav.audtioapp.dto.RegistrationDTO;
import com.rav.audtioapp.service.RegistrationService;

public class RegisterationAction {
	private String fullName;
	private String password;
	private String repassword;
	private String email;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String execute() {
		RegistrationService service = new RegistrationService();
		service.processRequest(new RegistrationDTO());
		return "success";

	}

}