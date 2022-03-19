package com.testng.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {

	/*
	 * 
	 * Using a Single Data provider for multiple Tests - with the help of Java
	 * reflections
	 * 
	 * Reflections help us to fetch property values in the Runtime instead of
	 * Compile time.
	 * 
	 */

	@Test(dataProvider = "getData")
	public void test1(Employee emp) {
		System.out.println(emp.getName());
		System.out.println(emp.getId());
	}

	@Test(dataProvider = "getData")
	public void test2(String username) {
		System.out.println(username);
	}

	@DataProvider
	public static Object[] getData(Method m) {

		if (m.getName().equalsIgnoreCase("test1")) {
			return new Employee[] { 
					new Employee("Krish", "1"), 
					new Employee("Chak", "2") };
		}

		else if (m.getName().equalsIgnoreCase("test2")) {
			return new Object[] { "Krish", "Chak" };
		}

		return null;

	}

}
