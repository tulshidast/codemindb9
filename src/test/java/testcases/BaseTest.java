package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/**
 * 
 * This is as test case related class.
 * 
 */
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utility.Util;

public class BaseTest {

	WebDriver driver;
	Util util;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		util = new Util();
		driver = util.launchApplication();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult res) {
		if (res.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("src/test/resources/screenshots/" + res.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
