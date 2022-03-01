package com.maven.resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Selenium\\E2EProject\\src\\main\\java\\com\\maven\\resources\\data.properties");
		
		prop.load(fis);
		
		String browser = System.getProperty("browser");
			
		//String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDrivers\\chromedriver.exe");			
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDrivers\\geckodriver.exe");		
			driver = new FirefoxDriver();
		} else if(browser.equals("msedge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\WebDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
		
	}

	
	public String getScreenShotOnFailure(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\reports\\" + testMethodName + ".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}
	
}
