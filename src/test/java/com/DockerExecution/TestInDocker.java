/**
 * 
 */
package com.DockerExecution;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

/**
 * Jun 29, 2021
 * 
 * @author Krishanu
 */
public class TestInDocker {

	@Test(dataProvider = "getData")
	public void dockerTest1(String browser) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browser);

		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), cap);

		driver.get("https://www.google.com");
		System.out.println("The Page title is => " + driver.getTitle());
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
		driver.quit();

	}

	@DataProvider(parallel = true)
	public Object[][] getData() {

		return new Object[][] { { "chrome" }, { "firefox" }, { "chrome" }, { "firefox" } };

	}

}
