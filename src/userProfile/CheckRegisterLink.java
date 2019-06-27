package userProfile;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckRegisterLink {
	
	@Test(dataProvider="register")
	public void CheckRegisterLinkInSites(String countryname) throws InterruptedException
	{
    	
    	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.get(countryname);
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        WebElement element = driver.findElement(By.xpath("//a[contains(@href,\"/user/register\")]"));
       
        try {
        	element.isDisplayed();
        	System.out.println("Register link exists");
        	}
        
        	catch (NoSuchElementException e) {
            System.out.println("Register link doesnot exists");
        	}
  
		driver.close();
	}
		
	@DataProvider(name="register")
	public Object[][] datapass()
	{
			ExcelDataConfig config = new ExcelDataConfig("C:/Soniya/SyngentaProject/TestData/latestsite.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][1];
			
			for(int i=0;i<rows;i++){
				
				data[i][0]=config.getData(0, i, 0);
			}
			return data;
	}			
	

}
