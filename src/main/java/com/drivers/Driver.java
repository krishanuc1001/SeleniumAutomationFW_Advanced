package com.drivers;

import java.net.MalformedURLException;
import java.util.Objects;

import com.enums.ConfigPropertiesEnum;
import com.exceptions.custom.BrowserInvocationFailException;
import com.factories.DriverFactory;
import com.utils.PropertiesUtils;

/**
 * @author Krishanu
 * 
 *         <p>
 *         Jun 28, 2021
 *         </p>
 * 
 *         <pre>
 * Driver class is responsible for invoking and closing the browsers.
 * It is also responsible for setting the driver variable to DriverManager which
 * handles the thread-safety for the webdriver instance.
 *         </pre>
 *
 *
 * @see DriverManager
 * @see com.tests.BaseTest
 *
 * 
 */

public final class Driver {

	/**
	 * The Constructor is made private so that the class cannot be initialized
	 * externally.
	 * 
	 */
	private Driver() {
	}

	/**
	 * 
	 * Jun 28, 2021
	 * 
	 * @author Krishanu
	 * @param browser value will be passed from the Base Test. Values can be Chrome
	 *                or Firefox.
	 * 
	 *                <pre>
	 * This method initializes the driver
	 *                </pre>
	 * 
	 * 
	 */

	@SuppressWarnings("unused")
	public static void initDriver(String browser, String version) {

		// String runmode = PropertiesUtils.get(ConfigPropertiesEnum.RUNMODE);

		if (Objects.isNull(DriverManager.getDriver())) {

			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser, version));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailException(
						"A Malformed URL exception in Runtime has occurred during browser initialization.Please check the browser capabilities!!!",
						e);
			}

			DriverManager.getDriver().get(PropertiesUtils.get(ConfigPropertiesEnum.URL));
			DriverManager.getDriver().manage().window().maximize();

		}

	}

	/**
	 * 
	 * Jun 28, 2021
	 * 
	 * @author Krishanu
	 * 
	 *         <pre>
	 * This method terminates the driver
	 *         </pre>
	 * 
	 */
	public static void endDriver() {

		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.removeDriver();
		}

	}

}
