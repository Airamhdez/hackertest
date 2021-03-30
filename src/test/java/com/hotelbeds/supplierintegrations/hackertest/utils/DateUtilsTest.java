package com.hotelbeds.supplierintegrations.hackertest.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DateUtilsTest {

	@Test
	void getMinutesBetweenSameTimeZoneTest() {
		Long minutes = DateUtils.getMinutesBetween("Mon, 18 Jan 2021 16:01:07 +0200", "Thu, 21 Jan 2021 16:01:07 +0200");
		Assertions.assertEquals(4320, minutes);
	}
	
	@Test
	void getMinutesBetweenDifferentTimeZoneTest() {
		Long minutes = DateUtils.getMinutesBetween("Mon, 18 Jan 2021 16:01:07 +0200", "Mon, 18 Jan 2021 16:01:07 +0100");
		Assertions.assertNotEquals(0, minutes);
		Assertions.assertEquals(60, minutes);
	}

}
