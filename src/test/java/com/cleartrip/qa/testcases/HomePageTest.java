package com.cleartrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.qa.base.ClearTripBase;
import com.cleartrip.qa.pages.HomePage;
import com.cleartrip.qa.pages.HotelSearchPage;
import com.cleartrip.qa.pages.SignInPage;
import com.cleartrip.qa.pages.FlightSearchPage;

public class HomePageTest extends ClearTripBase{
	
	public HomePage homePage;
	public FlightSearchPage flightSearchPage;
	public HotelSearchPage hotelSearchPage;
	public SignInPage signInPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		setDriverPath();
		homePage = new HomePage();
		hotelSearchPage = new HotelSearchPage();
		signInPage = new SignInPage();
		
	}
	
	@Test
	public void searchFlightTest() {
		flightSearchPage = homePage.searchFlight();
		Assert.assertEquals(flightSearchPage.searchPageHeader(), true, "Page did not show search result");
	}
	
	@Test
	public void clickOnHotelLinkTest() {
		hotelSearchPage = homePage.clickOnHotelLink();
		Assert.assertTrue(hotelSearchPage.hotelSearchPageValidation(), "Navigated to wrong Page");
		
	}
	
	@Test
	public void navigateToSignInPageTest() {
		signInPage = homePage.navigateToSignInPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
