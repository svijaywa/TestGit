package goliveChecks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PostGoLiveChecks {
	@Test
	public void Analytics() throws InterruptedException
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
	ele1.sendKeys("Syngenta1");
	WebElement wb = driver.findElement(By.id("edit-submit"));
	wb.click();
	driver.get("https://preprod.syngentadrptest.com/admin/config/search/xmlsitemap/rebuild");
	driver.findElement(By.id("edit-submit")).click();
	WebDriverWait wait = new WebDriverWait(driver,50);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add new XML sitemap")));
	List<WebElement> allEle=driver.findElements(By.xpath("//table[contains(@class, 'sticky-enabled table-select-processed tableheader-processed sticky-table')]/tbody/tr/td/a"));
	Integer linkSize = allEle.size();
	System.out.println(linkSize);
	
	for(WebElement eles:allEle)
	{	
		String val=eles.getText();
		System.out.println(val);
		if(val.contains("sitemap.xml"))
		{
			eles.click();
			List<WebElement> allEles=driver.findElements(By.xpath("//table[contains(@class, 'tablesorter sitemap')]/tbody/tr/td"));
			for(WebElement element:allEles)
			{	
				String value=element.getText();
				System.out.println(value);
			}
			break;
			
		}
		
	}
	
	driver.close();
	
	}
}
