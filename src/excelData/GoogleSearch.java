package excelData;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BaseClass;

public class GoogleSearch extends BaseClassCreation{

		
		@Test(dataProvider="hacking")
		public void siteHack(String countryname) throws InterruptedException
		{
			 
			System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");
			 
			// Initialize browser
			WebDriver driver=new ChromeDriver();
			//System.setProperty("webdriver.gecko.driver","C:/SeleniumSetup/geckodriver/geckodriver.exe");
			//WebDriver driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			// Open chrome
			driver.get("https://www.google.com/");
		    driver.findElement(By.id("lst-ib")).sendKeys(countryname);
			driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			if(driver.getPageSource().contains("This site might be hacked"))
	        {
	        	
	        	System.out.println("Site is hacked");
	        }
	        else{
	        	System.out.println("Site is not hacked");
	        }
	       driver.close();
		}
		
		@DataProvider(name="hacking")
		public Object[][] datapass()
		{
				ExcelDataConfig config = new ExcelDataConfig("C:/SeleniumSetup/Project/SyngentaProject/TestData/Book1.xlsx");
				int rows = config.getRowCount(0);
				Object[][] data = new Object[rows][1];
				
				for(int i=0;i<rows;i++){
					
					data[i][0]=config.getData(0, i, 0);
				}
				return data;
		}	
	}

	

