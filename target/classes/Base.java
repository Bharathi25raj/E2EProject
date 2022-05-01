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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\maven\\resources\\data.properties");

		prop.load(fis);

		// String browser = System.getProperty("browser");

		String browser = prop.getProperty("browser");

		System.out.println(browser);

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\maven\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browser.contains("headless"))
				options.addArguments("--headless");
			driver = new ChromeDriver(options);
		} else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\maven\\resources\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			if (browser.contains("headless"))
				options.addArguments("--headless");
			driver = new FirefoxDriver(options);
		} else if (browser.contains("msedge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\maven\\resources\\msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			if (browser.contains("headless"))
				options.addArguments("--headless");
			driver = new EdgeDriver(options);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;

	}

	public String getScreenShotOnFailure(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "\\reports\\" + testMethodName + ".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}

}
