package com.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.exceptions.custom.FrameworkExceptions;
import com.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {
	}

	@Test
	public void loginLogOutTest(Map<String, String> testDataMap) {

		OrangeHRMLoginPage lp = new OrangeHRMLoginPage();
		String actualTitle = null;
		try {
			actualTitle = lp.enterUsername(testDataMap.get("username")).enterPassword(testDataMap.get("password"))
					.clickLoginBtn().clickWelcome().clickLogout().getTitle();
		} catch (Exception e) {
			new FrameworkExceptions("There has been an issue getting the title of the page...", e);
		}

		Assertions.assertThat(actualTitle).as("The Actual and Expected titles do not match...")
				.isEqualToIgnoringCase("OrangeHRM123");

	}

	@Test
	public void newTest(Map<String, String> testDataMap) {

		OrangeHRMLoginPage lp = new OrangeHRMLoginPage();
		String actualTitle = null;
		try {
			actualTitle = lp.enterUsername(testDataMap.get("username")).enterPassword(testDataMap.get("password"))
					.clickLoginBtn().clickWelcome().clickLogout().getTitle();
			throw new SkipException("Skipped test...");
		} catch (Exception e) {
			new FrameworkExceptions("There has been an issue getting the title of the page...", e);
		}

//		Assertions.assertThat(actualTitle).as("The Actual and Expected titles do not match...")
//				.isEqualToIgnoringCase("OrangeHRM");

	}

}
