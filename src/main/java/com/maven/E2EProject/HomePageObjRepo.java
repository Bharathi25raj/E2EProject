package com.maven.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjRepo {
	
	WebDriver driver;
	
	public HomePageObjRepo(WebDriver driver) {
		this.driver = driver;
	}
	
	private By logIn = By.cssSelector("a[href*=sign_in]");
	private By title = By.cssSelector("section[id='content'] div[class='text-center'] h2");
	private By navBar = By.xpath("//nav[@class='navbar-collapse collapse']");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	
	public LogInPageObjRepo getLogIn() {		
		driver.findElement(logIn).click();
		return new LogInPageObjRepo(driver);
		
	}
	
	public WebElement getTitle() {		
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {		
		return driver.findElement(navBar);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
