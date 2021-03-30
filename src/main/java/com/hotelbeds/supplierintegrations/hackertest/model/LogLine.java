package com.hotelbeds.supplierintegrations.hackertest.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.hotelbeds.supplierintegrations.hackertest.enums.ActionEnum;

public class LogLine {

	private String ip;
	
	private LocalDateTime date;
	
	private ActionEnum action;
	
	private String userName;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public ActionEnum getAction() {
		return action;
	}

	public void setAction(ActionEnum action) {
		this.action = action;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(action, date, ip, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogLine other = (LogLine) obj;
		return action == other.action && Objects.equals(date, other.date) && Objects.equals(ip, other.ip)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "LogLine [ip=" + ip + ", date=" + date + ", action=" + action + ", userName=" + userName + "]";
	}	
}
