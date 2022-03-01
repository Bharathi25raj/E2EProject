package com.maven.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.maven.resources.Base;

public class navigationCheckInHomePage extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	WebDriver driver;
	
	@BeforeTest
	public void browserInitializer() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));		
	}
	
	@Test
	public void getNavigation() throws IOException {
				
		HomePageObjRepo hp = new HomePageObjRepo(driver);
		
		Assert.assertTrue(hp.getNavBar().isDisplayed());
		log.info("Navaigation Bar is dislayed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
