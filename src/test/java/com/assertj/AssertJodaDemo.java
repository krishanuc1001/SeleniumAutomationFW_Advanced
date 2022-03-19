package com.assertj;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

public class AssertJodaDemo {

	@Test
	public void dateTimeTest() {

		LocalDate date = new LocalDate(2021, 6, 16);

		Assertions.assertThat(date)
		          .isGreaterThan(new LocalDate(2021, 5, 1));

	}

}
