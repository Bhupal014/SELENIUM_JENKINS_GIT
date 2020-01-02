package fxg_Rest_Assured_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FXG_Rest_Assured_API_GET_Request_TC004 {
  @Test
  public void getWeatherDetails() {
	  

	  //Specify Base URI
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
	  
	  //Request Object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Requesst Object
	  Response httpResponse = httpRequest.request(Method.GET, "Mumbai");
	  
	  //Print response from the server
	  String responseBody = httpResponse.getBody().asString();
	  System.out.println("Weather status is : "+responseBody);
	
	  
	  //Status Contains vallidation
	  Assert.assertEquals(responseBody.contains("Mumbai"), true);
	
	  
	
  }
}
