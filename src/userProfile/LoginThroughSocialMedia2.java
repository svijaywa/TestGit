package userProfile;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginThroughSocialMedia2 {
	
	@Test
	public void socialLogin() throws InterruptedException
	{
    	
    	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
    	
    	//Login through Facebook
		WebDriver driver=new ChromeDriver();
		driver.get("https://Syngenta:Syngenta1@synqa.test-syngentacp.acsitefactory.com/");
       // driver.get("https://Syngenta:Syngenta1@preprod.syngentadrptest.com");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String newURL = url+"/user";
        driver.get(newURL);
        Thread.sleep(3000);
        
      if (driver.findElements(By.xpath("//div[@class=\"social fl-right\"]")).size() !=0) {
      System.out.println("Social Login is present");
      }
      String mainWindow = driver.getWindowHandle();
      
      //Login through Facebook
      WebElement ele = driver.findElement(By.xpath("//div[@class=\"social fl-right\"]/div/div/div/ul/li/a/span[@title=\"Facebook\"]"));
      
      Actions act = new Actions(driver);
      act.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).build().perform();
      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(tabs.get(1));
      Thread.sleep(3000);
      driver.findElement(By.id("email")).sendKeys("soniya.vijaywargi64@gmail.com");
      Thread.sleep(3000);
      driver.findElement(By.id("pass")).sendKeys("chatwinvijaywargi");
      driver.findElement(By.name("login")).click();
      Thread.sleep(3000);
      String loginURL = driver.getCurrentUrl();
      System.out.println(loginURL);
      Assert.assertEquals(loginURL, "https://synqa.test-syngentacp.acsitefactory.com/user", "Expected is not same as that of actual URL");
      driver.get("https://synqa.test-syngentacp.acsitefactory.com/user/logout");
      driver.close();
	  driver.switchTo().window(mainWindow);
      
      
    //Login through Twitter
      WebElement ele1 = driver.findElement(By.xpath("//div[@class=\"social fl-right\"]/div/div/div/ul/li/a/span[@title=\"Twitter\"]"));
      Actions act1 = new Actions(driver);
      act1.keyDown(Keys.CONTROL).click(ele1).keyUp(Keys.CONTROL).build().perform();
      ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(tabs1.get(1));
      Thread.sleep(3000);
      driver.findElement(By.id("username_or_email")).sendKeys("soniya.vijaywargi64@gmail.com");
      Thread.sleep(3000);
      driver.findElement(By.id("password")).sendKeys("@SoniyaVijaywar1");
      driver.findElement(By.id("allow")).click();
      Thread.sleep(3000);
      String loginURL1 = driver.getCurrentUrl();
      System.out.println(loginURL1);
      Assert.assertEquals(loginURL1, "https://drpauth-test.syngenta.com/", "Expected is not same as that of actual URL");
      Thread.sleep(3000);
      driver.get("https://drpauth-test.syngenta.com/user/logout");
      driver.close();
	  driver.switchTo().window(mainWindow);
      driver.close();
     
	}
	}
