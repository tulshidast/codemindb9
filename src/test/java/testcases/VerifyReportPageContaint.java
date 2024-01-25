package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ReportPage;

public class VerifyReportPageContaint extends BaseTest {

	HomePage homePage;
	ReportPage reportPage;

	@Test(description = "VerifyReportPageContaint", groups = { "smoke" })
	public void verifyReportPageContaint() {
		homePage = new HomePage(driver);
		reportPage = new ReportPage(driver);
		homePage.clickOnMenuOption("Report Abuse");
		homePage.switchToWindow("Report potential Blogger policy violation");
		assertEquals(reportPage.getPageTitle(), "Report potential Blogger policy violation", "Title not mached");

	}
}
