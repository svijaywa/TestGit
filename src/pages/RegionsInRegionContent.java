package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegionsInRegionContent {

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
	driver.get("https://preprod.syngentadrptest.com/node/add/contextual-panel-region");
	List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id, 'edit-field-cpr-regions-und')]/div"));
	System.out.println(elements.size());
	//for(int i=1; i<=elements.size(); i++)
	//{
	Boolean b1= driver.findElement(By.xpath("//input[contains(@id, 'my-dashboard-banner-region')]")).isDisplayed();
	if(b1.TRUE){
	System.out.println("My-dashboard-banner Region is available");
	}
	Boolean b2= driver.findElement(By.xpath("//input[contains(@id, 'edit-field-cpr-regions-und-content-bottom-wide')]")).isDisplayed();
	if(b2.TRUE){
	System.out.println("Content Bottom Wide is available");
	}
	Boolean b3= driver.findElement(By.xpath("//input[contains(@id, 'edit-field-cpr-regions-und-sidebar-right-top')]")).isDisplayed();
	System.out.println("Right Sidebar Top is available");
	Boolean b4= driver.findElement(By.xpath("//input[contains(@id, 'edit-field-cpr-regions-und-sidebar-right')]")).isDisplayed();
	System.out.println("Right Sidebar is available");
	Boolean b5= driver.findElement(By.xpath("//input[contains(@id, 'edit-field-cpr-regions-und-sidebar-right-bottom')]")).isDisplayed();
	System.out.println("Right Sidebar Bottom is available");
	Boolean b6= driver.findElement(By.xpath("//input[contains(@id, 'edit-field-cpr-regions-und-content-top')]")).isDisplayed();
	System.out.println("Content Top is available");
	Boolean b7= driver.findElement(By.xpath("//input[contains(@id, 'edit-field-cpr-regions-und-mega-footer')]")).isDisplayed();
	System.out.println("Content Bottom is available");
	
	driver.close();
	}
}
