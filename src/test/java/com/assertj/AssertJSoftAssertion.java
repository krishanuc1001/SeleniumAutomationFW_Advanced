package com.assertj;

import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class AssertJSoftAssertion {

	@Test
	public void softAssertTest() {

		SoftAssertions sobj = new SoftAssertions();

		sobj.assertThat("Hello World")
		    .isNotEmpty()
		    .hasSize(5)
		    .contains("Hello");
		
		System.out.println("Hi....");

		sobj.assertAll();

	}

	@Test
	public void assertBDDTest() {

		BDDAssertions
		      .then("Hello World")
		      .hasSize(11)
		      .containsIgnoringCase("hello");

	}

}
