package com.cleartrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.qa.base.ClearTripBase;
import com.cleartrip.qa.util.TestUtil;

public class HomePage extends ClearTripBase {

	@FindBy(id = "OneWay")
	WebElement oneWaySelection;

	@FindBy(id = "FromTag")
	WebElement originCity;

	@FindBy(id = "ToTag")
	WebElement destinationCity;

	@FindBy(id = "DepartDate")
	WebElement departDate;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	WebElement curMonth;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	WebElement curYear;
	
	@FindBy(id = "SearchBtn")
	WebElement submitBtn;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']/li/a")
	WebElement listOfOriginCities;
	
	@FindBy(xpath = "//ul[@id='ui-id-2']/li/a")
	WebElement listOfDestinationCities;
	
	@FindBy(xpath = "//div[@class='monthBlock last']//a[@title='Next']")
	WebElement nxtBtn;
	
	@FindBy(id = "SearchBtn")
	WebElement searchBtn;
	
	@FindBy(linkText = "Hotels")
    WebElement hotelLink;
	
	public HomePage() { 
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public FlightSearchPage searchFlight() {
		if (!(oneWaySelection.isSelected()))
			oneWaySelection.click();
		TestUtil.fillLocation(properties.getProperty("origin"), originCity, "//ul[@id='ui-id-1']/li/a");
		TestUtil.fillLocation(properties.getProperty("destination"), destinationCity, "//ul[@id='ui-id-2']/li/a");
		TestUtil.selectDate(curMonth, curYear, nxtBtn, properties.getProperty("travelDate"));
		TestUtil.clickOnSearchButton(searchBtn);
		return new FlightSearchPage();
	} 
	
	public HotelSearchPage clickOnHotelLink() {
		hotelLink.click();
		return new HotelSearchPage();
	}
}
