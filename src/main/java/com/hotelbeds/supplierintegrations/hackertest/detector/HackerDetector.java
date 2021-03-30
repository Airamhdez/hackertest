package com.hotelbeds.supplierintegrations.hackertest.detector;

public interface HackerDetector {

	/**
	 * Check the log line if the IP address that has attempted a failed login 5 or more times within a 5 minute period
	 * 
	 * @param line
	 * @return
	 */
	String parseLine(String line);
}
