package userProfile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckSocial {
	
	@Test
	public void socialLogin() throws InterruptedException
	{
    	
    	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.syngenta.ru");
       // driver.get("https://Syngenta:Syngenta1@preprod.syngentadrptest.com");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String newURL = url+"/user";
        driver.get(newURL);
        Thread.sleep(3000);
        
      if (driver.findElements(By.xpath("//div[@class=\"social fl-right\"]")).size() !=0) {
      System.out.println("Social Login is present");
      List<WebElement> allEle = driver.findElements(By.xpath("//div[@class=\"social fl-right\"]/div/div/div/ul/li"));
      Integer b1 = allEle.size();
      System.out.println(b1);
      
      for(WebElement eles:allEle)
  	{	
      String s1 =eles.getText();
      System.out.println(s1);
       }
      }
      else {
       System.out.println("Social Login is not present");
      }
      
     
        
     
		driver.close();
	}

}
