package importProcess;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BelgiumImport {
	
	WebDriver driver;

		
	@BeforeMethod
	public void setUp() {
			
		//chrome properties
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		
		String downloadFilePath = "C:/Soniya/SyngentaProject/DownloadFile";
		
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", downloadFilePath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		
	}
	
	
	@Test
    public void ProductSearchDESite() throws InterruptedException, IOException { 
	
		 
		// Open site
		driver.get("https://www.syngenta.nl/user");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.id("edit-name"));
		ele.clear();
		ele.sendKeys("soniya.vijaywargi@syngenta.com");
		WebElement ele1 = driver.findElement(By.id("edit-pass"));
		ele1.clear();
		ele1.sendKeys("10Soniya#2018!");
		WebElement wb = driver.findElement(By.id("edit-submit"));
		wb.click();
	
		//Copying the csv link and Downloading 
		driver.get("https://www.syngenta.nl/admin/config");
		driver.findElement(By.linkText("API Import")).click();
		driver.findElement(By.linkText("Importer url")).click();
		driver.findElement(By.xpath("//fieldset[@id=\"edit-product-cp-fieldset\"]/legend/span/a[@class=\"fieldset-title\"]")).click();
		String csvURL = driver.findElement(By.id("edit-syn-api-importer-product-cp-csv-link")).getAttribute("value");
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); 
		Thread.sleep(3000);
		driver.get(csvURL +"\n");
		
		//Uploading the csv file
		driver.switchTo().window(tabs.get(0));
		driver.get("https://www.syngenta.nl/admin/products");
		driver.findElement(By.linkText("Import")).click();
		driver.findElement(By.id("edit-csv-file")).sendKeys("C:/Soniya/SyngentaProject/DownloadFile/syngenta_product.csv");
		driver.findElement(By.xpath("//input[@id= \"edit-published\"]")).click();
		driver.findElement(By.id("edit-submit")).click();

		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"messages status\"]")));

		driver.get("https://www.syngenta.nl/admin/config/search/search_api");
		driver.findElement(By.linkText("Product CP node index")).click();
		driver.findElement(By.id("edit-clear")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("edit-reindex")).click();
		Thread.sleep(8000);
		driver.close();
		
		
}
}