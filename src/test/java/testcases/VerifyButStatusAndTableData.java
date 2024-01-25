package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;

public class VerifyButStatusAndTableData extends BaseTest {

	HomePage homePage;

	@Test(groups = { "sanity" })
	public void verifyButStatusAndTableData() {
		homePage = new HomePage(driver);
		assertFalse(homePage.getButton1Status());
		assertTrue(homePage.getButton2Status());
		List<String> expectedTableHeaders = Arrays.asList("Name", "Age", "Place");
		assertEquals(homePage.getTableHeaders(), expectedTableHeaders, "Table headers are not matched");

		List<String> expectedTableData = Arrays.asList("Kishore", "22", "Delhi", "Manish", "25", "Pune", "Praveen",
				"29", "Bangalore", "Dheepthi", "31", "Mumbai");
		assertEquals(homePage.getTableData(), expectedTableData, "Table data not matched");

	}

}
