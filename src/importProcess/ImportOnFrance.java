package importProcess;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class ImportOnFrance {

	@Test
    public void Import() throws InterruptedException, ClientProtocolException, IOException { 

	System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	 
	// Initialize browser
	WebDriver driver=new ChromeDriver();
	 
	// Open site
	driver.get("https://www.syngenta.fr/user");
	 
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
	driver.get("https://www.syngenta.fr/admin/content");
	
	//Choosing Product Corn filter
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id=\"edit-type-wrapper\"]/div/div/div/a/span[text()=\"- Sélectionner une culture -\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Product Seed: Corn\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id=\"edit-status-wrapper\"]/div/div/div/a/span[text()=\"- Sélectionner une culture -\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Oui\"]")).click();
	driver.findElement(By.xpath("//input[@value=\"Apply\"]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//table[@class=\"views-table sticky-enabled cols-9 tableheader-processed sticky-table\"]/thead/tr/th/div/input[@class=\"vbo-table-select-all form-checkbox\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a/span[text()=\"- Choisir une opération -\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Publier\"]")).click();
    driver.findElement(By.xpath("//input[@value=\"Exécuter\"]")).click();
    
    //wait for batch process
    WebDriverWait wait = new WebDriverWait(driver, 70);
    
	// Here we will wait until element is not visible, if element is visible then it will return web element
	// or else it will throw exception
	WebElement element = wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()=\"Ajouter du contenu\"]")));

	// if element found then we will use- In this example I just called isDisplayed method
	boolean status = element.isDisplayed();

	// if else condition
	if (status) {
		System.out.println("===== Imported Product Seed: Corn ======");
	} else {
		System.out.println("=====Import Failed======");
	}
	
	
	 //Choosing Product Seed: Wheat & Barley filter
		driver.findElement(By.xpath("//div[@id=\"edit-type-wrapper\"]/div/div/div/a/span[text()=\"Product Seed: Corn\"]")).click();
		driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Product Seed: Wheat and barley\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"Apply\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@class=\"views-table sticky-enabled cols-9 tableheader-processed sticky-table\"]/thead/tr/th/div/input[@class=\"vbo-table-select-all form-checkbox\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a/span[text()=\"- Choisir une opération -\"]")).click();
		driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Publier\"]")).click();
	    driver.findElement(By.xpath("//input[@value=\"Exécuter\"]")).click();
	    
	    //wait for batch process
	    WebDriverWait wait1 = new WebDriverWait(driver, 70);
	    
		// Here we will wait until element is not visible, if element is visible then it will return web element
		// or else it will throw exception
		WebElement element1 = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()=\"Ajouter du contenu\"]")));

		// if element found then we will use- In this example I just called isDisplayed method
		boolean status1 = element1.isDisplayed();

		// if else condition
		if (status1) {
			System.out.println("=====Imported Product Seed: Wheat and barley======");
		} else {
			System.out.println("=====Import Failed======");
		}
		
		 //Choosing Product Seed: Wheat & Barley filter
		driver.findElement(By.xpath("//div[@id=\"edit-type-wrapper\"]/div/div/div/a/span[text()=\"Product Seed: Wheat and barley\"]")).click();
		driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Product Seed: Rapeseed and Sunflower\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"Apply\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@class=\"views-table sticky-enabled cols-9 tableheader-processed sticky-table\"]/thead/tr/th/div/input[@class=\"vbo-table-select-all form-checkbox\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a/span[text()=\"- Choisir une opération -\"]")).click();
		driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Publier\"]")).click();
	    driver.findElement(By.xpath("//input[@value=\"Exécuter\"]")).click();
	    
	    //wait for batch process
	    WebDriverWait wait2 = new WebDriverWait(driver, 70);
	    
		// Here we will wait until element is not visible, if element is visible then it will return web element
		// or else it will throw exception
		WebElement element2 = wait2
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()=\"Ajouter du contenu\"]")));

		// if element found then we will use- In this example I just called isDisplayed method
		boolean status2 = element2.isDisplayed();

		// if else condition
		if (status2) {
			System.out.println("===== Imported Product Seed: Rapeseed and Sunflower======");
		} else {
			System.out.println("=====Import Failed======");
		}
    
    
    //Choosing Product CP filter
	driver.findElement(By.xpath("//div[@id=\"edit-type-wrapper\"]/div/div/div/a/span[text()=\"Product Seed: Rapeseed and Sunflower\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Product CP\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@value=\"Apply\"]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//table[@class=\"views-table sticky-enabled cols-9 tableheader-processed sticky-table\"]/thead/tr/th/div/input[@class=\"vbo-table-select-all form-checkbox\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//td/span/input[@value=\"Sélectionner tous les 183 rows dans cette vue.\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a/span[text()=\"- Choisir une opération -\"]")).click();
	driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li[text() = \"Publier\"]")).click();
    driver.findElement(By.xpath("//input[@value=\"Exécuter\"]")).click();
    
    //wait for batch process
    WebDriverWait wait3 = new WebDriverWait(driver, 100);
    
	// Here we will wait until element is not visible, if element is visible then it will return web element
	// or else it will throw exception
	WebElement element3 = wait3
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()=\"Ajouter du contenu\"]")));

	// if element found then we will use- In this example I just called isDisplayed method
	boolean status3 = element3.isDisplayed();

	// if else condition
	if (status3) {
		System.out.println("===== WebDriver is visible======");
	} else {
		System.out.println("===== WebDriver is not visible======");
	}

	driver.close();
	}
}
