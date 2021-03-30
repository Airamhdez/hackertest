package com.hotelbeds.supplierintegrations.hackertest.assembler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hotelbeds.supplierintegrations.hackertest.model.LogLine;

class LogLineAssemblerTest {

	@Test
	void stringArrayToLogLineTest() {
		String[] data = new String[4];
		data[0] = "80.238.9.179";
		data[1] = "133612948";
		data[2] = "SIGNIN_FAILURE";
		data[3] = "Will.Smith";
		LogLine logLine = LogLineAssembler.stringArrayToLogLine(data);
		Assertions.assertEquals(logLine.getIp(), data[0]);
		Assertions.assertNotNull(logLine.getDate());
		Assertions.assertEquals(logLine.getAction().toString(), data[2]);
		Assertions.assertEquals(logLine.getUserName(), data[3]);
	}

}
