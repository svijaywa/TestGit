package productSearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CountingFranceSeedPages {
	
	@Test
    public void ProductSearchDESite() throws InterruptedException { 
	
	   
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open site
		driver.get("https://www.syngenta.fr/semences");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		String s1 = driver.findElement(By.xpath("//a[@id= 'facetapi-link']")).getText();
		System.out.println("Total number of products " +s1);
		String s2 = driver.findElement(By.xpath("//a[@id= 'facetapi-link--2']")).getText();
		System.out.println("Total number of products " +s2);
		String s3 = driver.findElement(By.xpath("//a[@id= 'facetapi-link--3']")).getText();
		System.out.println("Total number of products " +s3);
		String s4 = driver.findElement(By.xpath("//a[@id= 'facetapi-link--4']")).getText();
		System.out.println("Total number of products " +s4);
		
		driver.quit();
		
	}

	

}
