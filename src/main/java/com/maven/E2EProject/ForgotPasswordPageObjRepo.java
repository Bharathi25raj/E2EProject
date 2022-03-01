package com.maven.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObjRepo {
	
	WebDriver driver;
	
	public ForgotPasswordPageObjRepo(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailId = By.id("user_email");
	By sendMeInstruction = By.cssSelector("[type='submit']");
	
	public WebElement getEmailId() {
		return driver.findElement(emailId);
	}
	
	public WebElement sendMeInstruction() {
		return driver.findElement(sendMeInstruction);
	}

}
