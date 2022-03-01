package com.maven.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.maven.resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void browserInitializer() throws IOException {
		driver = initializeDriver();		
	}
	
	@Test(dataProvider="getData")
	public void loadURL(String userName, String password) throws IOException {
		
		log.info("Brower has been invoked successfully");
		driver.get(prop.getProperty("url"));
		log.info("URL has been loaded");
		
		HomePageObjRepo hp = new HomePageObjRepo(driver);
		
		LogInPageObjRepo lp = hp.getLogIn();
		lp.getEmailId().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.getLogIn().click();
		
		log.info("Data has been loaded successfully");
		
		ForgotPasswordPageObjRepo fp = lp.getForgotPasswordPage();
		fp.getEmailId().sendKeys("ghi@example.com");
		fp.sendMeInstruction().click();
	}
	
	
	@DataProvider
	public Object[][] getData() {
		//Row indicates the no. of tests to be run
		//Column indicates the no. of data that needs to be passed to a test
		
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@example.com";
		data[0][1] = "Selenium@123";
		
		data[1][0] = "def@example.com";
		data[1][1] = "testng@123";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
