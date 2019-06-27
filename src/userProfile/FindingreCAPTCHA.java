package userProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;


public class FindingreCAPTCHA {
	
	
	@Test(dataProvider="reCAPTCHA")
	public void reCAPTCHA(String countryname) throws InterruptedException
	{
    	
    	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.get(countryname);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String newURL = url+"/user/register";
        driver.get(newURL);
        Thread.sleep(3000);
    //   if (driver.findElements(By.xpath("//div[text()=\"reCAPTCHA\"]")).size() !=0) {
    //	   System.out.println("Recaptcha is present");
    //   }
    //   else {
    //	   System.out.println("Recaptcha is not present");
    //   }
        
       if(driver.getPageSource().contains("recaptcha")){
    	   System.out.println("ReCaptcha is present");
    	   
    	   }else if(driver.getPageSource().contains("math problem")){
    	   System.out.println("mCaptcha is present");
    	   }
    	   else if(driver.getPageSource().contains("access denied")){
        	   System.out.println("Registration form is not present");
        	   }
    	   else {
    		   System.out.println("Absent");
    	   }
		driver.close();
	}
		
	@DataProvider(name="reCAPTCHA")
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

