package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;

public class TestLogin {

	public static WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url ="https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
	}
	@BeforeMethod
	public void pageObject() {
		loginPage = new LoginPage();
	}
	
	@Test
	public void testInvalidLogin() {
		loginPage.login("admin", "admin1234");
		assertEquals(loginPage.msgInvalid(), "Invalid credentials");
	}
	@Test
	public void testValidLogin() {
		loginPage.login("admin","admin123");
		assertEquals(loginPage.getTxtDashboard(), "Dashboard");
	}
	@Test
	public void testUsernameEmptyLogin() {
		loginPage.login("", "admin1234");
		assertEquals(loginPage.msgInvalid(), "Username cannot be empty");
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}
