package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.drivers.DriverManager;
import com.enums.WaitStrategyEnum;
import com.extentReporting.ExtentLogger;
import com.factories.ExplicitWaitFactory;

public class BasePage {

	/*
	 * We need to make sure that the User can only choose from a given set of
	 * predefined options w.r.t. waitStrategy
	 * 
	 * This is where we can use Enums, like below
	 * 
	 * Very important concept, very few people know how to use this.
	 * 
	 */

	protected void click(By by, WaitStrategyEnum waitStrategyEnum, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategyEnum);
		element.click();
		ExtentLogger.pass("<<=====Clicked on ========>> " + elementName, true);
	}

	protected void sendKeys(By by, String str, WaitStrategyEnum waitStrategyEnum, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategyEnum);
		element.sendKeys(str);
		ExtentLogger.pass("<<======Entered ========>> " + elementName, true);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
