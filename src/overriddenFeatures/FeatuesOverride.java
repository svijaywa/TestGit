package overriddenFeatures;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;

public class FeatuesOverride {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 
		// Open chrome
		driver.get("https://Syngenta:Syngenta1@synqa.test-syngentacp.acsitefactory.com/");
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/ul/li[3]/a")).click();
		WebElement ele = driver.findElement(By.id("edit-name"));
		ele.clear();
		ele.sendKeys("soniya.vijaywargi@syngenta.com");
		WebElement ele1 = driver.findElement(By.id("edit-pass"));
		ele1.clear();
		ele1.sendKeys("DanceSoniya@1234");
		WebElement wb = driver.findElement(By.id("edit-submit"));
		wb.click();
		driver.findElement(By.id("navbar-item--2")).click();
		driver.get("https://synqa.test-syngentacp.acsitefactory.com/admin/structure/features");
		driver.findElement(By.linkText("Syngenta")).click();
		List<WebElement> features = driver.findElements(By.xpath("//*[@class = 'state']//*[@style='display: inline;']"));
		

		 // print the total number of elements
		  System.out.println("Total element is "+features.size());
		  
		 
		 // Now using Iterator we will iterate all elements
		Iterator<WebElement> i1=features.iterator();
		    
		 
		// this will check whether list has some element or not
		while(i1.hasNext()){
		    
		 
		   // Iterate one by one
		    WebElement eleweb=i1.next();
		    
		 
		    // get the text
		    String name = eleweb.getText();
		    String t2 = eleweb.getAttribute("href");
		 
		   // print the text
		    System.out.println("Elements name is "+name+ "is" +t2);
		     
		    }
	}
}