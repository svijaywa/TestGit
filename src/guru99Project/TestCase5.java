package guru99Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase5 {
	
	private WebDriver driver;
	  private String baseUrl;
	  String errMsg = "Some of the products cannot be ordered in requested quantity.";
	  String regMsg = "Thank you for registering with Main Website Store.";
	  String ExpWishlist = "Your Wishlist has been shared.";
	  String eleExp = "LG LCD has been added to your wishlist. Click here to continue shopping.";
	  String ele1Exp = "Samsung LCD has been added to your wishlist. Click here to continue shopping.";
	  
	@BeforeTest
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "http://live.guru99.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testTestCase5() throws Exception {
		
		// 1. Go to http://live.guru99.com
	    driver.get(baseUrl); 
	    
	    //Register
	    driver.findElement(By.xpath("//span[@class=\"label\"][text()=\"Account\"]")).click();
	    driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.xpath("//span[text()=\"Create an Account\"]")).click();
	    
	    //Filling the form
	    driver.findElement(By.id("firstname")).sendKeys("Soniya");
	    driver.findElement(By.id("middlename")).sendKeys("Kumari");
	    driver.findElement(By.id("lastname")).sendKeys("Vijaywargi");
	    driver.findElement(By.id("email_address")).sendKeys("soniya.vijaywargi64+111@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("Admin@1234");
	    driver.findElement(By.id("confirmation")).sendKeys("Admin@1234");
	    driver.findElement(By.xpath("//span[text()=\"Register\"]")).click();
	    
	    String regActualMsg = driver.findElement(By.xpath("//span[text()=\"Thank you for registering with Main Website Store.\"]")).getText();
	    Assert.assertEquals(regActualMsg, regMsg);
	    
	    //Click on Tv Menu
	    driver.findElement(By.linkText("TV")).click();
	    
	    //Adding two products in the Wishlist
	    driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
	    String ele = driver.findElement(By.xpath("//span[text()=\"LG LCD has been added to your wishlist. Click \"]")).getText();
	    System.out.println(ele);
	    Assert.assertEquals(ele, eleExp, "Fail");
	    driver.findElement(By.xpath("//p[@class=\"back-link\"]")).click();
	    driver.findElement(By.linkText("TV")).click(); 
	    driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/div/div[3]/ul/li[1]/a")).click();
	    String ele1 = driver.findElement(By.xpath("//span[text()=\"Samsung LCD has been added to your wishlist. Click \"]")).getText();
	    Assert.assertEquals(ele1, ele1Exp, "Fail");
	    
	    driver.findElement(By.xpath("//span[text()=\"Share Wishlist\"]")).click();
	    
	    
	    //Share Wishlist 
	    driver.findElement(By.id("email_address")).sendKeys("debarghyo.sengupta@gmail.com");
	    driver.findElement(By.id("message")).sendKeys("Golu, Did you like these phones, If yes then please order for me");
	    driver.findElement(By.xpath("//span[text()=\"Share Wishlist\"]")).click();
	    String actualWishlist = driver.findElement(By.xpath("//span[text()=\"Your Wishlist has been shared.\"]")).getText();
	    Assert.assertEquals(actualWishlist, ExpWishlist, "Fails the assetion");
	   
	  }
	  
	  @AfterTest
		public void tearDown() throws Exception {
			driver.quit();
	  }


}
