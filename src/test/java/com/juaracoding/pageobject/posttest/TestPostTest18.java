package com.juaracoding.pageobject.posttest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.PostTest.PostTest18;
import com.juaracoding.pageobject.drivers.DriverSingleton;

public class TestPostTest18 {

	public static WebDriver driver;
	private PostTest18 posttest18;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		posttest18 = new PostTest18();
	}
	
	@Test(priority = 1)
	public void TestPembelian1() {
		posttest18.AlertTestQADismiss();
		posttest18.SearchItem("Pink Drop");
		delay(3);
		scroll(500);
		posttest18.SelectColorSize(1,1);
		delay(3);
	}
	
	@Test(priority = 2)
	public void TestPembelian2() {
		posttest18.SearchItem("blue Denim");
		delay(3);
		scroll(500);
		posttest18.SelectColorSize(1,1);
		delay(3);
	}
	
	@Test(priority = 3)
	public void ShowCart() {
		posttest18.ViewCart();
		scroll(500);
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(10);
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
