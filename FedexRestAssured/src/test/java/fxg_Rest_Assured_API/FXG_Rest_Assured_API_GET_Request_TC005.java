package fxg_Rest_Assured_API;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FXG_Rest_Assured_API_GET_Request_TC005 {

	@Test
	public void captureAllJsonContains() {

		// Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response httpresponse = httprequest.request(Method.GET, "Biratnagar");

		httpresponse.body().
		
		JsonPath jsonpath = httpresponse.jsonPath();

		// System.out.println("City name is : " + jsonpath.get("City")); //
		System.out.println(jsonpath.get("Temperature")); //
		System.out.println(jsonpath.get("Humidity")); //
		System.out.println(jsonpath.get("WeatherDescription")); //
		System.out.println(jsonpath.get("WindSpeed")); //
		System.out.println(jsonpath.get("WindDirectionDegree"));

		// Print response from the server
		System.out.println(httpresponse.getBody().prettyPrint());

		String responseBody = httpresponse.getBody().asString(); //
		System.out.print("Response body is : " + responseBody);

		// Status code valitation

		int statusCode = httpresponse.getStatusCode(); //
		System.out.println("Weather status is :" + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status line vallidation
		String statusLine = httpresponse.statusLine(); //
		System.out.println("Status line is:  " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

//	@Test
	public static void test() {
		Response res = RestAssured.given().basePath("http://restapi.demoqa.com/utilities/weather/city/").get();
//		System.out.println(res.body().jsonPath().getMap(""));
		System.out.println(res.getBody().prettyPrint());
	}
}
