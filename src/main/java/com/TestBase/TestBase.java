package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.TestUtil.TestUtil;

public class TestBase {
		
	public static Properties prop; //global and static variable for Properties
	public static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	
	public TestBase() { //creating constructor. Will communicate with properties file.
		prop= new Properties();
		
	try {
		FileInputStream fle=new FileInputStream("\\C:\\Users\\Jeff\\eclipse-workspace\\dell.qa\\src\\main\\java\\com\\Config\\config.properties");
		prop.load(fle);
	} catch (FileNotFoundException e) {e.printStackTrace();} 
	catch (IOException e) {e.printStackTrace();}
	
	}
	
	public static void initil() {
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "\\C:\\abc\\j\\selenium\\chromedriver.exe\\");
	        driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "\\C:\\abc\\j\\selenium\\geckodriver.exe\\");
	        driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADOUTTIME, TimeUnit.SECONDS); //pageloadouttime coming from util class
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITYWAIT, TimeUnit.SECONDS); //implicitywait coming from util class 
		driver.get(prop.getProperty("url")); //getting URL from config. 100% Abstraction

		
	}
	@BeforeTest
	public void log() {
		
		String log4jConfPath = System.getProperty("user.dir")+"\\src\\main\\java\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	
}
}
