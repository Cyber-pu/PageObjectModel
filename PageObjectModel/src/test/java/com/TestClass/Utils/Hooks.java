package com.TestClass.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks {
	
	public static Properties configData;
	public WebDriver driver;
	
	@BeforeSuite
	public void beforeSuit() throws IOException {
		dataConfig();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lunchBrowser();
	}
	
	@AfterMethod
	public void afterMethod() {
		quitBrowser();
	}
	@AfterSuite
	public void afterSuit() {
		
	}
	
	public void dataConfig() throws IOException {
		try {
			FileInputStream fis=new FileInputStream(new File("./src/test/resources/config.properties"));
			configData=new Properties();
			configData.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void lunchBrowser() {
		if(configData.getProperty("Browser.name").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.chromedriver", "./binary/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
