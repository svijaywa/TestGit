package goliveChecks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckLinks {
	
     @Test 
     public void LinksVerify() {
    	 
    	 System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
    	    WebDriver driver=new ChromeDriver();
    	    driver.manage().window().maximize();
    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	    driver.get("https://Syngenta:Syngenta1@preprod.syngentadrptest.com");
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
