package landingPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComponentPage {

	public static void main(String[] args) throws InterruptedException {
		
		//Login to Application as Admin
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		driver.findElement(By.id("edit-published")).click();
		
		//Adding 1st Component in Page
		driver.findElement(By.linkText("CUSTOMIZE DISPLAY")).click();
		driver.findElement(By.linkText("content")).click();
		driver.findElement(By.id("ctools-dropdown-6")).click();
		driver.findElement(By.linkText("Add content")).click();
		driver.findElement(By.linkText("Syngenta: CTA")).click();
		driver.findElement(By.linkText("CTA: Teaser")).click();
		driver.findElement(By.id("edit-title")).sendKeys("CTA Teaser");
		driver.findElement(By.id("edit-field-cta-text-und-0-value")).sendKeys("This is to add CTA Teaser component");
		driver.findElement(By.id("edit-field-cta-image-und-0-browse-button")).click();
		driver.switchTo().frame("mediaBrowser");
		driver.findElement(By.xpath("//*[contains(@id,'ui-id-2')]")).click();
		WebElement e1 = driver.findElement(By.id("media-item-91466"));
		//((JavascriptExecutor) driver).executeScript("var evt = document.createEvent('MouseEvents');"+ 
			//    "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"+ 
		//	    "arguments[0].dispatchEvent(evt);", e1);
		Actions action = new Actions(driver).doubleClick(e1);
		action.build().perform();
		driver.findElement(By.id("edit-field-cta-link-und-0-title")).sendKeys("Google");
		driver.findElement(By.id("edit-field-cta-link-und-0-url")).sendKeys("https://www.google.com");
		driver.findElement(By.id("edit-return")).click();
		WebElement el = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
		el.click();
		driver.findElement(By.linkText("Edit draft")).click();
		driver.findElement(By.id("edit-published")).click();
		
		
		//Adding 2nd component in Page
		driver.findElement(By.linkText("CUSTOMIZE DISPLAY")).click();
		driver.findElement(By.linkText("content")).click();
    	WebElement element = driver.findElement(By.id("ctools-dropdown-7"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		WebElement element1 = driver.findElement(By.linkText("Add content"));
		element1.click();
		driver.findElement(By.linkText("Syngenta: CTA")).click();
		driver.findElement(By.linkText("CTA: Full width")).click();
		driver.findElement(By.id("edit-title")).sendKeys("CTA Full width");
		driver.findElement(By.id("edit-field-cta-image-und-0-browse-button")).click();
		driver.switchTo().frame("mediaBrowser");
		driver.findElement(By.xpath("//*[contains(@id,'ui-id-2')]")).click();
		WebElement e2 = driver.findElement(By.id("media-item-91471"));
		Actions action12 = new Actions(driver).doubleClick(e2);
		action12.build().perform();  
		driver.findElement(By.id("edit-field-cta-text-und-0-value")).sendKeys("This is to add CTA Full width component");
		driver.findElement(By.id("edit-field-cta-link-und-0-title")).sendKeys("Products/Flowers");
		driver.findElement(By.id("edit-field-cta-link-und-0-url")).sendKeys("https://www.youtube.com");
		driver.findElement(By.id("edit-return")).click();
		WebElement e3 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
		e3.click();
		driver.findElement(By.linkText("Edit draft")).click();
		driver.findElement(By.id("edit-published")).click();
		
		
		//Adding 3rd component in Page
		driver.findElement(By.linkText("CUSTOMIZE DISPLAY")).click();
		driver.findElement(By.linkText("content")).click();
    	WebElement ele12 = driver.findElement(By.id("ctools-dropdown-8"));
		Actions action123 = new Actions(driver);
		action123.moveToElement(ele12).click().perform();
		WebElement element12 = driver.findElement(By.linkText("Add content"));
		element12.click();
		driver.findElement(By.linkText("Syngenta: CTA")).click();
		driver.findElement(By.linkText("CTA: Text")).click();
		driver.findElement(By.id("edit-title")).sendKeys("CTA Text");
		driver.findElement(By.id("edit-field-cta-link-und-0-title")).sendKeys("Crops");
		driver.findElement(By.id("edit-field-cta-link-und-0-url")).sendKeys("https://www.syngenta.ru");
		driver.findElement(By.id("edit-return")).click();
		WebElement e45 = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("panels-dnd-save")));
		e45.click();
		driver.findElement(By.linkText("Edit draft")).click();
		driver.findElement(By.id("edit-published")).click();
		 
		//Adding 33/33/33 styles to components
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement ws = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CUSTOMIZE DISPLAY")));
		ws.click();
		//driver.findElement(By.linkText("CUSTOMIZE DISPLAY")).click();
		driver.findElement(By.linkText("content")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement w = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctools-dropdown-9")));
		Actions act12 = new Actions(driver);
		act12.moveToElement(w).click().perform();
		WebDriverWait waits = new WebDriverWait(driver, 10);
		WebElement wd = waits.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change")));
		int ok_size=driver.findElements(By.linkText("Change")).size();
		driver.findElements(By.linkText("Change")).get(ok_size-1).click();
		//WebElement elw12 = driver.findElement(By.xpath("//*[@class='change last']"));
		//elw12.click();
        WebElement radio_button = driver.findElement(By.id("edit-style-three-cols-33"));
       // boolean selected_status = radio_button.isSelected();
        radio_button.click();
        driver.findElement(By.id("edit-submit")).click();
		driver.findElement(By.linkText("Edit draft")).click();
		driver.findElement(By.id("edit-published")).click();
		

	}

}
