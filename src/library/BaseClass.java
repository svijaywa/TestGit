package library;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	    public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    WebDriver driver;
	    
	     
	    @BeforeSuite(alwaysRun=true)
	    public void setUp()
	    {
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/report_generated.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);     
	     
	    }
	     
	    @AfterMethod
	    public void getResult(ITestResult result) throws IOException
	    {
	        if(result.getStatus() == ITestResult.FAILURE)
	        {
	            test.fail(MarkupHelper.createLabel(result.getName()+" Test case failed", ExtentColor.RED));
	            test.fail(result.getThrowable());
	            String screenshotPath = Utility1.getScreenshot(driver, result.getName());
	            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	                
	            
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	        	test.pass(MarkupHelper.createLabel(result.getName()+" Test case passed", ExtentColor.GREEN));
	        	
	        }
	        else
	        {
	        	test.skip(MarkupHelper.createLabel(result.getName()+" Test case skipped", ExtentColor.YELLOW));
	            test.skip(result.getThrowable());
	        }
	    }
	     
	    @AfterSuite(alwaysRun=true)
	    public void tearDown()
	    {
	        extent.flush();
	    }
	
	

}
