package excelData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SyngentaSiteHost {
	
	 @Test(dataProvider="siteserver", groups={"Smoke"})
     public void siteInWhichServer(String countryname) throws InterruptedException
		{
     	
     	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.get(countryname);
        Thread.sleep(3000);
        String s1  = driver.getCurrentUrl();
        System.out.println(s1);
        
        if(driver.getPageSource().contains("Drupal"))
        {
        	
        	System.out.println("Site is in Drupal");
        }
        else{
        	System.out.println("Site is not in Drupal");
        }
        driver.close();	
		}
	 
		@DataProvider(name="siteserver")
		public Object[][] datapass()
		{
				ExcelDataConfig config = new ExcelDataConfig("C:/Soniya/SyngentaProject/TestData/test_server.xlsx");
				int rows = config.getRowCount(0);
				Object[][] data = new Object[rows][1];
				
				for(int i=0;i<rows;i++){
					
					data[i][0]=config.getData(0, i, 0);
				}
				return data;
		}

}
