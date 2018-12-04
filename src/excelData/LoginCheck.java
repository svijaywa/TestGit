package excelData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginCheck {

	@Test(dataProvider="logincheck")
    public void siteHack(String countryname) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.get(countryname);
        Thread.sleep(3000);
        WebElement ele1 = driver.findElement(By.cssSelector(".pane-syn-country-core-geography-indicator"));
	    String s2 = ele1.getText();
        Thread.sleep(3000);
        WebElement ele = driver.findElement(By.xpath("//a[@class='icon-before menu__link login-link' or @class='icon-before menu__link login-link']"));
        boolean bool = ele.isDisplayed();
		System.out.println("Login exists for " +s2 +bool);
		driver.close();
		
	}
		
	@DataProvider(name="logincheck")
	public Object[][] datapass()
	{
			ExcelDataConfig config = new ExcelDataConfig("C:/SeleniumSetup/Project/SyngentaProject/TestData/sitename.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][1];
			for(int i=0;i<rows;i++){
				
				data[i][0]=config.getData(0, i, 0);
			}
			return data;
	}			

}
