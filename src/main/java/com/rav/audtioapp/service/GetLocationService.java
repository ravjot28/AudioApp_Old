package com.rav.audtioapp.service;

import java.util.List;

import com.rav.audtioapp.dao.audio.GetLocationDAO;

public class GetLocationService {

	public String processRequest() {
		String result = "";
		List<String> data = null;

		data = new GetLocationDAO().getLocation();
		System.out.println("Returned list size " + data.size());
		if (data.size() > 0) {
			for (String d : data) {
				result += d + "";
			}
		}

		return result;
	}

}
