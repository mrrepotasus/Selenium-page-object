package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class LoginShop {

	private WebDriver driver;
	
	public LoginShop() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement username;	
	
	@FindBy(xpath = "//input[@id='user_pass']")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@id='wp-submit']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//h1[@class='page-title']")
	private WebElement Account;
	
	public void Login (String username, String password) {
		this.username.sendKeys(username);
		System.out.println("Mengisi username pada login");
		this.Password.sendKeys(password);
		System.out.println("Mengisi Password");
		btnLogin.click();
		System.out.println("melakukan click pada button log");
		delay(3);
		Account.isDisplayed();
		System.out.println("Berhasil Masuk");
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
}
}
