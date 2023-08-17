package com.mybb.service;

import java.util.List;

import com.mybb.ddd.CalendarVO;

public interface CalendarService {

	// 캘린더 검색
	public List<CalendarVO> getList();
	
}
