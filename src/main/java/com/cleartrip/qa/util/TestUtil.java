package com.cleartrip.qa.util;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.cleartrip.qa.base.ClearTripBase;

import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtil extends ClearTripBase{

	public static void setDriverProperty(String browser, OperatingSystem opSys) {
		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().operatingSystem(opSys).setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().operatingSystem(opSys).setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equals("opera")) {
			WebDriverManager.operadriver().operatingSystem(opSys).setup();
			driver = new OperaDriver();
		}
		
	}
	
	public static void selectDate(WebElement curMonth, WebElement curYear, WebElement nxtBtn, String date) {
		String[] splitDate = date.split(" ");
		String day = splitDate[0];
		String month = splitDate[1];
		String year = splitDate[2];
		
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
	
	public static void fillLocation(String location, WebElement city, String xpath) {
		city.clear();
		city.sendKeys(location);
		
		List<WebElement> cityOptions = driver.findElements(By.xpath(xpath));
		Iterator<WebElement> itr = cityOptions.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			if (element.getText().toLowerCase().contains(location.toLowerCase())) {
				element.click();
				break;
			}
		}
	}
	
	public static void clickOnButton(WebElement searchButton) {
		searchButton.click();
	}
}
