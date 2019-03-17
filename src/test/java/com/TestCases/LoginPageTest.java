package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage; //global variable
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		logger.info("opening browser");
		initil(); //launches browser, deletes cookies, etc. (gets ready)
		loginpage = new LoginPage();
		
	}
	
	@Test(priority = 2) //priority decides which order tests run
	public void VerifyLoginPage() {
		logger.info("Verifying login");
		loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
		//boolean dashboard = loginpage.VerifyHomePage();
		//Assert.assertTrue(dashboard);
		//TestUtil.captureScreenShot(driver, "Homepage"); //screenshot 
	}
	
	@Test(priority = 4)
	public void VerifyErrorMessage() {
		loginpage.ErrorMessage(prop.getProperty("invalidUser"),prop.getProperty("invalidPassword"));
		boolean er=loginpage.VerifyError();
		Assert.assertTrue(er);
	}
	
	@Test(priority = 0)
	public void VerifyLogoofThePage() {
		boolean logo = loginpage.verifyLogo();
		Assert.assertTrue(logo);
	}
	@Test(priority = 1)
	public void VerifyTitleofThePage() {
		String title=loginpage.VerifyTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
