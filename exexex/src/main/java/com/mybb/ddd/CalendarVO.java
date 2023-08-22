package com.mybb.ddd;

public class CalendarVO {

	private String fullyear;
	private String year;
	private String month;
	private String day;
	private String dow;
	private String d;
	
	public String getFullyear() {
		return fullyear;
	}
	public void setFullyear(String fullyear) {
		this.fullyear = fullyear;
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
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "CalendarVO [fullyear=" + fullyear + ", year=" + year + ", month=" + month + ", day=" + day + ", dow="
				+ dow + ", d=" + d + "]";
	}
}
