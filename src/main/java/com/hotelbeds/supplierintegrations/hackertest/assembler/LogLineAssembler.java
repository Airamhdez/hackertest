package com.hotelbeds.supplierintegrations.hackertest.assembler;

import java.time.Instant;
import java.time.ZoneId;

import com.hotelbeds.supplierintegrations.hackertest.enums.ActionEnum;
import com.hotelbeds.supplierintegrations.hackertest.model.LogLine;

public class LogLineAssembler {
	
	private LogLineAssembler() {		
	}
	
	/**
	 * Convert a string array to a LogLine object
	 * 
	 * @param line
	 * @return
	 */
	public static LogLine stringArrayToLogLine(String[] line) {
		LogLine logLine = new LogLine();
		logLine.setIp(line[0]);
		logLine.setDate(Instant.ofEpochSecond(Long.valueOf(line[1])).atZone(ZoneId.systemDefault()).toLocalDateTime());
		logLine.setAction(ActionEnum.valueOf(line[2]));
		logLine.setUserName(line[3]);
		return logLine;
	}

}
