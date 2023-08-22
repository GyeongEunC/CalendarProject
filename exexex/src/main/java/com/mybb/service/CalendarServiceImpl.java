package com.mybb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybb.ddd.CalendarVO;
import com.mybb.mapper.calendarMapper;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private calendarMapper ccmapper;

	@Override
	public List<CalendarVO> getList() {
		return ccmapper.getList();
	}

	@Override
	public List<CalendarVO> getTodayDate() throws Exception {
		return ccmapper.getTodayDate();
	}


}
