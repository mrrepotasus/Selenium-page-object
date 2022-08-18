package com.juaracoding.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.Modal;


public class TestModal {

	public static WebDriver driver;
	private Modal modal;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		modal = new Modal();
	}
	
	@Test
	public void testmodal() {
		modal.clickSmallModal();
		System.out.println(modal.getTitleModal());
		System.out.println(modal.getBodyModal());
	}

	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
		
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
	}
}
