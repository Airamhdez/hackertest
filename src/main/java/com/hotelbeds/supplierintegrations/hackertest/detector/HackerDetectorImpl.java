package com.hotelbeds.supplierintegrations.hackertest.detector;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hotelbeds.supplierintegrations.hackertest.assembler.LogLineAssembler;
import com.hotelbeds.supplierintegrations.hackertest.enums.ActionEnum;
import com.hotelbeds.supplierintegrations.hackertest.model.LogLine;

@Service
public class HackerDetectorImpl implements HackerDetector {

	private Map<String, List<LogLine>> failedLogins = new HashMap<>();

	@Override
	public String parseLine(String line) {
		if (line != null && line.split(",").length == 4) {
			LogLine logLine = LogLineAssembler.stringArrayToLogLine(line.split(","));

			if (ActionEnum.SIGNIN_FAILURE.equals(logLine.getAction())) {
				return registerLoginFailed(logLine);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Register a login failed and check if the IP address has attempted a failed
	 * login 5 or more times within a 5 minute period
	 * 
	 * @param logLine
	 * @return
	 */
	private String registerLoginFailed(LogLine logLine) {
		String ip = null;
		if (failedLogins.containsKey(logLine.getIp())) {
			List<LogLine> lines = failedLogins.get(logLine.getIp());
			lines.add(logLine);
			if (lines.size() == 5) {
				Comparator<LogLine> logLineDateComparator = (line1, line2) -> line1.getDate()
						.compareTo(line2.getDate());
				//we sort the logLines by date
				Collections.sort(lines, logLineDateComparator);
				if (Duration.between(lines.get(0).getDate(), lines.get(4).getDate()).getSeconds() <= 300) {
					ip = logLine.getIp();
				}
				// the oldest line is removed to free memory
				lines.remove(0);
			}
		} else {
			List<LogLine> lines = new ArrayList<>();
			lines.add(logLine);
			failedLogins.put(logLine.getIp(), lines);
		}
		return ip;
	}
}
