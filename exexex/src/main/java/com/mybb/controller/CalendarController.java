package com.mybb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mybb.ddd.CalendarVO;
import com.mybb.ddd.HolidayVO;
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

//		List<CalendarVO> list = service.getList();
//		model.addAttribute("list", list);
//		System.out.println("dddddddddd"+list);
//		CalendarVO cvvo = new CalendarVO();
//		System.out.println("vovovo");
//		System.out.println(cvvo.getMonth());
//		System.out.println(cvvo);
//		System.out.println("vo끝");

		List<CalendarVO> getTodayList;
		getTodayList = service.getTodayDate();
		model.addAttribute("getTodayList", getTodayList);
		System.out.println(getTodayList);
	}

	/*
	 * @GetMapping("/next") public String next(HttpServletRequest request,
	 * HttpServletResponse response, Model model) throws Exception {
	 * 
	 * List<CalendarVO> getTodayList; getTodayList = service.getTodayDate();
	 * model.addAttribute("getTodayList", getTodayList);
	 * System.out.println(getTodayList);
	 * 
	 * if (request == null && response == null) { Location.valueOf("main"); } else {
	 * request.setCharacterEncoding("utf-8"); int year =
	 * Integer.parseInt(request.getParameter("year")); int month =
	 * Integer.parseInt(request.getParameter("month"));
	 * 
	 * System.out.println("gtl " + getTodayList); // getTodayList.set(year, null);
	 * 
	 * 
	 * response.setContentType("text/html;charset=utf-8");
	 * 
	 * PrintWriter out = response.getWriter(); System.out.println(year);
	 * System.out.println(month); // out.println("year : " + year1); //
	 * out.println("month : " + month1);
	 * 
	 * } return "redirect:/calendar/main"; }
	 */
	
	@PostMapping("/main")
	public String addHoliday(CalendarVO cvo, HttpServletRequest request,
			 HttpServletResponse response) throws Exception {
		log.info("이전달");

		List<CalendarVO> getTodayList;
		getTodayList = service.getTodayDate();
		int year = Integer.parseInt(request.getParameter("year")); 
		int month =Integer.parseInt(request.getParameter("month"))-1;

		return "redirect:/calendar/main";
	}
	
	
}
