package com.rav.audtioapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rav.audtioapp.dto.RegistrationDTO;
import com.rav.audtioapp.service.RegistrationService;

public class RegisterationAction extends ActionSupport {
	private String userName;
	private String password;
	private String repassword;
	private String emailAddress;

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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String execute() {
		RegistrationService service = new RegistrationService();
		System.out.println("Sending Request to Service Layer");
		if (service.processRequest(createDTO()))
			return "success";
		else {
			addActionError("I don't know you, dont try to hack me!");
			return "error";
		}
	}

	public RegistrationDTO createDTO() {
		RegistrationDTO dto = new RegistrationDTO();
		dto.setEmailAddress(emailAddress);
		dto.setPassword(password);
		dto.setRepassword(repassword);
		dto.setUserName(userName);
		return dto;
	}

}