package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
		//We will keep all the locators and methods in this class
		
		@FindBy(xpath="//input[@id=\"username\"]")
		WebElement Username;
		
		@FindBy(xpath="//input[@id=\"password\"]")
		WebElement Password;
		
		@FindBy(xpath="//button[@type=\"submit\"]")
		WebElement SignIn;
		
		@FindBy(xpath="//img[@class=\"logo\"]")
		WebElement Logo;
		
		@FindBy(xpath="//div[@class=\"alert alert-danger fade in\"]")
		WebElement ErrorMessage;
		
		@FindBy(xpath="//div[@class=\"col-lg-12\"]")
		WebElement dashboard;
		
		public LoginPage() { 
			PageFactory.initElements(driver, this); //two values: The Webdriver and 'this' keyword
		}
		
		//All Actions
		/*
		public void Verifylogin() { //Test Case 1 
			Username.sendKeys(prop.getProperty("UserName"));
			Password.sendKeys(prop.getProperty("Password"));
			SignIn.click();
		}*/
		
		public boolean VerifyHomePage() {
			return dashboard.isDisplayed();
		}
		
		public void VerifyLogin(String Un, String pw) {
			Username.sendKeys(Un);
			Password.sendKeys(pw);
			SignIn.click();
		}
		
		public void ErrorMessage(String Un, String pw) {
			Username.sendKeys(Un);
			Password.sendKeys(pw);
			SignIn.click();	
		}
		
		public boolean VerifyError() {
		return ErrorMessage.isDisplayed();
		}
		
		
		
		
		public String VerifyTitle() { //including a return type "String" so you need return in method
			return driver.getTitle(); //gettitle is a string, return type is string
		}
		
		public boolean verifyLogo() {
			return Logo.isDisplayed(); //isDisplayed is a boolean, returns true or false
		}
		
		
		
		
		
		
		
}
		
