package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class RandomPokemon {

private WebDriver driver;
	
	public RandomPokemon() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id=\"n\"]")
	private WebElement PilihJumlah;
	
	@FindBy(xpath="//select[@id=\"type\"]")
	private WebElement pilihRegion;
	
	@FindBy(xpath="//input[@value=\"Generate\"]")
	private WebElement btnGenerate;
	
	
	public void generatePokemon() {
		Select jumlah = new Select(PilihJumlah);
		jumlah.selectByIndex(2);
		Select region = new Select(pilihRegion);
		region.selectByIndex(5);
		btnGenerate.click();
	}	
}
