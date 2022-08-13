package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.juaracoding.pageobject.drivers.DriverSingleton;

public class RegisterShop {
	
	private WebDriver driver;
	
	public RegisterShop() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
	private WebElement btnAlert;	
	@FindBy(xpath = "//a[@href='https://shop.demoqa.com/my-account/']")
	private WebElement btnAccount;	
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement username;	
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement email;	
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement Password;	
	@FindBy(xpath = " //button[@name='register']")
	private WebElement btnRegister;	

	public void register (String username, String email, String password) {
		btnAlert.click();
		System.out.println("Melakukan click pada alert");
		btnAccount.click();
		System.out.println("Pindah ke page Account");
		delay(3);
		this.username.sendKeys(username);
		System.out.println("Mengisi username pada register");
		this.email.sendKeys(email);
		System.out.println("Mengisi email");
		this.Password.sendKeys(password);
		System.out.println("Mengisi password ");
		btnRegister.click();
		System.out.println("melkukan click pada button register");
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
}
}