package com.mybb.ddd;

public class CalendarVO {

	private int fullyear;
	private int year;
	private int month;
	private int day;
	private String dow;
	private int d;
	
	public int getFullyear() {
		return fullyear;
	}
	public void setFullyear(int fullyear) {
		this.fullyear = fullyear;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getDow() {
		return dow;
	}
	public void setDow(String dow) {
		this.dow = dow;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "CalendarVO [fullyear=" + fullyear + ", year=" + year + ", month=" + month + ", day=" + day + ", dow="
				+ dow + ", d=" + d + "]";
	}
	
}
