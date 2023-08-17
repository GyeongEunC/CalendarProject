package com.mybb.ddd;

public class HolidayVO {
	
	private String FULLYEAR;
	private String year;
	private String month;
	private String day;
	private String dow;
	private String reason;
	
	
	public String getFullyear() {
		return FULLYEAR;
	}
	public void setFullyear(String fullyear) {
		this.FULLYEAR = fullyear;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDow() {
		return dow;
	}
	public void setDow(String dow) {
		this.dow = dow;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "HolidayVO [fullyear=" + FULLYEAR + ", year=" + year + ", month=" + month + ", day=" + day + ", dow="
				+ dow + ", reason=" + reason + "]";
	}
}
