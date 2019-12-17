package importProcess;

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

public class ImportOnBelgium {

	@Test
    public void ImportBelgium() throws InterruptedException, ClientProtocolException, IOException { 

	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	 
	// Initialize browser
	WebDriver driver=new ChromeDriver();
	 
	// Open site
	driver.get("https://www.syngenta.be/user");
	 
	// Maximize browser
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//Log in to site

	WebElement ele = driver.findElement(By.id("edit-name"));
	ele.clear();
	ele.sendKeys("priyanka.singh@syngenta.com");
	WebElement ele1 = driver.findElement(By.id("edit-pass"));
	ele1.clear();
	ele1.sendKeys("Priyanka@983672");
	WebElement wb = driver.findElement(By.id("edit-submit"));
	wb.click();
	driver.get("https://www.syngenta.be/admin/content");

	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id=\"edit-type-wrapper\"]/div/div/div/a/span[text()=\"-- alle --\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Product CP\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id=\"edit-status-wrapper\"]/div/div/div/a/span[text()=\"-- alle --\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Yes\"]")).click();
	driver.findElement(By.xpath("//input[@value=\"Apply\"]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//table[@class=\"views-table sticky-enabled cols-9 tableheader-processed sticky-table\"]/thead/tr/th/div/input[@class=\"vbo-table-select-all form-checkbox\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//td/span/input[@value=\"Select all 128 rows in this view.\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a/span[text()=\"- Choose an operation -\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Publish\"]")).click();
    driver.findElement(By.xpath("//input[@value=\"Execute\"]")).click();
    
    //wait for batch process
    WebDriverWait wait = new WebDriverWait(driver, 300);
    
	// Here we will wait until element is not visible, if element is visible then it will return web element
	// or else it will throw exception
	WebElement element = wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()=\"Add content\"]")));

	// if element found then we will use- In this example I just called isDisplayed method
	boolean status = element.isDisplayed();

	// if else condition
	if (status) {
		System.out.println("=====Belgium Product Import is successful======");
	} else {
		System.out.println("===== Import failed======");
	}
	}
}
