package com.rav.audtioapp.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class GeoService {

	public static void main(String[] args) {
		String data = GeoService.getState(44.237709,-76.5141572);
		System.out.println(data);
	}

	public static String getState(double lat, double lon) {
		String result = null;

		GetMethod httpGet = new GetMethod(

				"http://maps.google.com/maps/api/geocode/json?latlng=" + lat + "," + lon + "&sensor=false");
		HttpClient client = new HttpClient();

		try {
			int response = client.executeMethod(httpGet);
			if (response == HttpStatus.SC_OK) {
				byte[] responseBody = httpGet.getResponseBody();
				result = new String(responseBody);

			}
		} catch (IOException e) {
		}

		return result;
	}

}
