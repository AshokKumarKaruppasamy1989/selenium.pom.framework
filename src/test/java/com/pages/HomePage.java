package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	// Locators
	private By dashboard = By.xpath("//h6[normalize-space()='Dashboard']");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By getHomePageDashboard() {
		return dashboard;
	}

	public boolean isHomePageDisplayed() {
		return driver.findElement(dashboard).isDisplayed();
	}
}