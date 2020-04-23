package com.automationpractice.com.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.id("email");
	By password = By.id("passwd");
	By signInButton = By.id("SubmitLogin");

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement signInButton() {
		return driver.findElement(signInButton);
	}
	
	
}
