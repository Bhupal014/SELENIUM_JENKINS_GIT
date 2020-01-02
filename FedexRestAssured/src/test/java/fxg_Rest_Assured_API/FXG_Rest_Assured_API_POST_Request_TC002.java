package fxg_Rest_Assured_API;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FXG_Rest_Assured_API_POST_Request_TC002 {
	
	
	
	  @Test
	  public void registerCustomer() {
		  
		  //Specify Base URI
		  RestAssured.baseURI = "http://restapi.demoqa.com/customer";  
		  
		  
		  //Request Object
		  RequestSpecification httpRequest = RestAssured.given();
		  
		 
		  //Request Parameters/Request payload/Request body in json format
		  
		  JSONObject requestParameters = new JSONObject();
		  requestParameters.put("Firstname", "Fname");
		  requestParameters.put("Lastname", "Lname");
		  requestParameters.put("Username", "Uname");
		  requestParameters.put("Password", "Passwd");
		  requestParameters.put("Email", "Ename");
		  
		  httpRequest.header("Content-Type", "application/JSON");
		  httpRequest.body(requestParameters.toJSONString()); 	
		  
		  //Response Object		  
		  Response httpresponse = httpRequest.request(Method.POST, "/register");
		  
		  //Print response from the server
		  String responseBody = httpresponse.getBody().asString();
		  System.out.println("Response body is : "+responseBody);
		  
		  //Status code valitation
		  
		 int statusCode = httpresponse.getStatusCode();
		 System.out.println("Weather status is :"+statusCode);
		 Assert.assertEquals(statusCode, 400);
		 
		 //Success code vallidation
		 String successCode = httpresponse.jsonPath().get("SuccessCode");
		 Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		 
		 System.out.println("Test case successfull");
		
  }
}
