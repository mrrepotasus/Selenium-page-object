package com.juaracoding.pageobject.main;

import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.pages.LoginShop;
import com.juaracoding.pageobject.pages.RegisterShop;

public class MainApp {

	public static void main(String[] args) {
	
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		String url ="https://shop.demoqa.com";
//		String url ="https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
		
//		LoginPage loginpage = new LoginPage();
//		loginpage.login("admin", "admin1234");
		
		RegisterShop registershop = new RegisterShop();
		registershop.register("admin71","admin71@gmail.com","ADMINtest12344");
		
		delay(3);
		LoginShop loginshop = new LoginShop();
		loginshop.Login("admin71@gmail.com", "ADMINtest12344");
		
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
