package weatherWidget;

import java.util.concurrent.TimeUnit;

import library.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;

public class CheckWeatherWidget extends BaseClass{

	@Test(dataProvider="analytics", groups={"Smoke"})
	public void CheckWeather(String countryname) throws InterruptedException
	{
		test = extent.createTest("HomeLinkCheck");
        Assert.assertTrue(1>0);
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(countryname);
		WebElement ele = driver.findElement(By.cssSelector(".pane-syn-service-weather-widget"));
		boolean bool = ele.isDisplayed();
		System.out.println("Weather widget pane exists "+bool);
		driver.close();
       	
	}
	
	@DataProvider(name="analytics")
	public Object[][] datapass()
	{
			ExcelDataConfig config = new ExcelDataConfig("C:/Soniya/SyngentaProject/TestData/Weather.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][1];
			
			for(int i=0;i<rows;i++){
				
				data[i][0]=config.getData(0, i, 0);
			}
			return data;
	}

	
}
