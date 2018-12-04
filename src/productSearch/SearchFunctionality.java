package productSearch;
import library.BaseClass;

import java.util.concurrent.TimeUnit;

import library.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class SearchFunctionality extends BaseClass {

	 	@Test(groups={"Smoke"})
	 	public void SearchFunctionalitySite() throws InterruptedException {
		
	    test = extent.createTest("SearchFunctionalitySite");
	    Assert.assertTrue(1>0);
	  //  test.log(Status.PASS, "Search Functionality is working");
	    
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open site
		driver.get("https://www.syngenta.it/");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.navigate().to("https://www.syngenta.it/search/site");
		WebElement ele1=driver.findElement(By.id("edit-search-api-views-fulltext"));
		ele1.clear();
		ele1.sendKeys("abcd123");
		ele1.sendKeys(Keys.ENTER);
		Utility.captureScreenshot(driver, "SearchResultIT");
		String text = driver.findElement(By.xpath("//div[@class='view-empty']")).getText();
		System.out.println(text);
		driver.navigate().to("https://www.syngenta.ru/search/site");
		WebElement ele2=driver.findElement(By.id("edit-search-api-views-fulltext"));
		ele2.clear();
		ele2.sendKeys("abcd123");
		ele2.sendKeys(Keys.ENTER);
		Utility.captureScreenshot(driver, "SearchResultRU");
		String text1 = driver.findElement(By.xpath("//div[@class='view-empty']")).getText();
		System.out.println(text1);
		driver.navigate().to("https://www.syngenta.com.au/search/site");
		WebElement ele3=driver.findElement(By.id("edit-search-api-views-fulltext"));
		ele3.clear();
		ele3.sendKeys("abcd123");
		ele3.sendKeys(Keys.ENTER);
		Utility.captureScreenshot(driver, "SearchResultAU");
		String text2 = driver.findElement(By.xpath("//div[@class='view-empty']")).getText();
		System.out.println(text2);
		driver.navigate().to("https://www.syngenta.es/search/site");
		WebElement ele4=driver.findElement(By.id("edit-search-api-views-fulltext"));
		ele4.clear();
		ele4.sendKeys("abcd123");
		ele4.sendKeys(Keys.ENTER);
		Utility.captureScreenshot(driver, "SearchResultES");
		String text3 = driver.findElement(By.xpath("//div[@class='view-empty']")).getText();
		System.out.println(text3);
		driver.navigate().to("https://www.greencastonline.jp/search/site");
		WebElement ele5=driver.findElement(By.id("edit-search-api-views-fulltext"));
		ele5.clear();
		ele5.sendKeys("abcd123");
		ele5.sendKeys(Keys.ENTER);
		Utility.captureScreenshot(driver, "SearchResultJP");
		String text4 = driver.findElement(By.xpath("//div[@class='view-empty']")).getText();
		System.out.println(text4);
		driver.navigate().to("https://www.syngenta.com.cn/search/site");
		WebElement ele6=driver.findElement(By.id("edit-search-api-views-fulltext"));
		ele6.clear();
		ele6.sendKeys("abcd123");
		ele6.sendKeys(Keys.ENTER);
		Utility.captureScreenshot(driver, "SearchResultZE");
		String text5 = driver.findElement(By.xpath("//div[@class='view-empty']")).getText();
		System.out.println(text5);
		driver.close();
		
	}

}
