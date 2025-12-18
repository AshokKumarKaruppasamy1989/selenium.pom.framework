package com.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utils.ConfigReader;

// Driver Lifecycle Only

public class BaseTest {
	
	/*
	 * If driver is protected:
		✔ Child test classes can directly use it
		✔ No getter needed
		✔ Clean test code
	 */

	protected WebDriver driver;
	protected Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = ConfigReader.loadProperties();
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid browser in config file");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

/*Protected is used in BaseTest so that WebDriver and configuration properties are accessible to test classes through inheritance, while still maintaining encapsulation and preventing global access.
BaseTest → framework core
LoginTest, HomeTest, etc. → subclasses

Driver must be:
✔ Shared with tests
✔ Not exposed globally
*/