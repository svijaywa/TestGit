package weatherWidget;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckWeatherAPIs {
	
	@Test
	public void weatherAPIResponseCode() throws InterruptedException{
		
		        //Spray Window API
		
				RestAssured.baseURI = "http://services.syngenta-ais.com/V2/model-data.svc/GetRecommendation";
				RequestSpecification httpRequest = RestAssured.given().urlEncodingEnabled(false).queryParam("token", "21A618CB-2734-463C-96D7-1E8827D7C562").queryParam("wkt", "%27POINT(40.00962770000001%2055.251307)%27").queryParam
				("$filter", "SprayingType%20eq%20%27sw_groundspraygeneric%27%20and%20Date%20ge%20datetime%272019-06-28%27%20and%20Date%20lt%20datetime%272019-06-25%27").queryParam
				("$format", "json");
			    Response response = httpRequest.request(Method.GET);
				int code = response.getStatusCode();
				System.out.println("Spray Window API Status Code " +code);
				
			    
			    //DailyWidget API
			    
			    RestAssured.baseURI = "https://services.syngenta-ais.com/V2/env-data.svc/GetFcstDaily";
				RequestSpecification httpRequest1 = RestAssured.given().urlEncodingEnabled(false).queryParam("token", "21A618CB-2734-463C-96D7-1E8827D7C562").queryParam("wkt", "%27POINT(38.187121599999955%2055.84268429999999)%27").queryParam
				("$filter", "Date%20ge%20datetime%272019-06-28%27%20and%20Date%20lt%20datetime%272019-07-01%27%20and%20(MeasureLabel%20eq%20%27Precip_DailySum%20(mm)%27%20or%20MeasureLabel%20eq%20%27TempAir_DailyMin%20(C)%27%20or%20MeasureLabel%20eq%20%27TempAir_DailyMax%20(C)%27%20or%20MeasureLabel%20eq%20%27PictoCode_Daily%27%20or%20MeasureLabel%20eq%20%27WindDirection_DailyAvg%27%20or%20MeasureLabel%20eq%20%27WindSpeed_DailyAvg%20(m/s)%27%20or%20MeasureLabel%20eq%20%27Predictability_Daily%20(pct)%27)").queryParam
				("$format", "json");
			    Response response1 = httpRequest.request(Method.GET);
				int code1 = response1.getStatusCode();
				System.out.println("DailyWidget API Status Code " +code);
			    
			   //HourlyWidget API
				
				
				}

}
