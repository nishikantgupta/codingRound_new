package com.cleartrip.qa.util;

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

}
