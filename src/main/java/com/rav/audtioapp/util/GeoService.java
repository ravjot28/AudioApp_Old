package com.rav.audtioapp.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GeoService {

	public static Map<String, String> getState(double lat, double lon) throws ParseException {
		Map<String, String> result = new HashMap<String, String>();
		String output = null;
		GetMethod httpGet = new GetMethod(

				"http://maps.google.com/maps/api/geocode/json?latlng=" + lat + "," + lon + "&sensor=false");
		HttpClient client = new HttpClient();

		try {
			int response = client.executeMethod(httpGet);
			if (response == HttpStatus.SC_OK) {
				byte[] responseBody = httpGet.getResponseBody();
				output = new String(responseBody);

			}

			JSONParser parser = new JSONParser();

			JSONObject input = (JSONObject) parser.parse(output);

			JSONArray values = (JSONArray) input.get("results");
			Iterator<JSONObject> iterator = values.iterator();
			while (iterator.hasNext()) {
				JSONObject v = iterator.next();

				JSONArray address = (JSONArray) v.get("address_components");
				Iterator<JSONObject> add = address.iterator();

				while (add.hasNext()) {
					JSONObject a = add.next();

					JSONArray types = (JSONArray) a.get("types");

					if (types.size() == 2) {
						if (types.contains("political")) {
							if (types.contains("locality")) {
								result.put("city", a.get("long_name").toString());
							} else if (types.contains("administrative_area_level_1")) {
								result.put("state", a.get("long_name").toString());
							}
						}
					}
					if (result.keySet().size() == 2)
						break;
				}
				if (result.keySet().size() == 2)
					break;
			}
		} catch (IOException e) {
		}

		return result;
	}

}
