package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategyEnum;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[contains(text(), 'Logout')]");

	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategyEnum.CLICKABLE, "Welcome");
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		// We can use the Uninterruptibles class commons-lang3 to implement the
		// Thread.sleep without getting any interruptions.
		// Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

		// expWait.until(d -> d.findElement(linkLogout).isEnabled()); // Java 8 way
		// using Lambdas

		click(linkLogout, WaitStrategyEnum.CLICKABLE, "Logout");
		return new OrangeHRMLoginPage();
	}

}
