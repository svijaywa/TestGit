package goliveChecks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PreGoLiveChecks {
	
	

	@Test
	public void Analytics() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://Syngenta:Syngenta1@preprod.syngentadrptest.com/user");
	WebElement ele = driver.findElement(By.id("edit-name"));
	ele.clear();
	ele.sendKeys("soniya.vijaywargi@syngenta.com");
	WebElement ele1 = driver.findElement(By.id("edit-pass"));
	ele1.clear();
	ele1.sendKeys("10Soniya#2018!");
	WebElement wb = driver.findElement(By.id("edit-submit"));
	wb.click();
	driver.get("https://preprod.syngentadrptest.com");
	String url = driver.getCurrentUrl();
	String newurl = url+"/admin/config/system/googleanalytics";
	driver.get(newurl);
	String s1 = driver.findElement(By.id("edit-googleanalytics-account")).getAttribute("value");
	System.out.println(s1);
	String newurl1 = url+"/admin/config/system/site-information";
	driver.get(newurl1);
	String s2 = driver.findElement(By.id("edit-site-name")).getAttribute("value");
	System.out.println(s2);
	String s3 = driver.findElement(By.id("edit-site-slogan")).getAttribute("value");
	System.out.println(s3);
	String s4 = driver.findElement(By.id("edit-site-mail")).getAttribute("value");
	System.out.println(s4);
	String newurl2 = url+"/admin/config/syngenta/geography-indicator";
	driver.get(newurl2);
	String s5 = driver.findElement(By.id("edit-syn-country-core-geography-indicator")).getAttribute("value");
	System.out.println(s5);
	driver.close();
	}
	
}
