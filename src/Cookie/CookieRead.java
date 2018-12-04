package Cookie;

import java.io.BufferedWriter;		
import java.io.File;		
import java.io.FileWriter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;		

		public class CookieRead{	
		    

		    public static void main(String[] args) throws InterruptedException		
		    {
		    	WebDriver driver;	
		        System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");					
				driver=new ChromeDriver();        
				driver.get("https://modelsiteadmin.syngentacp.acsitefactory.com/user");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		       				
		        // Input Email id and Password If you are already Register		
		        driver.findElement(By.id("edit-name")).sendKeys("soniya.vijaywargi@syngenta.com");							
		        driver.findElement(By.id("edit-pass")).sendKeys("SoniyaDance@123");							
		        driver.findElement(By.id("edit-submit")).click();
		     	
				Set<Cookie> totalCookies = driver.manage().getCookies();
				
				System.out.println("Total Number Of cookies : " +totalCookies.size());
				
				for (Cookie currentCookie : totalCookies) 
				{
					System.out.println(String.format("%s ---> %s ---> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : "+currentCookie.getValue()));
				}
				
				driver.quit();
		        
		        		
		        		    }		
		}
		


