package com.hotelbeds.supplierintegrations.hackertest.detector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HackerDetectorTest {

	@Test
	void testFiveOrMoreFailureInFiveMinutes() {
		
		HackerDetector hackerDetector = new HackerDetectorImpl();
		
		//Tuesday, 30 March 2021 19:00:00
		String line1 = "80.238.9.179,1617130800,SIGNIN_SUCCESS,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line1));
		
		//Tuesday, 30 March 2021 19:00:20
		String line2 = "80.238.9.179,1617130820,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line2));
		
		//Tuesday, 30 March 2021 19:00:30
		String line3 = "80.238.9.179,1617130830,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line3));
		
		//Tuesday, 30 March 2021 19:00:40
		String line4 = "80.238.9.179,1617130840,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line4));		
		
		//Tuesday, 30 March 2021 19:00:50
		String line5 = "80.238.9.179,1617130850,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line5));
		
		//Tuesday, 30 March 2021 19:01:00
		String line6 = "80.238.9.179,1617130860,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertEquals(hackerDetector.parseLine(line6), "80.238.9.179");
		
		//Tuesday, 30 March 2021 19:01:10
		String line7 = "80.238.9.179,1617130870,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertEquals(hackerDetector.parseLine(line7), "80.238.9.179");
		
		//Tuesday, 30 March 2021 19:01:20
		String line8 = "80.238.9.179,1617130880,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertEquals(hackerDetector.parseLine(line8), "80.238.9.179");
	}
	
	@Test
	void testFiveOrMoreFailureOutFiveMinutes() {
		
		HackerDetector hackerDetector = new HackerDetectorImpl();
		
		//Thursday, 18 March 2021 19:02:00
		String line1 = "80.238.9.130,1616094120,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line1));
		
		//Thursday, 18 March 2021 19:04:00
		String line2 = "80.238.9.130,1616094240,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line2));
		
		//Thursday, 18 March 2021 19:05:00
		String line3 = "80.238.9.130,1616094300,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line3));		
		
		//Thursday, 18 March 2021 19:06:00
		String line4 = "80.238.9.130,1616094360,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line4));
		
		//Thursday, 18 March 2021 19:07:30
		String line5 = "80.238.9.130,1616094450,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line5));
		
		//Thursday, 18 March 2021 19:10:00
		String line6 = "80.238.9.130,1616094600,SIGNIN_FAILURE,Will.Smith";
		Assertions.assertNull(hackerDetector.parseLine(line6));
		
	}

}
