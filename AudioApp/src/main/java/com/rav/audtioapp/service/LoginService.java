package com.rav.audtioapp.service;

import com.rav.audtioapp.dto.LoginDTO;

public class LoginService {

	public boolean processRequest(LoginDTO dto) {
		boolean result = false;
		if (dto.getUserName() != null && dto.getUserName().length() > 0 && dto.getPassword() != null
				&& dto.getPassword().length() > 0) {
			return true;

		} else {
			return false;
		}

	}

}
