package siteNavigation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SyngentaFR {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Maximize the browser
		driver.manage().window().maximize();
		//Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.syngenta.fr");
		//Used tagName method to collect the list of items with tagName "a"
		//findElements - to find all the elements with in the current page. It returns a list of all webelements or an empty list if nothing matches
		List<WebElement> links = driver.findElements(By.tagName("a"));	
		//To print the total number of links
		System.out.println("Total links are "+links.size());	
		for(int i=0; i<links.size(); i++) {
			WebElement element = links.get(i);
			//By using "href" attribute, we could get the url of the required link
			String url=element.getAttribute("href");
			verifyLink(url);			
		}	
	}
	
	// The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
	public static void verifyLink(String urlLink)
	{
		try {
		RestAssured.baseURI = urlLink;
        RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		int statusCode = response.getStatusCode();
		System.out.println(urlLink);
		System.out.println(statusCode);
		//Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		}
		catch (Exception e) {
	           
        }
    } 
		
}
