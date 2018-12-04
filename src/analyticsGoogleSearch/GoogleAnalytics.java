package analyticsGoogleSearch;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;

public class GoogleAnalytics {

	@Test(dataProvider="analytics", groups={"Smoke"})
	public void siteHack(String countryname) throws InterruptedException
	{
		 
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(countryname);
		Thread.sleep(5000);
		if(driver.getPageSource().contains("UA-100579674-1"))
        {
        	
        	System.out.println("Google Analytics code is present");
        }
        else{
        	System.out.println("Google Analytics code is not present");
        }
        driver.close();	
	}
	
	@DataProvider(name="analytics")
	public Object[][] datapass()
	{
			ExcelDataConfig config = new ExcelDataConfig("C:/SeleniumSetup/Project/SyngentaProject/TestData/countrylist.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][1];
			
			for(int i=0;i<rows;i++){
				
				data[i][0]=config.getData(0, i, 0);
			}
			return data;
	}
}
