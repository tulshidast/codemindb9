package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	WebDriver driver;
	WebElement clickToGetAlertButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getDemoAlertText() {
		WebElement elm = getElement("//input[@id='alert1']");
		click(elm);
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		alert.dismiss();
		return alertText;
	}

	public String getPrepopulatedTextFromTextBox2() {
		return getTextOfWebElement("//textarea[@cols='30']");

	}

	public boolean getButton1Status() {
		return isElementEnable("//button[@id='but1']");
	}

	public boolean getButton2Status() {
		return isElementEnable("//button[@id='but2']");
	}

	public List<String> getTableHeaders() {
		List<WebElement> tableHeadersWebElements = getElements("//table[@id='table1']/thead/tr//th");
		List<String> tableHeaders = new ArrayList<String>();
		for (WebElement header : tableHeadersWebElements) {
			tableHeaders.add(header.getText());
		}
		return tableHeaders;
	}

	public List<String> getTableData() {
		List<WebElement> tableDataWebElements = getElements("//table[@id='table1']/tbody//tr//td");
		List<String> tableData = new ArrayList<String>();
		for (WebElement cell : tableDataWebElements) {
			tableData.add(cell.getText());
		}
		return tableData;
	}

	public void clickOnMenuOption(String option) {
		WebElement outFrame = getElement("//iframe[@id='navbar-iframe']");
		switchToFrame(outFrame);
		click(getElement("//a[@id='b-more']"));
		switchBackFromFrame();

		WebElement innerFrame = getElement("//iframe[@id='more-iframe']");
		switchToFrame(innerFrame);
		click(getElement("//div[@id='container']/ul//li//a[text()='" + option + "']"));

	}

}
