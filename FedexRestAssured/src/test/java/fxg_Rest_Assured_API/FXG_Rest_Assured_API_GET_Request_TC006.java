package fxg_Rest_Assured_API;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FXG_Rest_Assured_API_GET_Request_TC006 {
	@Test
	public void printArraylist() {

		// Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response httpresponse = httprequest.request(Method.GET, "Biratnagar");

		JsonPath jsonpath = httpresponse.jsonPath();

		// System.out.println("City name is : " + jsonpath.get("City")); //

		/*
		 * System.out.println(jsonpath.get("Temperature")); //
		 * System.out.println(jsonpath.get("Humidity")); //
		 * System.out.println(jsonpath.get("WeatherDescription")); //
		 * System.out.println(jsonpath.get("WindSpeed")); //
		 * System.out.println(jsonpath.get("WindDirectionDegree"));
		 */

		ArrayList<String> al = new ArrayList<String>();
		al.add("Temperature");
		al.add("Humidity");
		al.add("WeatherDescription");
		al.add("WindSpeed");
		al.add("WindDirectionDegree");

//		System.out.println("ArrayList is: " + al);
		String[] array = new String[al.size()];
		List<String> list = new ArrayList<String>();
		int i = 0;
		for (String a : al) {
//			System.out.println(a + ": " + jsonpath.get(a.trim()));
			array[i] = jsonpath.getString(a.trim());
			list.add(jsonpath.getString(a.trim()));
			i++;
		}
		System.out.println(list);

		// Print response from the server

		/*
		 * String responseBody = httpresponse.getBody().asString();
		 * System.out.println("Response body is : "+responseBody);
		 */
	}
}
