package com.rav.audtioapp.service;

import java.util.List;

import com.rav.audtioapp.dao.audio.GetAudioDAO;

public class GetAudioService {

	public String processRequest(String audioFilter) {
		String result = "";
		List<String> data = null;
		System.out.println("Get audio request for " + audioFilter);
		if (audioFilter.equals("Unapproved"))
			data = new GetAudioDAO().getUnApprovedAudio();

		if (audioFilter.equals("Approved"))
			data = new GetAudioDAO().getApprovedAudio();

		System.out.println("Returned list size " + data.size());
		for (String d : data) {
			result += d + "{}";
		}

		return result;
	}

}
