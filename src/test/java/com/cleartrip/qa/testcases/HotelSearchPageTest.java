package com.cleartrip.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.qa.base.ClearTripBase;
import com.cleartrip.qa.pages.HomePage;
import com.cleartrip.qa.pages.HotelSearchPage;
import com.cleartrip.qa.pages.SearchedHotelPage;

import junit.framework.Assert;

public class HotelSearchPageTest extends ClearTripBase {
	
	public HomePage homePage;
	public HotelSearchPage hotelSearchPage;
	public SearchedHotelPage searchedHotelPage;
	
	public HotelSearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		setDriverPath();
		homePage = new HomePage();
		hotelSearchPage = new HotelSearchPage(); 
	}
	
	@Test
	public void HotelSearchPageValidationTest() {
		homePage.clickOnHotelLink();
		Assert.assertTrue("Wrong Page landing", hotelSearchPage.hotelSearchPageValidation());
	}
	
	@Test
	public void fillHotelSearchFormTest() {
		homePage.clickOnHotelLink();
		searchedHotelPage = hotelSearchPage.fillHotelSearchForm();
		Assert.assertTrue("Wrong Hotel Searched", searchedHotelPage.searchedHotelValidation());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
