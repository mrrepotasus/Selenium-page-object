package com.juaracoding.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleForm;

public class TestSampleForm {

	public static WebDriver driver;
	private SampleForm sampleform;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/automation-practice-form";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		sampleform = new SampleForm();
	}
	
	@Test
	public void testRadioForm() {
		sampleform.pilihGender(0);
		sampleform.pilihGender(1);
		sampleform.pilihGender(2);
	}
	
	@Test
	public void testCheckForm() {
		scroll(700);
		sampleform.pilihHobby(0);
		sampleform.pilihHobby(1);
		sampleform.pilihHobby(2);
	}
	
	@Test
	public void testUpload() {
		sampleform.UploadFile("C:\\Users\\Ramma\\Pictures\\fatan.jpg");
	}
	
	@Test
	public void testMenuForm() {
		sampleform.pilihMenuElement(0);
		
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