package whoisCheck;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

		
		public class SiteChecking {

		//public class Extra_Example extends BaseClassOT{

		    @Test
		    public void test() throws InterruptedException{
		    	System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
		        driver.get("https://whois.net/");
		        WebElement element = driver.findElement(By.xpath("//input[@id='domain_search']"));
		        element.sendKeys("syngenta.co.uk");
		        element.sendKeys(Keys.ENTER);
		        Thread.sleep(3000);

		        WebElement text = driver.findElement(By.xpath("//div[@id='whois_result_data']"));
		        String actualText = text.getText();
		        System.out.println(actualText);
		        writeToExcel("Sheet1", actualText);
		    }

		    String fileLocation = System.getProperty("user.dir") + "/TestData/new.xlsx";
		    int row = 1;

		    public void writeToExcel(String sheetName, String text){
		        File file = new File(fileLocation);
		        try {
		            FileInputStream fileInputStream = new FileInputStream(file);

		            Workbook workbook = new XSSFWorkbook(fileInputStream);
		            Sheet sheet = workbook.getSheet(sheetName);
		            sheet.createRow(row).createCell(0).setCellValue(text);
		            row++;

		            FileOutputStream fileOutputStream = new FileOutputStream(file);
		            workbook.write(fileOutputStream);
		            fileOutputStream.close();
		        } catch (Exception ex){
		            ex.printStackTrace();
		        }
		    }
}
