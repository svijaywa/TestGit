package guru99Project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase4 {
		
		private WebDriver driver;
		  private String baseUrl;
		  String errMsg = "Some of the products cannot be ordered in requested quantity.";
		  
		@BeforeTest
		public void setUp() throws Exception {
			
			System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		    driver = new ChromeDriver();
		    baseUrl = "http://live.guru99.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  
		  @Test
		  public void testTestCase4() throws Exception {
			
			// 1. Go to http://live.guru99.com
		    driver.get(baseUrl); 
		    
		    // 2. Click on Mobile menu
		    driver.findElement(By.linkText("MOBILE")).click();	
		  
		    // 4. Comparing two Mobiles 	   
		    
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//span/span[text()=\"Compare\"]")).click();
		
			

	}

}
