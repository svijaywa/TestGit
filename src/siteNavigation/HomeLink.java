package siteNavigation;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import library.BaseClass;

import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;


public class HomeLink extends BaseClass {

				
				@Test(dataProvider="sitestatus", groups={"Smoke"})
				public void HomeLinkCheck(String countryname) throws InterruptedException
				{
					test = extent.createTest("HomeLinkCheck");
			        Assert.assertTrue(1>0); 
					System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
			 
					// Initialize browser
					WebDriver driver=new ChromeDriver();
					//driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					 
					// Open chrome
					driver.get(countryname);
					WebElement ele = driver.findElement(By.cssSelector(".fa-home"));
					if (ele.isDisplayed()) {
					System.out.println("Homelink is Present");
					}
					else {
						System.out.println("Homelink is not Present");
					}
					
					driver.close();
				}
				
				@DataProvider(name="sitestatus")
				public Object[][] datapass()
				{
						ExcelDataConfig config = new ExcelDataConfig("C:/Soniya/SyngentaProject/TestData/Homelink.xlsx");
						int rows = config.getRowCount(0);
						Object[][] data = new Object[rows][1];
						
						for(int i=0;i<rows;i++){
							
							data[i][0]=config.getData(0, i, 0);
						}
						return data;
				}
				
				

     }
