package ReadFooter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;

public class FindSiteLanguages {
	
	Boolean dd;
	
	@Test(dataProvider="language", groups={"Smoke"})
	public void siteHack(String countryname) throws InterruptedException
	{
		 
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(countryname);
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		try {
		if(driver.findElement(By.xpath("//select[@name='syn_language_switcher']"))!=null)
			{
				
				WebElement selectElement=driver.findElement(By.xpath("//select[@name='syn_language_switcher']"));
				Select select = new Select(selectElement);
				List<WebElement> allOptions = select.getOptions();
				System.out.println(allOptions.size());

				}
		
		else{
			System.out.println("Element not displayed");
			}
		}
		catch(Exception e) {
			System.out.println("Element not present");
			
		}
		driver.close();
       	
	}
	
	@DataProvider(name="language")
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
