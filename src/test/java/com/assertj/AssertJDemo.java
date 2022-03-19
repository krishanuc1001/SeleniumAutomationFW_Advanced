package com.assertj;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.assertj.core.util.Arrays;
import org.testng.annotations.Test;

public class AssertJDemo {
	
	
	public static String str = "Hello World";
	
	//@Test
	public void stringTest() {
			
		Assertions.assertThat(str)
		          .isNotNull()
		          .isNotEmpty()
		          .as("The String is Blank...").isNotBlank()
		          .isEqualTo("Hello World")
		          .contains("Hello")
		          .doesNotContain("Hi")
		          .containsWhitespaces()
		          .containsIgnoringCase("world")
		          .matches("\\w.*" + " World")
		          .doesNotContainPattern("\\d.*")
		          .hasSize(11)
		          .hasSizeGreaterThan(10)
		          .hasSizeLessThan(20)
		          .hasSizeBetween(10, 20)
		          .endsWith("World");
		
	}
	
	//@Test
	public void integerTest() {
		
		int a = 10;
		
		Assertions.assertThat(a)
		          .isEqualTo(10)
		          .isCloseTo(14, Offset.offset(5))
		          .isInstanceOf(Integer.class)
		          .isBetween(3, 15)
		          .isCloseTo(12, Percentage.withPercentage(30))
		          .isNotCloseTo(15, Percentage.withPercentage(30))
		          .isPositive()
		          .isEven()
		          .isGreaterThanOrEqualTo(5)
		          .isLessThanOrEqualTo(20);
		
	}
	
	@Test
	public void listTest() {
		
		List<Object> list1 = Arrays.asList(new String[] {"Selenium", "Automation"});
		List<Object> list2 = Arrays.asList(new String[] {"TestNG", "Maven"});
		List<Object> list3 = Arrays.asList(new String[] {"Cucumber", "BDD"});
		
		Assertions.assertThat(list1)
		          .hasSize(2)
		          .hasSizeBetween(2, 15)
		          .hasAtLeastOneElementOfType(String.class)
		          .isNotEmpty()
		          .contains("Automation")
		          .doesNotContain("Krishanu")
		          .startsWith("Selenium")
		          .containsExactlyInAnyOrder("Selenium", "Automation")
		          .withFailMessage(() -> "String is not having size less than 3")
		          .allMatch(str -> ((String) str).length()<3)
		          .containsAll(list2)
		          .doesNotContainAnyElementsOf(list3);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void customClassTest() {
		
		Employee emp1 = new Employee("Tom", 10, 2000);
		Employee emp2 = new Employee("Tom", 10, 2000);
		
		Assertions.assertThat(emp1)
		          .isEqualToComparingFieldByField(emp2)
		          .isNotNull()
		          .isInstanceOf(Employee.class)
		          .hasFieldOrProperty("age")
		          .hasFieldOrPropertyWithValue("name", "Tom")
		          .extracting(e -> e.age).isEqualTo(15);
		
	}
	
	

}
