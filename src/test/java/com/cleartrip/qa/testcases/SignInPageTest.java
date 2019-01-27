package com.cleartrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.qa.base.ClearTripBase;
import com.cleartrip.qa.pages.HomePage;
import com.cleartrip.qa.pages.SignInPage;

public class SignInPageTest extends ClearTripBase {

	public HomePage homePage;
	public SignInPage signInPage;
	
	
	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		setDriverPath();
		homePage = new HomePage();
		signInPage = new SignInPage();
	}
	
	@Test
	public void errorTestWhenCredentialsMissingOnSignOn() {
		Assert.assertTrue(signInPage.signInFormFill(), "Getting some different message");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
