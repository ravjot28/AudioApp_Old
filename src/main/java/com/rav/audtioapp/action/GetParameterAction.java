package com.rav.audtioapp.action;

import java.util.ArrayList;
import java.util.List;

import com.rav.audtioapp.dao.param.ParamsDAO;

public class GetParameterAction {
	private String jsonString;
	List<String> array = new ArrayList<String>();

	public List<String> getArray() {
		return array;
	}

	public void setArray(List<String> array) {
		this.array = array;
	}

	public String execute() {
		jsonString = new ParamsDAO().getParamValues();
		return "success";
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
