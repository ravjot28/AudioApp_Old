package com.rav.audtioapp.action;

import com.rav.audtioapp.service.GetAudioService;

public class GetLocationAction {

	private String jsonString;

	public String execute() {
		System.out.println("In getAudio");
		jsonString = new GetAudioService().processRequest("Approved");
		return "success";
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
