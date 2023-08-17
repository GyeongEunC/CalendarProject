package com.mybb.service;

import java.util.List;

import com.mybb.ddd.HolidayVO;

public interface HolidayService {

	// 휴일 등록
	public void addholiday(HolidayVO hvo);
	
	// 휴일 리스트
	public List<HolidayVO> selectlist();

}
