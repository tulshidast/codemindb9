package testcases;

/**
 * 
 * This is as test case related class.
 * 
 */
import org.openqa.selenium.WebDriver;
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
	public void tearDown() {
		driver.quit();
	}

}
