package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategyEnum;
import com.utils.PasswordManagement;

public final class OrangeHRMLoginPage extends BasePage {

	private final By textBoxUsername = By.id("txtUsername");
	private final By textBoxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By loginBtn = By.id("btnLogin");

	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(textBoxUsername, username, WaitStrategyEnum.PRESENCE, "Username");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textBoxPassword, PasswordManagement.decryptPassword(password), WaitStrategyEnum.PRESENCE, "Password");
		return this;
	}

	public OrangeHRMHomePage clickLoginBtn() {
		click(loginBtn, WaitStrategyEnum.CLICKABLE, "Login");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}

}
