package com.juaracoding.pageobject.driver.stategies;

public class DriverStrategyImplementer {
	
	public static DriverStrategy choosesStrategy(String strategy) {
		switch(strategy) {
		case "Chrome":
			return new Chrome();
		case "Firefox":
			return new Firefox();
		default:
			return null;
			
		}
	}

}
