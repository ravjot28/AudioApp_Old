package com.rav.audtioapp.action;

import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionSupport;
import com.rav.audtioapp.constants.param.ParamConstants;
import com.rav.audtioapp.dao.param.ParamsDAO;
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
		LoginDTO dto = createDTO();
		if (service.processRequest(dto)) {

			try {
				String admins = new ParamsDAO().getParamValue(ParamConstants.STRATHY_ADMIN);
				if (admins != null && admins.trim().length() > 0) {
					StringTokenizer token = new StringTokenizer(admins, ",");

					while (token.hasMoreTokens()) {
						if (dto.getUserName().equals(token.nextToken())) {
							return "admin";
						}
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "success";
		} else {
			addActionError(service.getMessage());
			return "input";
		}
	}

	public LoginDTO createDTO() {
		LoginDTO dto = new LoginDTO();
		dto.setPassword(password);
		dto.setUserName(userName);
		return dto;
	}
}
