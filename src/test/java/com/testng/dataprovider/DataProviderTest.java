package com.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	/*
	 * If we don't use DataProvider concept, the problems are:
	 * 
	 * 1) The Test count will always be 1, no matter how many tests we run using the
	 * for..loop
	 * 
	 * 2) If there is any failure in one of the iterations, we do not know the
	 * result of the remaining iterations. It can cause defect masking wherein a
	 * probable defect can be hidden due to this.
	 * 
	 */

	// @Test(dataProvider = "getData1")
	public void test1(String str) {

		System.out.println("Entering Username...");
		System.out.println("Entering Password...");

	}

	@Test(dataProvider = "getData3")
	public void test2(Employee emp) {
		System.out.println(emp.getName());
		System.out.println(emp.getId());
	}

	@DataProvider
	public String[] getData1() {
		String str[] = { "Krish", "Chak", "Tangra" };
		return str;
	}

	/*
	 * In a Two-dimensional Object array Object[][]
	 * 
	 * 1) The first dimension is how many iterations we want to run the test.
	 * 
	 * 2) The second dimension is how many parameters we want to feed to our test
	 * method.
	 * 
	 */

	@DataProvider
	public Object[][] getData2() {
		return new Object[][] { { "Krish" }, { "Chak" }, { "Tangra" } };
	}

	/*
	 * Two-dimensional Object array is not mandatory always return type of a Data
	 * Provider method. We can have other return types too, depending on the need.
	 * 
	 * We can have User-defined class types as well as the return types.
	 * 
	 * See the example below.
	 * 
	 */

	@DataProvider
	public Employee[] getData3() {
		return new Employee[] { new Employee("Krish", "1"), new Employee("Chak", "2") };
	}

}
