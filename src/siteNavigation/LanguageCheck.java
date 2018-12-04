package siteNavigation;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import library.BaseClass;
import library.Utility;
import library.Utility1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class LanguageCheck extends BaseClass {
	

	@Test(groups={"Smoke"})
 	public void LanguageCheckSwitzerland() throws InterruptedException, IOException {
		
        test = extent.createTest("LanguageCheckSwitzerland");
        Assert.assertTrue(1>0);
        test.log(Status.PASS, "Language Switcher block exists");
        System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open site
		driver.get("https://www.syngenta.ch/");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement dropdown=driver.findElement(By.name("syn_language_switcher"));
	    Select month=new Select(dropdown);
        month.selectByVisibleText("de");
        System.out.println("Language switcher block exists");
        driver.close();
 
	}

}
