package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class ProductandServicesPage extends TestBase{

	//on every test page, declare all the xpaths
	@FindBy(xpath="//input[@id=\"name\"]")
	WebElement TypeName;
	
	@FindBy(xpath="//input[@id=\"sales_price\"]")
	WebElement Salesprice;
	
	@FindBy(xpath="//input[@id=\"item_number\"]")
	WebElement Itemnumber;
	
	@FindBy(xpath="//textarea[@class=\"form-control\"]")
	WebElement Description;
	
	@FindBy(xpath="//span[text()=\"Products & Services\"]")
	WebElement ProductandService;
	
	@FindBy(xpath="//a[text()=\"New Service\"]")
	WebElement NewService;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement Submit;
	
	@FindBy(xpath="//*[@class=\"alert alert-success fade in\"]")
	WebElement SuccessMessage;
	
	public ProductandServicesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ProductandServices() {
		ProductandService.click();
	}
	
	public void NewService() {
		NewService.click();
	}
	
	public boolean ValidateSuccessMessage() {
		return SuccessMessage.isDisplayed();
	}
	
	public void NewOrder(String name, String salesprice, String description, String itemnumber) {
		TypeName.sendKeys(name);
		Salesprice.sendKeys(salesprice);
		Itemnumber.sendKeys(itemnumber);
		Description.sendKeys(description);
		Submit.click();
	}
	
	
	
}
