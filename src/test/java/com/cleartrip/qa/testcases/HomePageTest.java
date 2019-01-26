package com.cleartrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.qa.base.ClearTripBase;
import com.cleartrip.qa.pages.HomePage;
import com.cleartrip.qa.pages.SearchPage;

public class HomePageTest extends ClearTripBase{
	
	public HomePage homePage;
	public SearchPage searchPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		setDriverPath();
		homePage = new HomePage();
	}
	
	@Test
	public void searchFlightTest() {
		searchPage = homePage.searchFlight();
		Assert.assertEquals(searchPage.searchPageHeader(), true, "Page did not show search result");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
