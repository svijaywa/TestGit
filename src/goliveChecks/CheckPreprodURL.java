package goliveChecks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckPreprodURL {
	
    @Test
	public void test() throws InterruptedException
	{
    System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://Syngenta:Syngenta1@synqa.test-syngentacp.acsitefactory.com/user");
    WebElement ele = driver.findElement(By.id("edit-name"));
    ele.clear();
    ele.sendKeys("soniya.vijaywargi@syngenta.com");
    WebElement ele1 = driver.findElement(By.id("edit-pass"));
    ele1.clear();
    ele1.sendKeys("10Soniya#2018!1");
    WebElement wb = driver.findElement(By.id("edit-submit"));
    wb.click();
    driver.get("https://synqa.test-syngentacp.acsitefactory.com/admin/config/search/xmlsitemap/rebuild");
    driver.findElement(By.id("edit-submit")).click();
    WebDriverWait wait = new WebDriverWait(driver,70);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add new XML sitemap")));
    String mainWindow = driver.getWindowHandle();
    Actions act = new Actions(driver);
    List<WebElement> allEle=driver.findElements(By.xpath("//table[contains(@class, 'sticky-enabled table-select-processed tableheader-processed sticky-table')]/tbody/tr/td/a"));
	
	 for (int i = 0; i < allEle.size(); i++)
	 {
	 act.keyDown(Keys.CONTROL).click(driver.findElement((By.xpath("(//table[contains(@class, 'sticky-enabled table-select-processed tableheader-processed sticky-table')]/tbody/tr/td/a)["+(i+1)+"]")))).keyUp(Keys.CONTROL).build().perform();
	 Set<String>lts= driver.getWindowHandles();
	 System.out.println(lts.size());
	 final Iterator<String> it = lts.iterator();
	   while (it.hasNext()) 
	   {
		      final String child_window = it.next();
		      if (!mainWindow.equals(child_window)) 
		      {
		    	driver.switchTo().window(child_window);
		    	List<WebElement> allEles=driver.findElements(By.xpath("//table[contains(@class, 'tablesorter sitemap')]/tbody/tr/td/a"));
				for(WebElement element:allEles)
				{	
					Actions act1 = new Actions(driver);
				    act1.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
				    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				    driver.switchTo().window(tabs.get(2));
				    Thread.sleep(3000);
					List<WebElement> links1 = driver.findElements(By.tagName("a"));
					Integer size = links1.size();
					System.out.println(size);
					for(int j=0; j<links1.size(); j++)
					{
					    if(links1.get(j).getAttribute("href").contains("crop"))
					    {
					        String value1 = links1.get(j).getAttribute("href");
					        System.out.println(value1);
					        
					    }
					}
					driver.close();
					driver.switchTo().window(tabs.get(1));
					Thread.sleep(3000);
					
					
				//	String value=element.getText();
				//	System.out.println(value);
				}
		    	driver.close();
		 }
		    	driver.switchTo().window(mainWindow);

}

}
	 driver.quit();
	}
}
