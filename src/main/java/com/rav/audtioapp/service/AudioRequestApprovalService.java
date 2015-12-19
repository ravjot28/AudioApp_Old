package com.rav.audtioapp.service;

import com.rav.audtioapp.dao.AudioApprovalDAO;
import com.rav.audtioapp.dto.AudioRequestApprovalDTO;

public class AudioRequestApprovalService {

	public String processRequest(AudioRequestApprovalDTO dto) {
		AudioApprovalDAO dao = new AudioApprovalDAO();

		int id = Integer.parseInt(dto.getId().replaceAll("STRATHY-", ""));
		dao.updateStatus(dto.getStatus(), id);
		return dto.getId() + "'s status updated to " + dto.getStatus();
	}

}
