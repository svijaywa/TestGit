package excelData;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import library.Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ErrorHandlingUK {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		// Open chrome
		driver.get("https://www.syngenta.co.uk/user");
		WebElement ele = driver.findElement(By.id("edit-name"));
		ele.clear();
		ele.sendKeys("soniya.vijaywargi@syngenta.com");
		WebElement wb = driver.findElement(By.id("edit-submit"));
		wb.click();
		Utility.captureScreenshot(driver, "UKlogin");
		 Thread.sleep(3000);
		 WebElement ele1 = driver.findElement(By.linkText("Forgot your password?"));
		 ele1.click();
		 Thread.sleep(3000);
		 WebElement ele2 = driver.findElement(By.id("edit-name"));
		 ele2.clear();
		 ele2.sendKeys("soniya.vijaywargi@syngenta.com");
		 driver.findElement(By.id("edit-submit")).click();
		 Utility.captureScreenshot(driver, "ForgetPasswordUK");
		 driver.close();
	}

}
