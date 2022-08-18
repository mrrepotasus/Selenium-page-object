package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class SampleAlert {

private WebDriver driver;
	
	public SampleAlert() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id=\"confirmResult\"]")
	private WebElement txtConfirmResult;
	
	@FindBy(xpath="//button[@id=\"confirmButton\"]")
	private WebElement btnClickMe;
	
	@FindBy(xpath="//span[@id=\"promptResult\"]")
	private WebElement txtPromtResult;
	
	@FindBy(xpath="//button[@id=\"promtButton\"]")
	private WebElement btnClickPromt;
	
	public void clickMe() {
		btnClickMe.click();
	}
	
	public String getTxtConfrimResult() {
		return txtConfirmResult.getText();
	}
	
	public void clickPromt() {
		btnClickPromt.click();
	}
	
	public String getTxtPromtResult() {
		return txtPromtResult.getText();
	}
}
