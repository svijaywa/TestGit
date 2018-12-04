package productSearch;

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

public class ProductBreadcrumb extends BaseClass{

	@Test(dataProvider="breadcrumb", groups={"Smoke"})
 	public void ProductCPBreadcrumb(String countryname) throws InterruptedException { 
		
		test = extent.createTest("BreadcrumbUK");
	    Assert.assertTrue(1>0);
	    
	    System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(countryname);
		driver.findElement(By.xpath("//div[@class='pane-title facets-processed']")).click();
		driver.findElement(By.id("facetapi-link--2--checkbox")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//div[@class='breadcrumb']"));
		String value = ele.getText();
		System.out.println(value);
		driver.close();
       	
	}
	
	@DataProvider(name="breadcrumb")
	public Object[][] datapass()
	{
			ExcelDataConfig config = new ExcelDataConfig("C:/Soniya/SyngentaProject/TestData/ProductCPSearch.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][1];
			
			for(int i=0;i<rows;i++){
				
				data[i][0]=config.getData(0, i, 0);
			}
			return data;
	}

	
}


