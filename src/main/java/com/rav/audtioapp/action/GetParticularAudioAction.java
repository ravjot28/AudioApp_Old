package com.rav.audtioapp.action;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rav.audtioapp.dto.GetParticularAudioDTO;
import com.rav.audtioapp.service.GetParticularVoiceService;

public class GetParticularAudioAction {
	private String jsonString;
	List<String> array = new ArrayList<String>();

	public List<String> getArray() {
		return array;
	}

	public void setArray(List<String> array) {
		this.array = array;
	}

	public String execute() {
		// System.out.println(array);
		GetParticularAudioDTO dto = getDTO(array.get(0));

		jsonString = new GetParticularVoiceService().processRequest(dto);
		return "success";
	}

	private GetParticularAudioDTO getDTO(String data) {
		GetParticularAudioDTO dto = new GetParticularAudioDTO();

		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setId(getValue(obj, "id"));
		dto.setVoice(getValue(obj, "voice"));
		return dto;
	}

	private String getValue(JSONObject obj, String key) {
		String value = null;
		try {
			value = (String) obj.get(key);
		} catch (Exception e) {

		}
		return value;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
