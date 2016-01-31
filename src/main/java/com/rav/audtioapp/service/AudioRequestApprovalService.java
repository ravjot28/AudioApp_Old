package com.rav.audtioapp.service;

import com.rav.audtioapp.dao.AudioApprovalDAO;
import com.rav.audtioapp.dto.AudioRequestApprovalDTO;

public class AudioRequestApprovalService {

	public String processRequest(AudioRequestApprovalDTO dto) {
		AudioApprovalDAO dao = new AudioApprovalDAO();

		int id = Integer.parseInt(dto.getId().replaceAll("CVMX-", ""));
		dao.updateStatus(dto.getStatus(), id,dto.getApprovalId());
		return dto.getId() + "'s status updated to " + dto.getStatus();
	}

}
