package com.drivers;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {
	}

	// Using ThreadLocal class to implement Thread safety when running multiple
	// threads in parallel
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

//	private static ThreadLocal<WebDriver> threadLocalDriverLambda = new ThreadLocal<>().withInitial(() -> {
//		System.setProperty("webdriver.chrome.driver", "//path to chrome driver executable");
//		return new ChromeDriver();
//	});

	/**
	 * Set the WebDriver instance to Thread local variable.
	 * 
	 * Jul 4, 2021
	 * 
	 * @author Krishanu
	 * @param driverParam
	 */
	static void setDriver(WebDriver driverParam) {
		if (Objects.nonNull(driverParam)) {
			threadLocalDriver.set(driverParam);
		}
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	/**
	 * Calling the remove() method on ThreadLocal variable ensures to set the
	 * default value to ThreadLocal variable. It is much safer than assigning null
	 * value to ThreadLocal variable.
	 * 
	 * Jul 4, 2021
	 * 
	 * @author Krishanu
	 */
	static void removeDriver() {
		threadLocalDriver.remove();
	}

}
