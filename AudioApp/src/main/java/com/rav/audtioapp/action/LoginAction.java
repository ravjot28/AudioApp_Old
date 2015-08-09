package com.rav.audtioapp.action;

import com.rav.audtioapp.dto.RegistrationDTO;
import com.rav.audtioapp.service.RegistrationService;

public class LoginAction {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		RegistrationService service = new RegistrationService();
		service.processRequest(new RegistrationDTO());
		return "success";

	}
}
