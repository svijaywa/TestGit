package ReadFooter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LanguageTest {
	
	Boolean dd;
	
	@Test
 	public void LanguageCheckTest() throws InterruptedException {
	
	 System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open site
		driver.get("https://www.syngenta.ch/");
		
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(5000);
		try {
		
		if(driver.findElement(By.xpath("//select[@name='syn_language_switcher']"))!=null)
		
		 {
			
			WebElement selectElement=driver.findElement(By.xpath("//select[@name='syn_language_switcher']"));
			Select select = new Select(selectElement);
		
			List<WebElement> allOptions = select.getOptions();
			System.out.println(allOptions.size());

		    
			}
		else
		{
            System.out.println("Element not displayed");
		}
		}
		catch(Exception e) {
			System.out.println("Element not there");
		}
		
		
		
	}
		
	

}
