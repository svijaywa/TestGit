package productSearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.Utility;

public class NumberOfProducts {
	
	@Test
    public void ProductSearchDESite() throws InterruptedException { 
	
	   
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open site
		driver.get("https://www.syngenta.be/products/search/crop-protection");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		String s1 = driver.findElement(By.xpath("//a[@id= 'facetapi-link']")).getText();
		System.out.println("Total number of products " +s1);
		
		
		driver.get("https://www.syngenta.nl/products/search/crop-protection");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		String s2 = driver.findElement(By.xpath("//a[@id= 'facetapi-link']")).getText();
		System.out.println("Total number of products " +s2);
		driver.quit();
		
	}

	

}
