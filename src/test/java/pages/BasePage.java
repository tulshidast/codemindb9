/**
 * 
 */
package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author admin
 */
public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String webElementXpath) {
		return driver.findElement(By.xpath(webElementXpath));
	}

	public List<WebElement> getElements(String webElementXpath) {
		return driver.findElements(By.xpath(webElementXpath));
	}

	public String getTextOfWebElement(String webElementXpath) {
		return getElement(webElementXpath).getText();
	}

	public Alert switchToAlert() {
		waitForAlert();
		return driver.switchTo().alert();
	}

	public void click(WebElement elm) {
		waitForElementToBeClickAble(elm);
		elm.click();
	}

	public void clear(WebElement elm) {
		waitForElementToBeClickAble(elm);
		elm.clear();
	}

	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementToBeClickAble(WebElement elm) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(elm));
	}

	public void waitForElementToBeEnable(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void selectOptionFromDropdown(WebElement elm, String option) {
		Select select = new Select(elm);
		select.selectByVisibleText(option);
	}

	public void selectOptionsFromDropdown(WebElement elm, String... option) {
		Select select = new Select(elm);
		for (int i = 0; i < option.length; i++) {
			select.selectByVisibleText(option[i]);
		}
	}

	public boolean isElementEnable(String xpath) {
		waitForElementToBeEnable(xpath);
		return driver.findElement(By.xpath(xpath)).isEnabled();
	}

	public boolean isElementDisplayed(WebElement elm) {
		return elm.isDisplayed();
	}

	public boolean isElementSelected(WebElement elm) {
		return elm.isSelected();
	}

	public void switchToFrame(WebElement elm) {
		driver.switchTo().frame(elm);
	}

	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	public void switchToWindow(String title) {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allwindowsHandles = driver.getWindowHandles();

		for (String handle : allwindowsHandles) {
			if (!(handle.equals(parentWindowHandle))) {
				driver.switchTo().window(handle);
			}
		}
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(100))
				.ignoring(TimeoutException.class).until(ExpectedConditions.titleContains(title));
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
