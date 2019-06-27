package weatherWidget;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckingWeatherComponent {
	
	@Test
    public void AddingWeatherComponent() throws InterruptedException { 

	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	 
	// Initialize browser
	WebDriver driver=new ChromeDriver();
	 
	// Open site
	driver.get("https://Syngenta:Syngenta1@synqa.test-syngentacp.acsitefactory.com");
	 
	// Maximize browser
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//Log in to site
	driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/ul/li[7]/a")).click();
	WebElement ele = driver.findElement(By.id("edit-name"));
	ele.clear();
	ele.sendKeys("soniya.vijaywargi@syngenta.com");
	WebElement ele1 = driver.findElement(By.id("edit-pass"));
	ele1.clear();
	ele1.sendKeys("10Soniya#2018!");
	WebElement wb = driver.findElement(By.id("edit-submit"));
	wb.click();
	
	//Creating Landing Page
			driver.findElement(By.id("navbar-item--2")).click();
			driver.get("https://synqa.test-syngentacp.acsitefactory.com/node/add/landing-page");	
			driver.findElement(By.id("edit-title")).sendKeys("Weather LandingPage");
			driver.findElement(By.id("edit-published")).click();
				
	// Adding Search Box, Graph, Multiple widget and Combined Weather Component	in a landing page
			Thread.sleep(3000);
			driver.findElement(By.linkText("CUSTOMIZE DISPLAY")).click();
			driver.findElement(By.linkText("content")).click();
			driver.findElement(By.id("ctools-dropdown-6")).click();
			driver.findElement(By.linkText("Add content")).click();
			driver.findElement(By.linkText("Syngenta: Weather")).click();
			driver.findElement(By.linkText("Weather Search Box")).click();
			driver.findElement(By.id("edit-show-graph-button")).click();	
			driver.findElement(By.id("edit-return")).click();
			WebElement el = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
			el.click();
			Thread.sleep(3000);
			driver.findElement(By.id("ctools-dropdown-7")).click();
			driver.findElement(By.linkText("Add content")).click();
			driver.findElement(By.linkText("Syngenta: Weather")).click();
			driver.findElement(By.linkText("Weather Chart Widget")).click();
			WebElement e2 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
			e2.click();
			Thread.sleep(3000);
			driver.findElement(By.id("ctools-dropdown-8")).click();
			driver.findElement(By.linkText("Add content")).click();
			driver.findElement(By.linkText("Syngenta: Weather")).click();
			driver.findElement(By.linkText("Multiple days weather widget")).click();
			WebElement e3 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
			e3.click();
			Thread.sleep(3000);
			driver.findElement(By.id("ctools-dropdown-9")).click();
			driver.findElement(By.linkText("Add content")).click();
			driver.findElement(By.linkText("Syngenta: Weather")).click();
			driver.findElement(By.linkText("Hourly/Eight widget with Spray window")).click();
			WebElement e4 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
			e4.click();
			Thread.sleep(3000);
			driver.findElement(By.id("ctools-dropdown-10")).click();
			driver.findElement(By.linkText("Add content")).click();
			driver.findElement(By.linkText("Syngenta: Weather")).click();
			driver.findElement(By.linkText("Color and Restriction Legend Weather Widget")).click();
			WebElement e5 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
			e5.click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Display settings")).click();
			driver.findElement(By.xpath("//li[@class = \"2 last\"]/span/ul/li[@class=\"1\"]/a[text() = \"Change\"]")).click();
			driver.findElement(By.id("edit-method-0")).click();
			driver.findElement(By.id("edit-submit")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Edit draft")).click();
			driver.findElement(By.id("edit-published")).click();
			
			//Validating the response
			
			Thread.sleep(3000);
			driver.findElement(By.id("edit-search-location")).sendKeys("Delhi India" +"\n");
			
		 
			
			
			
	
	}
}
