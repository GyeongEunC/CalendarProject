package com.mybb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/calendar/*")
public class CalendarController {
	
	private static final Logger log = LoggerFactory.getLogger(HolidayController.class);
	
	@GetMapping("/main")
	public void main() {
		log.info("main");
	}
}
