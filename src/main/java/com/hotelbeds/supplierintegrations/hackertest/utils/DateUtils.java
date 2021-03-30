package com.hotelbeds.supplierintegrations.hackertest.utils;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	private DateUtils() {		
	}
	
	/**
	 * Get the difference in minutes between two timestamps in RFC 2822 format
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static Long getMinutesBetween(String time1, String time2) {
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z");
		ZonedDateTime date1 = ZonedDateTime.parse(time1, dateformatter);
		ZonedDateTime date2 = ZonedDateTime.parse(time2, dateformatter);
		
		return Duration.between(date1, date2).toMinutes();
	}
}
