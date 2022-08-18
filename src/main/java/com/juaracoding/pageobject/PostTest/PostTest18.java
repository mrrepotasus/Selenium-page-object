package com.juaracoding.pageobject.PostTest;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.pageobject.drivers.DriverSingleton;


public class PostTest18 {
	
private WebDriver driver;
	
	public PostTest18() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
	private WebElement btnAlert;
	
	@FindBy(xpath = "//a[@class='noo-search']")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//input[@name='s']")
	private WebElement InputSearch;
	
	@FindBy(xpath="//select[@id='pa_color']")
	private WebElement Inputcolor;
	
	@FindBy(xpath="//select[@id='pa_size']")
	private WebElement Inputsize;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	private WebElement btnAddCart;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement Alert;
	
	@FindBy(xpath="//a[@class='button wc-forward']")
	private WebElement btnCart;
	
	public void AlertTestQADismiss() {
		btnAlert.click();
	}
	
	public void SearchItem(String Dicari) {
		btnSearch.click();
		InputSearch.sendKeys(Dicari);
		InputSearch.sendKeys(Keys.ENTER);
	}
	
	public void SelectColorSize(int color, int size) {
		Select warna = new Select(Inputcolor);
		Select ukuran = new Select(Inputsize);
		warna.selectByIndex(color);
		ukuran.selectByIndex(size);
		btnAddCart.click();
		System.out.println(Alert.getText());
	}
		
	public void ViewCart() {
		btnCart.click();
		
	}
}
