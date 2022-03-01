package com.maven.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPageObjRepo {
	
	WebDriver driver;
	
	public LogInPageObjRepo(WebDriver driver) {
		this.driver=driver;
	}
	
	By emailId = By.id("user_email");
	By password = By.cssSelector("input[id='user_password']");
	By logIn = By.cssSelector("input[value='Log In']");
	By forgotPassword = By.cssSelector("[href*='password/new']");
	
	
	public WebElement getEmailId() {
		return driver.findElement(emailId);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogIn() {
		return driver.findElement(logIn);
	}
	
	public ForgotPasswordPageObjRepo getForgotPasswordPage() {
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPageObjRepo(driver);
	}

}
