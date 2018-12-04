package excelData;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SiteRunning {

		
		@Test(dataProvider="sitestatus")
		public void siteHack(String countryname) throws InterruptedException
		{
			 
			System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver.exe");
			 
			// Initialize browser
			WebDriver driver=new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
			// Open chrome
			driver.get(countryname);
			
			 try 
		        {	
		           URL url = new URL(countryname);
		           System.out.println("Current value for country : "+countryname);          
		           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		           httpURLConnect.setConnectTimeout(3000);
		           httpURLConnect.connect();
		           	
		           if(httpURLConnect.getResponseCode() == 200)
		           {
		               System.out.println(countryname+"200 - "+httpURLConnect.getResponseMessage());
		  
		            }
		          if(httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)  
		           {
		               System.out.println(countryname+"404 - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
		            }
		          if(httpURLConnect.getResponseCode() == 403)
		           {
		               System.out.println(countryname+" 403 - "+httpURLConnect.getResponseMessage());
		  
		            }
		          else{
		        	  System.out.println("Within else "+countryname+" - "+httpURLConnect.getResponseCode());
		          }
		        } 
			  catch (Exception e) {
		           
		        }
			 driver.close();
		}
		
		@DataProvider(name="sitestatus")
		public Object[][] datapass()
		{
				ExcelDataConfig config = new ExcelDataConfig("C:/SeleniumSetup/Project/SyngentaProject/TestData/saheel.xlsx");
				//int rows = config.getRowCount(0);
				int rows = 2;
				Object[][] data = new Object[rows][1];
				
				for(int i=0;i<rows;i++){
					
					data[i][0]=config.getData(0, i, 0);
				}
				return data;
		}	
	}