package eventManagement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEventContent {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://Syngenta:Syngenta1@preprod.syngentadrptest.com");
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/ul/li[7]/a")).click();
		WebElement ele = driver.findElement(By.id("edit-name"));
		ele.clear();
		ele.sendKeys("prashant.kabade@syngenta.com");
		WebElement ele1 = driver.findElement(By.id("edit-pass"));
		ele1.clear();
		ele1.sendKeys("Syngenta@2018#!01");
		WebElement wb = driver.findElement(By.id("edit-submit"));
		wb.click();
		driver.get("https://preprod.syngentadrptest.com/node/add/event");
		driver.findElement(By.id("edit-title")).sendKeys("Drupal Management System");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('edit-field-event-type-und').style.display='block';");
		new Select(driver.findElement(By.xpath("//*[@id='edit-field-event-type-und']"))).selectByIndex(1);
		//js.executeScript("document.getElementById('edit-field-event-type-und').style.display='none';");
		driver.findElement(By.id("edit-field-teaser-und-0-value")).sendKeys("Drupal is a CMS");
		//WebElement ele12 = driver.findElement(By.xpath("//*[@id='edit-field-event-dates-und-0-value2-datepicker-popup-0']"));
		WebElement e1 = driver.findElement(By.id("edit-field-event-dates-und-0-value"));
		System.out.println(e1);
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", ele12);
		
		//List<WebElement> courses = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']//td")));
        List<WebElement> courses = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']//td"));
        int total = courses.size();
        System.out.println(total);
        
        for(WebElement ele123:courses)
		{
			
			String date=ele123.getText();
			
			if(date.equalsIgnoreCase("27"))
			{
				ele123.click();
				break;
			}
			
		}
		
	   
		
		
		
		
		
		
		

	}

}
