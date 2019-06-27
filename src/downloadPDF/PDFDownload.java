package downloadPDF;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PDFDownload {
	
	WebDriver driver;
	File folder;
	
	
	@BeforeMethod
	public void setUp() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		//chrome properties
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		
		
	}
	
	@Test
    public void downloadPDFfile () throws InterruptedException {
	  driver.get("https://www.syngenta.com.au/product/crop-protection/fungicide/alto-100sl");
	  driver.findElement(By.xpath("//img[@class ='print-icon']")).click();
	  Thread.sleep(3000);
	  File listOfFiles[] = folder.listFiles();
	  //make sure the directory is not empty
	  int list = listOfFiles.length;
	  System.out.println(list);
	  Assert.assertTrue(listOfFiles.length>0);
	  
	  for(File file:listOfFiles) {
		  Assert.assertTrue(file.length()>0);
		  
		  
	  }
	  
  }
	
   @AfterMethod 
   public void tearDown() {
	   
	   driver.quit();
	   for(File file : folder.listFiles()) {
		   file.delete();
		   
	   }
	   folder.delete();
   }
}
