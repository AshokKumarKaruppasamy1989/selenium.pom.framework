package com.utils;

// Screenshot Utility

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String testName) {
		long time = System.currentTimeMillis();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + time + ".png";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path; // We return the screenshot path so it can be consumed by listeners and reporting tools to attach screenshots to test execution reports
	}
}

/*
 * 
Test fails
↓
Listener captures screenshot
↓
Screenshot path returned
↓
Path attached to report (Extent / Allure)

*/
