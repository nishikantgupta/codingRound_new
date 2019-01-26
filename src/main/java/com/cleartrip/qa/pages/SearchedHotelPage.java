package com.cleartrip.qa.pages;

import org.openqa.selenium.By;

import com.cleartrip.qa.base.ClearTripBase;

public class SearchedHotelPage extends ClearTripBase {

	public SearchedHotelPage() {
		super();
	}
	
	public boolean searchedHotelValidation() {
		String[] city = properties.getProperty("hotelLocality").split(" ");
		return driver.findElement(By.xpath("//span[@class='fillCityName' and text()='" + city[1] + "']"))
				.isDisplayed();
	}
	
}
