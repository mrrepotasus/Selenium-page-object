package com.juaracoding.pageobject.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class SampleForm {

	private WebDriver driver;
	
	public SampleForm() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[contains(@for,'gender-radio')]")
	private List<WebElement> lstGender;
	
	@FindBy(xpath="//label[contains(@for,'hobbies-checkbox')]")
	private List<WebElement> lstHobby;
	
	@FindBy(xpath="//input[@id='uploadPicture']")
	private WebElement uploadFile;
	
	@FindBy(xpath="//*[@id='app']/div/div/div/div/div/div/div[1]/span[1]/div[1]/div[1]")
	private WebElement MenuElement;
	
	@FindBy(xpath="//div[@class=\"element-list collapse show\"]")
	private List<WebElement> lstMenuElement;
	
	public void pilihGender(int index) {
		lstGender.get(index).click();
		System.out.println(lstGender.get(index).getText());
	}
	
	public void pilihHobby(int index) {
		lstHobby.get(index).click();
		System.out.println(lstHobby.get(index).getText());
	}
	
	public void UploadFile(String Location) {
		uploadFile.sendKeys(Location);
	}
	
	public void pilihMenuElement(int index) {
		MenuElement.click();
		System.out.println(lstMenuElement.get(index).getText());
		
	}
}
