package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductandServicesPage;
import com.TestUtil.TestUtil;

public class ProductandServicesPageTest extends TestBase{

ProductandServicesPage productandservices; //global variable
LoginPage loginpage;
String sheetName = "Sheet1";
TestUtil testutil;
	
	public ProductandServicesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() { //Pre-requisites before beginning test case. Logs in.
		
		initil(); //launches browser, deletes cookies, etc. (gets ready)
		loginpage = new LoginPage();
		loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
		productandservices = new ProductandServicesPage();
	}
	
	@DataProvider
	public Object[][] moon(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="moon")
	public void CreateNewOrder(String Name, String SalesPrice, String ItemNumber, String Description) {
		productandservices.ProductandServices();
		productandservices.NewService();
		productandservices.NewOrder(Name, SalesPrice, Description, ItemNumber);
		boolean message = productandservices.ValidateSuccessMessage();
		Assert.assertTrue(message);
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
}
