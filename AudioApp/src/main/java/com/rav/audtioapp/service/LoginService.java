package com.rav.audtioapp.service;

import com.rav.audtioapp.dao.LoginDAO;
import com.rav.audtioapp.dto.LoginDTO;
import com.rav.audtioapp.util.SaltTextEncryption;

public class LoginService {

	public boolean processRequest(LoginDTO dto) {
		boolean result = false;
		if (dto.getUserName() != null && dto.getUserName().length() > 0 && dto.getPassword() != null
				&& dto.getPassword().length() > 0) {
			LoginDAO dao = new LoginDAO();
			if (dao.userNameExists(dto.getUserName())) {
				try {
					if (SaltTextEncryption.getInstance().validateStrings(dto.getPassword(),
							dao.getPassword(dto.getUserName())))
						return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			result = true;

		} else {
			result = false;
		}
		return result;
	}

}
