package weatherWidget;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RollOutWeatherWithoutRA {
	
	
	@Test
    public void rolloutWeatherPage() throws InterruptedException, ClientProtocolException, IOException { 

	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	 
	// Initialize browser
	WebDriver driver=new ChromeDriver();
	 
	// Open site
	driver.get("https://www.syngentaflowers.eu/user");
	 
	// Maximize browser
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//Log in to site

	WebElement ele = driver.findElement(By.id("edit-name"));
	ele.clear();
	ele.sendKeys("priyanka.singh@syngenta.com");
	WebElement ele1 = driver.findElement(By.id("edit-pass"));
	ele1.clear();
	ele1.sendKeys("Vishal@983672123");
	WebElement wb = driver.findElement(By.id("edit-submit"));
	wb.click();
	driver.get("https://www.syngentaflowers.eu/service/weather");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ul[@class=\"tabs-primary tabs primary\"]/li/a[text()=\"Customize display\"]")).click();
	driver.findElement(By.xpath("//li[@class=\"content\"]/a")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/a")).click();
	System.out.println("print");
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/div/ul/li[@class=\"0 first\"]/a")).click();
	
	//Adding Search Box (with Graph button) in Service Page
	driver.findElement(By.linkText("Syngenta: Weather")).click();
	driver.findElement(By.linkText("Weather Search Box")).click();	
	driver.findElement(By.id("edit-return")).click();
	WebElement el = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
	el.click();
	Thread.sleep(6000);
	
	
	//Adding multiple widget in Service Page
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/a")).click();
	System.out.println("print");
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/div/ul/li[@class=\"0 first\"]/a")).click();
	driver.findElement(By.linkText("Syngenta: Weather")).click();
	driver.findElement(By.linkText("Multiple days weather widget")).click();
	WebElement e2 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
	e2.click();
	Thread.sleep(6000);
	
	
	//Adding combined weather component in service page
	
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/a")).click();
	System.out.println("print");
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/div/ul/li[@class=\"0 first\"]/a")).click();
	driver.findElement(By.linkText("Syngenta: Weather")).click();
	driver.findElement(By.linkText("Hourly/Eight widget with Spray window")).click();
	WebElement e3 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
	e3.click();
	Thread.sleep(6000);
	
	//Adding color and Restriction legend
	
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/a")).click();
	System.out.println("print");
	driver.findElement(By.xpath("//div[@id=\"panel-region-main\"]/div/div/div/ul/li[@class=\"0 first\"]/a")).click();
	driver.findElement(By.linkText("Syngenta: Weather")).click();
	driver.findElement(By.linkText("Color and Restriction Legend Weather Widget")).click();
	WebElement e5 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
	e5.click();
	Thread.sleep(6000);
	
//	//changing cache setting
//	driver.findElement(By.xpath("//div[@id=\"ctools-dropdown-1\"]/div/a")).click();
//	driver.findElement(By.xpath("//span[@class=\"panels-sub-menu\"]/ul/li[@class=\"1\"]/a")).click();
//	driver.findElement(By.id("edit-method-0")).click();
//	driver.findElement(By.id("edit-submit")).click();
//	
//	//Saving the page
//	
//	driver.findElement(By.xpath("//ul[@class=\"tabs primary\"]/li[2]/a")).click();
//  driver.findElement(By.id("edit-published")).click();
	
	//Saving the Configuration Page
	
	driver.findElement(By.xpath("//a[@href=\"/admin/config\"]")).click();
    driver.findElement(By.xpath("//a[@href=\"/admin/config/syngenta/weather-config\"]")).click();
    driver.findElement(By.id("edit-submit")).click();
	
	
	
	}

}
