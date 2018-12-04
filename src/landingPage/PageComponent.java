package landingPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PageComponent {

	public static void main(String[] args) {
			
			//Login to Application as Admin
			System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			driver.get("https://Syngenta:Syngenta1@syngentamodel.syngentacp.acsitefactory.com/");
			driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/ul/li[7]/a")).click();
			WebElement ele = driver.findElement(By.id("edit-name"));
			ele.clear();
			ele.sendKeys("soniya.vijaywargi@syngenta.com");
			WebElement ele1 = driver.findElement(By.id("edit-pass"));
			ele1.clear();
			ele1.sendKeys("SoniyaDance@123");
			WebElement wb = driver.findElement(By.id("edit-submit"));
			wb.click();
			
			//Creating Landing Page
			driver.findElement(By.id("navbar-item--2")).click();
			driver.get("https://syngentamodel.syngentacp.acsitefactory.com/node/add/landing-page");
			driver.findElement(By.id("edit-title")).sendKeys("Component LandingPage");
			driver.findElement(By.id("edit-submit")).click();
			
			//Adding 1st Component in Page
			driver.findElement(By.linkText("Customize this page")).click();
			driver.findElement(By.linkText("Add new pane")).click();
			driver.findElement(By.linkText("Syngenta: CTA")).click();
			driver.findElement(By.linkText("CTA: Teaser")).click();
			driver.findElement(By.id("edit-title")).sendKeys("CTA Teaser");
			driver.findElement(By.id("edit-field-cta-text-und-0-value")).sendKeys("This is to add CTA Teaser component");
			driver.findElement(By.id("edit-field-cta-image-und-0-browse-button")).click();
			driver.switchTo().frame("mediaBrowser");
			driver.findElement(By.xpath("//*[contains(@id,'ui-id-2')]")).click();
			WebElement e1 = driver.findElement(By.id("media-item-2656"));
			Actions action = new Actions(driver).doubleClick(e1);
			action.build().perform();
			driver.findElement(By.id("edit-field-cta-link-und-0-title")).sendKeys("Google");
			driver.findElement(By.id("edit-field-cta-link-und-0-url")).sendKeys("https://www.google.com");
			driver.findElement(By.id("edit-return")).click();
			
			//Adding 2nd component in Page
			driver.manage().window().maximize();
			WebElement element = driver.findElement(By.id("ctools-dropdown-12"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", element);
			//driver.findElement(By.id("ctools-dropdown-12")).click();
			driver.findElement(By.linkText("Add content")).click();
			driver.findElement(By.linkText("Syngenta: CTA")).click();
			driver.findElement(By.linkText("CTA: Full width")).click();
			driver.findElement(By.id("edit-title")).sendKeys("CTA Full width");
			driver.findElement(By.id("edit-field-cta-image-und-0-browse-button")).click();
			driver.switchTo().frame("mediaBrowser");
			driver.findElement(By.xpath("//*[contains(@id,'ui-id-2')]")).click();
			WebElement e2 = driver.findElement(By.id("media-item-2651"));
			Actions action1 = new Actions(driver).doubleClick(e2);
			action1.build().perform();
			driver.findElement(By.id("edit-field-cta-text-und-0-value")).sendKeys("This is to add CTA Full width component");
			driver.findElement(By.id("edit-field-cta-link-und-0-title")).sendKeys("Products/Flowers");
			driver.findElement(By.id("edit-field-cta-link-und-0-url")).sendKeys("https://www.youtube.com");
			driver.findElement(By.id("edit-return")).click();
			
			

		

	}

}
