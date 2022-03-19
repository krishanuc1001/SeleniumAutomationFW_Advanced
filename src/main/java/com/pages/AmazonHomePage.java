package com.pages;

import com.enums.WaitStrategyEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.drivers.DriverManager;

public final class AmazonHomePage extends BasePage {

	public AmazonHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='nav-hamburger-menu']")
	private WebElement hamburgerLink;

	public AmazonHamburgerPageMenu clickHamburger() {
		hamburgerLink.click();
		return new AmazonHamburgerPageMenu();
	}

}
