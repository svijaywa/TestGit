package ReadFooter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;

public class ReadYear {

	@Test(dataProvider="year", groups={"Smoke"})
	public void siteHack(String countryname) throws InterruptedException
	{
		 
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(countryname);
		
	    WebElement ele1 = driver.findElement(By.cssSelector(".pane-syn-country-core-geography-indicator"));
	    String s2 = ele1.getText();
	    WebElement ele = driver.findElement(By.cssSelector(".pane-syn-panels-copyright"));
	    String s1 = ele.getText();
	    System.out.println("The year of "+s2  +s1);
		driver.close();
       	
	}
	
	@DataProvider(name="year")
	public Object[][] datapass()
	{
			ExcelDataConfig config = new ExcelDataConfig("C:/Soniya/SyngentaProject/TestData/countrylist.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][1];
			
			for(int i=0;i<rows;i++){
				
				data[i][0]=config.getData(0, i, 0);
			}
		return data;

}
}