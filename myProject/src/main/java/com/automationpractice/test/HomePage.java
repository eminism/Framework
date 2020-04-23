package com.automationpractice.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.com.page.LandingPage;
import com.automationpractice.com.page.LoginPage;

import driverFactory.BrowserFactory;

public class HomePage extends BrowserFactory {
	
	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());

	@BeforeTest
	public void initialize() throws Exception {
		driver = getDriver();
		driver.get(prop.getProperty("url"));// this line calls browsers from getDriver class
		log.info("Navigated to home page");
	}

	@Test(dataProvider = "getData")

	public void homePage(String email, String password) throws Exception {
		System.out.println(driver.getTitle());
		LandingPage lp = new LandingPage(driver);
		lp.login().click();

		LoginPage lp1 = new LoginPage(driver);
		lp1.email().sendKeys(email);
		lp1.password().sendKeys(password);
		lp1.signInButton().click();
		
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

	@DataProvider

	public Object[][] getData() {

		// Row stands for how many different DATA TYPE test should run
		// Colums stands for how many different VALUES per each test
		Object[][] data = new Object[2][2];
		data[0][0] = "eminism2@gmail.com"; // 0th row
		data[0][1] = "123456";

		data[1][0] = "eminismikhan@gmail.com"; // 1st row
		data[1][1] = "123456789";
		return data;
	}

}
