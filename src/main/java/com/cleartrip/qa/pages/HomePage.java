package com.cleartrip.qa.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.qa.base.ClearTripBase;

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
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public SearchPage searchFlight() {
		if (!(oneWaySelection.isSelected()))
			oneWaySelection.click();
		fillLocation(properties.getProperty("origin"), originCity, "//ul[@id='ui-id-1']/li/a");
		fillLocation(properties.getProperty("destination"), destinationCity, "//ul[@id='ui-id-2']/li/a");
		selectDate();
		clickOnSearchButton();
		return new SearchPage();
	} 
	
	public void selectDate() {
		String[] travelDate = properties.getProperty("travelDate").split(" ");
		String day = travelDate[0];
		String month = travelDate[1];
		String year = travelDate[2];
		
		String preXpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[";
		String postXpath = "]/td[";
		
	    while(!(curMonth.getText().contains(month) && curYear.getText().contains(year)))
	    	nxtBtn.click();
	    
	    for(int i = 1; i <= 5; i++) {
	    	for(int j = 1; j <= 7; j++) {
	    		if(driver.findElement(By.xpath(preXpath + i + postXpath + j + "]")).getText().equals(day))
	    			driver.findElement(By.xpath(preXpath + i + postXpath + j + "]")).click();
	    	}
	    }    
	}
	

    public void clickOnSearchButton() {
    	searchBtn.click();
    }
	
	public void fillLocation(String location, WebElement city, String xpath) {
		city.clear();
		city.sendKeys(location);
		List<WebElement> cityOptions = driver.findElements(By.xpath(xpath));
		Iterator<WebElement> itr = cityOptions.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			
			if (element.getText().toLowerCase().contains(location.toLowerCase())) {
				element.click();
			}
		}
	}
}
