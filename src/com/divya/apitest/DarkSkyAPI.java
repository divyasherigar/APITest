package com.divya.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DarkSkyAPI {
	static RequestSpecification httpRequest;
	Response httpResponse;
	static String strbaseUrl = "https://api.darksky.net/forecast/97345f47d1bbc6456199d3f522ad4882/";
	static String[] strVerifyFields = { "latitude", "longitude", "timezone", "currently", "minutely", "hourly", "daily",
			"flags", "offset" };

	@Test
	public void getCoordinates() {
		RestAssured.baseURI = strbaseUrl;
		httpRequest = RestAssured.given();
		httpResponse = httpRequest.request(Method.GET, "37.8267,-122.4233");
		String responseBody = httpResponse.getBody().asString();

		// Print all the fields which are present in the response body
		System.out.println("Printing fields which are present in the response body");
		for (String verify : strVerifyFields) {
			if (responseBody.contains(verify)) {
				System.out.println(verify);
				Assert.assertTrue(true);
			} else {
				System.out.println(verify);
				Assert.assertFalse(true);
			}
		}

	}
}
