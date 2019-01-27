package com.cleartrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.qa.base.ClearTripBase;
import com.cleartrip.qa.util.TestUtil;

public class SignInPage extends ClearTripBase {

	@FindBy(id="signInButton")
	WebElement signInBtn;
	
	@FindBy(xpath="//div[@id='errors1']/span")
	WebElement error;
	
	public HomePage homePage;
	
	public SignInPage() {
		super();
		PageFactory.initElements(driver, this);
		homePage = new HomePage();
	}
	
	public boolean signInFormFill() {
		homePage.navigateToSignInPage();
		TestUtil.clickOnButton(signInBtn);
		return error.getText().contains("There were errors in your submission");
	}
}
