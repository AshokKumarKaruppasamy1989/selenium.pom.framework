package com.tests;

import org.testng.annotations.DataProvider;

// Test Logic Only

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtil;
import com.utils.ScreenshotUtil;
import com.utils.WaitUtil;

import org.testng.*;

public class LoginTest extends BaseTest {

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/LoginData.xlsx";
		return new Object[][] {
				{ ExcelUtil.getCellData(path, "Login", 1, 0), ExcelUtil.getCellData(path, "Login", 1, 1) } };
	}

	@Test(dataProvider = "loginData")
	public void verifyLogin(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		HomePage homePage = new HomePage(driver);
		WaitUtil.waitForElementVisible(driver, homePage.getHomePageDashboard());
		Assert.assertTrue(homePage.isHomePageDisplayed());

		ScreenshotUtil.takeScreenshot(driver, "LoggedInHomePage");
	}
}