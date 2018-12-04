package excelData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassCreation {

	
WebDriver driver;
	
	@BeforeClass
	public void setUpApplication(){
		
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");
		 
		// Initialize browser
		Reporter.log("=====Browser session Started=====", true);
		WebDriver driver=new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","C:/SeleniumSetup/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Open chrome
		driver.get("https://www.google.com/");
		Reporter.log("=====Application Started====", true);
		
	}
	
	@AfterClass
	public void closeApplication(){
		driver.quit();
		Reporter.log("=====Browser session Closed=====", true);
		
		
	}
	
	
	
}
