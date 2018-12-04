package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegionsExist {
	
	@Test
	public void RegionAvailable() throws InterruptedException
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
	driver.get("https://preprod.syngentadrptest.com/admin/structure/pages/edit/site_template");
	driver.findElement(By.xpath("//div[contains(@class, 'page-manager-group-title') and text()='Blogs']")).click();
	//Thread.sleep(5);
	driver.findElement(By.xpath("//a[contains(@class, 'page-manager-operation') and text()='Content']")).click();
	if(driver.findElement(By.id("panel-region-header_top")).isDisplayed() )
	{
		System.out.println("Header Top is displayed");
	}
	else{
		System.out.println("Header Top does not exist");
	}
	if(driver.findElement(By.id("panel-region-sidebar_right")).isDisplayed() )
	{
		System.out.println("Right Sidebar is displayed");
	}
	else{
		System.out.println("Right Sidebar does not exist");
	}
	driver.close();
	}
}
