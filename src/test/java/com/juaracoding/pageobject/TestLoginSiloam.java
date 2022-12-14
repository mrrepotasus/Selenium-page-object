package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginSiloam;


public class TestLoginSiloam {

	public static WebDriver driver;
	private LoginSiloam loginSiloam;
	
	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Firefox");
		driver = DriverSingleton.getDriver();
		String url ="https://dev.ptdika.com/siloam/panel/login/";
		driver.get(url);
	}
	@BeforeMethod
	public void pageObject() {
		loginSiloam = new LoginSiloam();
	}
	
	@Test
	public void testInvalidLogin() {
		loginSiloam.login("admin", "admin1234");
		System.out.println(loginSiloam.getAttributeRequired());
		assertEquals(loginSiloam.getAttributeRequired(),"true" );
//		jika gambar gunakan boolean menggunakan assertTrue(loginSiloam.getAttributeRequired());
		
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
