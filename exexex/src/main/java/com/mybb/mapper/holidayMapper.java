package com.mybb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybb.ddd.CalendarVO;
import com.mybb.ddd.HolidayVO;

@Mapper
public interface holidayMapper {

	// 휴일 등록 insert
	public void addholiday(HolidayVO hvo);
	
	// 휴일 리스트 select
	public List<HolidayVO> selectlist();
	
	// 휴일 데이터 수정
	public String modify(HolidayVO hvo);
}
