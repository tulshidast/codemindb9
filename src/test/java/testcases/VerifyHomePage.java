package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;

public class VerifyHomePage extends BaseTest {

	HomePage homePage;

	@Test(description = "Verify demo alert msg and text area 2 will be displayed with predefined text", groups = {
			"smoke" })
	public void verifyHomePage() {
		homePage = new HomePage(driver);
		assertEquals(homePage.getDemoAlertText(), "Hello");
		assertEquals(homePage.getPrepopulatedTextFromTextBox2(), "The cat was playing in the garden.");
	}

}
