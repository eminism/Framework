package com.automationpractice.com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signIn = By.xpath("//a[@class='login']");
	By title = By.xpath("//h1[contains(text(),'Authentication')]");
	By searchBlock = By.id("search_block_top");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement login() {
		return driver.findElement(signIn);
	}

	public WebElement getPageContentText() {
		return driver.findElement(title);

	}
	public WebElement searchBarPresented() {
		return driver.findElement(searchBlock);
	}
}
