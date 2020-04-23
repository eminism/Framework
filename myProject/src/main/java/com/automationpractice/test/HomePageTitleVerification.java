package com.automationpractice.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automationpractice.com.page.LandingPage;
import driverFactory.BrowserFactory;

public class HomePageTitleVerification extends BrowserFactory {
	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());

	@BeforeTest
	public void initialize() throws Exception {
		driver = getDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url1"));
		log.info("Navigated to Sign In page");
	}

	@Test
	public void homePageContent() throws Exception {

		System.out.println(driver.getTitle());

		LandingPage lp = new LandingPage(driver);
		lp.getPageContentText().getText();
		Assert.assertEquals(lp.getPageContentText().getText(), "AUTHENTICATION");
		log.info("Text verified successfully");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
