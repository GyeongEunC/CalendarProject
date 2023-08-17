package com.mybb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybb.ddd.CalendarVO;
import com.mybb.ddd.HolidayVO;
import com.mybb.mapper.holidayMapper;

@Service
public class HolidayServiceImpl implements HolidayService{
	
	@Autowired
	private holidayMapper hhmapper;

	@Override
	public void addholiday(HolidayVO hvo) {
		hhmapper.addholiday(hvo);
	}

	@Override
	public List<HolidayVO> selectlist() {
		return hhmapper.selectlist();
	}
}
