package com.maven.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPageObjRepo {
	
	WebDriver driver;
	
	public LogInPageObjRepo(WebDriver driver) {
		this.driver=driver;
	}
	
	private By emailId = By.id("user_email");
	private By password = By.cssSelector("input[id='user_password']");
	private By logIn = By.cssSelector("input[value='Log In']");
	private By forgotPassword = By.cssSelector("[href*='password/new']");
	private By invalidPWD = By.xpath("//div[@class='alert alert-danger alert-show mb-5']");
	
	
	public WebElement getEmailId() {
		return driver.findElement(emailId);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogIn() {
		return driver.findElement(logIn);
	}
	
	public WebElement getInvalidPWD() {
		return driver.findElement(invalidPWD);
	}
	
	public ForgotPasswordPageObjRepo getForgotPasswordPage() {
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPageObjRepo(driver);
	}

}
