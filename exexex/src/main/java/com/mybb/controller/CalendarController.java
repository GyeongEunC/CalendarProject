package com.mybb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybb.ddd.CalendarVO;
import com.mybb.service.CalendarService;


@Controller
@RequestMapping("/calendar/*")
public class CalendarController {
	
	@Autowired
	CalendarService service;
	
	private static final Logger log = LoggerFactory.getLogger(HolidayController.class);
	
	@GetMapping("/main")
	public void main(Model model) throws Exception {
		log.info("main");
		
		List<CalendarVO> list = null;
		list = service.getList();
		model.addAttribute("list", list);
//		System.out.println("dddddddddd"+list);
		
		List<CalendarVO> getTodayList;
		getTodayList = service.getTodayDate();
		model.addAttribute("getTodayList", getTodayList);
		System.out.println(getTodayList);
		
	}
}
