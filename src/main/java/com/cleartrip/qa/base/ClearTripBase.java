package com.cleartrip.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.qa.util.TestUtil;

import io.github.bonigarcia.wdm.OperatingSystem;

public class ClearTripBase {

	public static WebDriver driver;
	public static Properties properties;
	public static WebDriverWait wait;

	
	public ClearTripBase() {
		properties = new Properties();
		File file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/cleartrip/qa/config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(file + " missing.");
		} catch (IOException e) {
			System.out.println("Issue with loading input file: " + file);
		}
	}
 
	//@Test
	public static void setDriverPath() {
		TestUtil.setDriverProperty(properties.getProperty("browser"), OperatingSystem.valueOf(properties.getProperty("os")));

		wait = new WebDriverWait(driver, 30);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
}
