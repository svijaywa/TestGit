package api;

import java.awt.print.Book;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

public class WeatherAPI {
	
	@Test
	public void testResponseCode() throws InterruptedException{
		
		        
				RestAssured.baseURI = "http://synqa.test-syngentacp.acsitefactory.com/api/data";
				RequestSpecification httpRequest = RestAssured.given();
				Response response = httpRequest.request(Method.GET, "/product_cp?api-key=8147552e-ac10-4338-9679-a1b1f8723eca");
				int code = response.getStatusCode();
				System.out.println(code);
				Thread.sleep(5000);
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is =>  " + responseBody);
				JsonPath jsonPath = new JsonPath(responseBody);
			    JsonPath jsonPathEvaluator = response.jsonPath();
			    System.out.println("Data received from Response " + jsonPathEvaluator.get("151.field_link.und"));
				}
			 	


}
