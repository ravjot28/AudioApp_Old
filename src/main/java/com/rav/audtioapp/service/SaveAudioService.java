package com.rav.audtioapp.service;

import com.rav.audtioapp.dao.SaveAudioDAO;
import com.rav.audtioapp.dto.SaveAudioDTO;

public class SaveAudioService {
	

	public String processRequest(SaveAudioDTO dto) {
		SaveAudioDAO dao = new SaveAudioDAO();
		int id = dao.insertNewAudio(dto);
		return "STRATHY-" + id;
	}

}
