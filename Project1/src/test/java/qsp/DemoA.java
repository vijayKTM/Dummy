package qsp;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoA {
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    
    //helps to generate the logs in test report.
    ExtentTest test;
    
    @Parameters({ "OS", "browser" })
    @BeforeTest
    public void startReport(String OS, String browser) {
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("Browser", browser);
        
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
    
    @Test
    public void testCase1() {
        test = extent.createTest("Test Case 1", "PASSED test case");
        Assert.assertTrue(true);
    }
    
    @Test
    public void testCase2() {
        test = extent.createTest("Test Case 2", "PASSED test case");
        Assert.assertTrue(true);
    }
    
    @Test
    public void testCase3() {
        test = extent.createTest("Test Case 3", "PASSED test case");
        Assert.assertTrue(true);
    }
     
    @Test
    public void testCase4() {
        test = extent.createTest("Test Case 4", "PASSED test case");
        Assert.assertTrue(true);
    }
     
    @Test
    public void testCase5() {
        test = extent.createTest("Test Case 5", "SKIPPED test case");
        throw new SkipException("Skipping this test with exception");
    }
}
