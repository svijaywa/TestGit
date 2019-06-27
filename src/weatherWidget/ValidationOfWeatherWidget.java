package weatherWidget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ValidationOfWeatherWidget {
	
	
	@Test
    public void CheckingWeatherWidget() throws InterruptedException, ClientProtocolException, IOException { 

	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	 
	// Initialize browser
	WebDriver driver=new ChromeDriver();
	 
	// Open site
	driver.get("https://Syngenta:Syngenta1@fr.test-syngentacp.acsitefactory.com/user");
	 
	// Maximize browser
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//Log in to site

	WebElement ele = driver.findElement(By.id("edit-name"));
	ele.clear();
	ele.sendKeys("soniya.vijaywargi@syngenta.com");
	WebElement ele1 = driver.findElement(By.id("edit-pass"));
	ele1.clear();
	ele1.sendKeys("10Soniya#2018!");
	WebElement wb = driver.findElement(By.id("edit-submit"));
	wb.click();
	driver.get("https://fr.test-syngentacp.acsitefactory.com/uat-syngenta-weather-landing-page-drupal");
	
	//Validating the search box
	
	Thread.sleep(3000);
	driver.findElement(By.id("edit-search-location")).sendKeys("Delhi India" +"\n");
	Thread.sleep(3000);
	String s1 = driver.findElement(By.xpath("//div[@id=\"lat-and-long\"]")).getText();
	System.out.println(s1);
	((JavascriptExecutor)driver).executeScript("window.open()");
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1)); 
	driver.get("https://www.google.com");
	driver.findElement(By.name("q")).sendKeys("Delhi India latitude and longitude" +"\n");
	String s2 = driver.findElement(By.xpath("//div[@class=\"Z0LcW\"]")).getText();
	System.out.println(s2);
	if (s1.equals(s2)) {
		
		System.out.println("correct");
	}
	else {
		System.out.println("Not correct");
	}
	
	//Validate the graph
	driver.switchTo().window(tabs.get(0));
	//driver.get("https://fr.test-syngentacp.acsitefactory.com/uat-syngenta-weather-landing-page-drupal");
	driver.findElement(By.xpath("//button[@class=\"disabled active-graph\"]")).click();
	if (driver.findElements(By.xpath("//div[@id=\"weather-chart\"]")).size() != 0)
	{
		System.out.println("Graph is Present");
		
	}
	else {
		System.out.println("Graph is not present");
	}
	
	
	//Validating number of days in multiple widget
	
	List<WebElement> webele = driver.findElements(By.xpath("//div[@class=\"slick-track\"]/div/div"));
	System.out.println(webele.size());
	//Validating data coming in multiple day widget
	
	for(WebElement eles:webele)
	{
		String a1 = eles.getAttribute("class");
		System.out.println(a1);
		
		if(a1.contains("content-9"))
		{
			
			String text = driver.findElement(By.xpath("//div[@class=\"slick-track\"]/div/div")).getText();
			System.out.println(text);
			break;
		}
	driver.close();
		
	}
	
	
	
	
	

	
	
	
	
	
}
}