package whoisCheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataConfig;

public class SiteCheckWhois {

	
	@Test(dataProvider="analysis")
	public void siteCheck(String countryname) throws InterruptedException, FileNotFoundException {
		
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://whois.net/");
        WebElement e1 = driver.findElement(By.id("domain_search"));
        e1.sendKeys(countryname);
        e1.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement text1 = driver.findElement(By.xpath("//div[@id='domain_result']"));
        String s1 = text1.getText();
        System.out.println(s1);
        WebElement text = driver.findElement(By.xpath("//div[@id='whois_result_data']"));
        String actualText = text.getText();
        System.out.println(actualText);
        Thread.sleep(4000);
       
		
	}
	
	@DataProvider(name="analysis")
	public Object[][] datapass()
	{
			ExcelDataConfig config = new ExcelDataConfig("C:/SeleniumSetup/Project/SyngentaProject/TestData/whoissite.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][1];
			
			for(int i=0;i<rows;i++){
				
				data[i][0]=config.getData(0, i, 0);
			}
			return data;
	}

}
