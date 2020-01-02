package fxg_Rest_Assured_API;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class FXG_Rest_Assured_API_GET_Request_TC003 {
	

	  @Test
	  public void googleMapTest() {
		  
		  //Specify Base URI
		  RestAssured.baseURI = "http://maps.googleapis.com";
		  
		  //Request Object
		  RequestSpecification httpRequest = RestAssured.given();
		  
		  //Response Object
		  Response httpResponse = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermaret&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jyls");
		  
		  
		  
		  
		  
		  
		  
		  //Print response from the server
		  String responseBody = httpResponse.getBody().asString();
		  System.out.println("Response body is : "+responseBody);
		  
		//Capture details headers from response
		  String contentType = httpResponse.header("Content-Type");
		 System.out.println("Content type is:  " +contentType);
		 Assert.assertEquals(contentType,"application/xml; charset=UTF-8");
		 
		 String contentEncoding = httpResponse.header("Content-Encoding");
		 System.out.println("Content Enconding is:  " +contentEncoding);
		 Assert.assertEquals(contentEncoding,"gzip");
		 
		  
		  
		  
	  }
}
