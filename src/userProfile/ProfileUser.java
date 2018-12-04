package userProfile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfileUser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://synqa.test-syngentacp.acsitefactory.com/");
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/ul/li[7]/a")).click();
		WebElement ele = driver.findElement(By.id("edit-name"));
		ele.clear();
		ele.sendKeys("oidc_syn_das_113966");
		WebElement ele1 = driver.findElement(By.id("edit-pass"));
		ele1.clear();
		ele1.sendKeys("Syngenta@2018#!01");
		WebElement wb = driver.findElement(By.id("edit-submit"));
		wb.click();
		driver.findElement(By.id("navbar-link-admin-people")).click();
		driver.findElement(By.linkText("Add user")).click();
		WebElement ele2 = driver.findElement(By.id("edit-mail"));
		
		
		
		

	}

}