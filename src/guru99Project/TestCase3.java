package guru99Project;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestCase3 {

	private WebDriver driver;
	  private String baseUrl;
	  String errMsg = "Some of the products cannot be ordered in requested quantity.";
	  
	@BeforeTest
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "http://live.guru99.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testTestCase2() throws Exception {
		
		// 1. Go to http://live.guru99.com
	    driver.get(baseUrl); 
	    
	    // 2. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();	
	  
	    // 4. Listing all Mobiles 	   
	    List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li"));
	    
	    System.out.println("Total mobiles listed are "+links.size());	
		//used for loop to 
		for(int i=1; i<links.size(); i++) {
			
			String str = driver.findElement(By.xpath("//body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["+i+"]/div/h2/a[1]")).getText();
			System.out.println(str);
			if(str.equalsIgnoreCase("Sony Xperia")) {
				
              driver.findElement(By.xpath("//body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li["+i+"]/div[1]/div[3]/button[1]")).click();
              System.out.println("Passed");
			}
			break;
						
		}
		
		driver.findElement(By.xpath("//*[@class=\"input-text qty\"]")).clear();
		driver.findElement(By.xpath("//*[@class=\"input-text qty\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//span[text()=\"Update\"]")).click();
		String actMsg = driver.findElement(By.xpath("//li/span")).getText();
		
		Assert.assertEquals(errMsg, actMsg);
		
		
		
//		if(errMsg.equals(actMsg)) {
//	        System.out.println("Test Case Passed");
//	    }else{
//	        System.out.println("Test Case Failed");
//	    };
//		
		
	    
//	    // 5. Read the XPeria mobile price from details page
//	    String detailPrice = driver.findElement(By.cssSelector("span.price")).getText();
//	    	    
//	    //  Product price in list and details page should be equal ($100)
//	    try {
//	        assertEquals(XPeriaPrice, detailPrice); 
//	      } catch (Exception e) {
//	    	  e.printStackTrace();
//	      }
//	  }
//	
//	@AfterTest
//	public void tearDown() throws Exception {
//		driver.quit();
//	  }
	  }
}
