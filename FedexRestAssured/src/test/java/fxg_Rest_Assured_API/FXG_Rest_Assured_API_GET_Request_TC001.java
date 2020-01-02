package fxg_Rest_Assured_API;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class FXG_Rest_Assured_API_GET_Request_TC001 {

  @Test
  public void getWeatherCondition() {
	  
	  //Specify Base URI
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
	  
	  //Request Object
	  RequestSpecification httprequest = RestAssured.given();
	
		 
	  //Response Object
	  Response httpresponse = httprequest.request(Method.GET, "Biratnagar");
	  
	  //Print response from the server
	  String responseBody = httpresponse.getBody().asString();
	  System.out.println("Response body is : "+responseBody);
	  
	  //Status code valitation
	  
	 int statusCode = httpresponse.getStatusCode();
	 System.out.println("Weather status is :"+statusCode);
	 Assert.assertEquals(statusCode, 200);
	 
	 //Status line vallidation
	 String statusLine = httpresponse.statusLine();
	 System.out.println("Status line is:  "+statusLine);
	 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	 System.out.println("Status line is:  "+statusLine);
	 
	 
	 
	  
	  
	  
  }
}
