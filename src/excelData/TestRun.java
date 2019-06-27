package excelData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import library.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRun extends BaseClass {

	
	        @Test(dataProvider="sitestatuscheck", groups={"Smoke"})
	        public void siteHack(String countryname) throws InterruptedException
			{
	        	test = extent.createTest("siteHack");
	    	    Assert.assertTrue(1>0);
	        	
	        	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
                driver.get(countryname);
                Thread.sleep(3000);
                RestAssured.baseURI = countryname;
                RestAssured.useRelaxedHTTPSValidation();
        		RequestSpecification httpRequest = RestAssured.given();
        		Response response = httpRequest.get();
        		int statusCode = response.getStatusCode();
        		System.out.println(statusCode);
        		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        		String s1 = driver.getTitle();
        		System.out.println(s1);
        		driver.close();
			}
				
			@DataProvider(name="sitestatuscheck")
			public Object[][] datapass()
			{
					ExcelDataConfig config = new ExcelDataConfig("C:/Soniya/SyngentaProject/TestData/latestsite.xlsx");
					int rows = config.getRowCount(0);
					Object[][] data = new Object[rows][1];
					
					for(int i=0;i<rows;i++){
						
						data[i][0]=config.getData(0, i, 0);
					}
					return data;
			}			

}
