package com.bankguru.payment;


import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import environmentConfig.Environment;

public class Level_21_Multiple_Environment extends BaseTest{
	Environment environment;
	
	@Parameters({"browser"})
	@BeforeClass
	public void initBrowser(String browserName) {
		String prefixPropertiesName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", prefixPropertiesName);
		environment = ConfigFactory.create(Environment.class);
		
		driver = getBrowserDriver(browserName, environment.applicationUrl());
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(environment.appUsername());
		System.out.println(environment.appPass());
	}
	@Test
	public void Employee_01_Add_New_Employee() {
	}
	
	@Test
	public void Employee_02_Upload_Avatar() {
	}

	
	@Parameters({"browser"})
	@AfterClass(alwaysRun=true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition - Close Browser - " + browserName + "");
		cleanBrowserAndDriver();
	}
	WebDriver driver;
}
