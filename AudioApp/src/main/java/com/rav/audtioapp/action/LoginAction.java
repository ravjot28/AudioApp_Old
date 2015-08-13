package com.rav.audtioapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rav.audtioapp.dto.LoginDTO;
import com.rav.audtioapp.service.LoginService;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
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
		LoginService service = new LoginService();
		if (service.processRequest(createDTO()))
			return "success";
		else {
			addActionError(service.getMessage());
			return "error";
		}
	}

	public LoginDTO createDTO() {
		LoginDTO dto = new LoginDTO();
		dto.setPassword(password);
		dto.setUserName(userName);
		return dto;
	}
}
