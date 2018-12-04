package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+screenshotName+".png"));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot "+e.getMessage());
			
		}
		System.out.println("Screenshot captured");
	}
	

}