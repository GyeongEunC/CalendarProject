package com.mybb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybb.ddd.CalendarVO;

@Mapper
public interface calendarMapper {

	// 캘린더 검색
	public List<CalendarVO> getList();
}
