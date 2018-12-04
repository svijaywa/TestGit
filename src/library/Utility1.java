package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility1 {

		public static String getScreenshot(WebDriver driver, String screenshotName)
		{
			
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path = "./Screenshots/"+screenshotName+".png";
			File dest = new File(path);
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
			return path;
			
		}

}
