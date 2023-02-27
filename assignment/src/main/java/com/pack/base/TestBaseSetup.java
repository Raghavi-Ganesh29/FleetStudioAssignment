package com.pack.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestBaseSetup {

	private static WebDriver driver;
	static String driverPath = "/Users/raghavig/POMassign/";

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver");
		System.out.println(driverPath
				+ "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	
	public static void takeScreenshot(String fileName, String fileExtension) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(fileName + fileExtension));
	}
	
	public static String errorPath() throws IOException {
		String path = getCurrentDateTimeStamp("yMMddHHmmss");
		takeScreenshot(System.getProperty("user.dir") + "/er/" + path, ".png");
		System.out.println("Taking ss"+System.getProperty("user.dir"));
		return path + ".png";
	}

	public static void startTestCase() throws IOException {
		try {
			Extend.testcase();

		} catch (Exception e) {

		}
	}
	

	public static void endTestCase() throws IOException {
		try {
			Extend.end();
			System.out.println("test ends");

		} catch (Exception e) {

		}
	}
	
	
	
public static String getCurrentDateTimeStamp(String formats) {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yMMddHHmmss");
		return dateFormat.format(date);
	
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
	