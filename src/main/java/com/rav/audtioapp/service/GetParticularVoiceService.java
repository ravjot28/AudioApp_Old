package com.rav.audtioapp.service;

import com.rav.audtioapp.dao.audio.GetAudioDAO;
import com.rav.audtioapp.dto.GetParticularAudioDTO;

public class GetParticularVoiceService {

	public String processRequest(GetParticularAudioDTO dto) {
		GetAudioDAO dao = new GetAudioDAO();

		int id = Integer.parseInt(dto.getId().replaceAll("CVMX-", ""));
		String voice = dto.getVoice();
		return dao.getParticularAudio(voice, id);
	}

}
