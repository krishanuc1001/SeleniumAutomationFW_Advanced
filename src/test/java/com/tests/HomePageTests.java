package com.tests;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.drivers.DriverManager;

public final class HomePageTests extends BaseTest {

	private HomePageTests() {
	}

	/*
	 * 1) Validate title contains "Google search" 
	 * 2) Validate title is not null and length is greater than 15 and less than 100 
	 * 3) Check for the links in the page => Testing Mini Bytes - Youtube 
	 * 4) Check whether number of links displayed is exactly 10 or 15
	 *
	 */

	@Test
	public void test2() {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Krishanu", Keys.ENTER);
		String actualTitle = DriverManager.getDriver().getTitle();
		System.out.println(actualTitle);
		
		// Assertions using AssertJ third party library
		assertThat(actualTitle)
		    .as("Object is null...").isNotNull()
		    .as("The expected text not present").containsIgnoringCase("google search")
		    .hasSizeBetween(15, 100);
		
//		Assert.assertTrue(Objects.nonNull(actualTitle));
//		Assert.assertTrue(actualTitle.toLowerCase().contains("google search"));
//		Assert.assertTrue(actualTitle.length() > 15);
//		Assert.assertTrue(actualTitle.length() < 100);
		
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
		
		assertThat(elements)
		    .hasSize(10)
		    .extracting(e -> e.getText())
		    .contains("Krishanu");
		
//		Assert.assertEquals(elements.size(), 10);
//		
//		boolean isElementPresent = false;
//		
//		for (WebElement ele : elements) {
//			if (ele.getText().equalsIgnoreCase("Testing Mini Bytes - Youtube")) {
//				isElementPresent = true;
//				break;
//			}
//		}
//		
//		Assert.assertTrue(isElementPresent, "Title is null...");
		

	}

}
