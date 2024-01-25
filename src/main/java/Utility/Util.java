package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Util {

	public static String readProperty(String key) {

		File file = new File("src/test/resources/commondata.properties");
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public WebDriver getDriver() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		return driver;
	}

	public WebDriver launchApplication() {
		WebDriver driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get(readProperty("url"));
		return driver;
	}

}
