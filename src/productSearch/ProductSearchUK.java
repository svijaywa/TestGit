package productSearch;

import java.util.concurrent.TimeUnit;

import library.BaseClass;
import library.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSearchUK extends BaseClass {

	@Test(groups={"Smoke"})
 	public void ProductSearchUKSite() throws InterruptedException { 
		
		test = extent.createTest("ProductSearchUKSite");
	    Assert.assertTrue(1>0);
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open site
		driver.get("https://www.syngenta.co.uk/products/search/crop-protection/");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Utility.captureScreenshot(driver, "SearchPageUK");
		WebElement ele1=driver.findElement(By.id("edit-search-api-views-fulltext"));
		ele1.clear();
		ele1.sendKeys("abcd123");
		ele1.sendKeys(Keys.ENTER);
		Utility.captureScreenshot(driver, "SearchpageResultUK");
		driver.close();
		
		

	}

}
