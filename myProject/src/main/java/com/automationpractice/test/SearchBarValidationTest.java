package com.automationpractice.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automationpractice.com.page.LandingPage;
import driverFactory.BrowserFactory;

public class SearchBarValidationTest extends BrowserFactory {

	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());
	
	@BeforeTest
	public void initialize() throws Exception {
		driver = getDriver();
		driver.get(prop.getProperty("url1"));
		log.info("Navigated to sign in page successfully");
	}

	@Test

	public void SearchBoxValidation() throws Exception {
		System.out.println(driver.getTitle());
		LandingPage lp = new LandingPage(driver);

		Assert.assertTrue(lp.searchBarPresented().isDisplayed());
		log.info("Search Bar is verified successfully");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}