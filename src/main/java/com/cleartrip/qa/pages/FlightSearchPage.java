  package com.cleartrip.qa.pages;

import org.openqa.selenium.By;

import com.cleartrip.qa.base.ClearTripBase;

public class FlightSearchPage extends ClearTripBase {

	public FlightSearchPage() {
		super();
	}

	String searchPageHeaderXpath = "//div[@class='searchSummary']/Strong[contains(text(),'" + properties.getProperty("origin")
			+ "')][contains(text(),'" + properties.getProperty("destination") + "')]";

	public boolean searchPageHeader() {
		return driver.findElement(By.xpath(searchPageHeaderXpath)).isDisplayed();
	}
}
