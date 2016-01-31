package com.rav.audtioapp.service;

import com.rav.audtioapp.dao.SaveAudioDAO;
import com.rav.audtioapp.dto.SaveAudioDTO;
import com.rav.audtioapp.util.SendMailCommunication;

public class SaveAudioService {

	public String processRequest(SaveAudioDTO dto) {
		SaveAudioDAO dao = new SaveAudioDAO();
		int id = dao.insertNewAudio(dto);

		new Thread(new SendMailCommunication("riehla@queensu.ca",
				"Canadian English Voice Map user " + "STRATHY-" + id + " is ready for review.",
				"New audio submission " + "STRATHY-" + id)).start();

		new Thread(new SendMailCommunication(dto.getEmailAddress(),
				"Thank you for participating in the Canadian English Voice Map! Your reference number is " + "STRATHY-"
						+ id
						+ ".\n If you have any questions about your submission, please contact CEVM@queensu.ca.\n\n- The Strathy Language Unit",
				"Your reference number is:" + "STRATHY-" + id)).start();

		return "STRATHY-" + id;
	}

}
