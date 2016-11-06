package com.rav.audtioapp.action;

import com.rav.audtioapp.dao.param.ParamsDAO;

public class UpdateParameterAction {
	private String parameterName;
	private String parameterValue;

	public String execute() {
		ParamsDAO dao = new ParamsDAO();
		dao.deactiavteParam(parameterName);
		dao.insertParam(parameterName, parameterValue);
		return "success";
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

}
