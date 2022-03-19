package com.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.drivers.Driver;

public class BaseTest {

	protected BaseTest() {
	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {

		Map<String, String> myMap = (Map<String, String>) data[0];
		Driver.initDriver(myMap.get("browser"), myMap.get("version"));

	}

	@AfterMethod
	protected void tearDown() {
		Driver.endDriver();
	}

}
