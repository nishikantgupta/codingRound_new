package com.cleartrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.qa.base.ClearTripBase;
import com.cleartrip.qa.util.TestUtil;

public class HotelSearchPage extends ClearTripBase {

    @FindBy(id = "Tags")
    WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    WebElement travellerSelection;
    
    @FindBy(xpath = "//h1[text()='Search for hotels']")
    WebElement hotelSearchHeader;
    
    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
	WebElement curMonth;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	WebElement curYear;

	@FindBy(xpath = "//div[@class='monthBlock last']//a[@title='Next']")
	WebElement nxtBtn;
	
	public HotelSearchPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean hotelSearchPageValidation() {
		return hotelSearchHeader.isDisplayed();
	}
	
	public SearchedHotelPage fillHotelSearchForm() {
		TestUtil.fillLocation(properties.getProperty("hotelLocality"), localityTextBox, "//ul[@id='ui-id-1']/li/a");
		TestUtil.selectDate(curMonth, curYear, nxtBtn, properties.getProperty("checkInDate"));
		TestUtil.selectDate(curMonth, curYear, nxtBtn, properties.getProperty("checkOutDate"));
		
		Select select = new Select(travellerSelection);
		select.selectByVisibleText("1 room, 2 adults");
		TestUtil.clickOnSearchButton(searchButton);
		return new SearchedHotelPage();
	}
	
	
	
}
