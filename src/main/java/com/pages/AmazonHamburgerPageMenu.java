package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategyEnum;
import com.utils.DynamicXPathUtils;

public final class AmazonHamburgerPageMenu extends BasePage {

	private String mobilesAndComputersLink = "//div[text()='Mobiles, Computers']/parent::a";
	private String linkSubMenu = "//a[text()='%s']"; // Dynamic Xpath using String.format() method

	public AmazonHamburgerPageMenu clickMobilesAndComputersLink() {
		click(By.xpath(mobilesAndComputersLink), WaitStrategyEnum.CLICKABLE, "Mobiles, Computers");
		return this;
	}

	public AmazonLaptopPage clickOnSubmenu(String menuText) {
		String newXpath = DynamicXPathUtils.getXpath(linkSubMenu, menuText);
		click(By.xpath(newXpath), WaitStrategyEnum.CLICKABLE, menuText);

		if (menuText.contains("Laptops")) {
			return new AmazonLaptopPage();
		}

		return null;

	}

}
