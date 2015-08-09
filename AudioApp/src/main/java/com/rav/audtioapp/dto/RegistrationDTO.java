package com.rav.audtioapp.dto;

public class RegistrationDTO {

	private String emailId;
	private String password;
	private String passwordReEnter;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordReEnter() {
		return passwordReEnter;
	}

	public void setPasswordReEnter(String passwordReEnter) {
		this.passwordReEnter = passwordReEnter;
	}

}