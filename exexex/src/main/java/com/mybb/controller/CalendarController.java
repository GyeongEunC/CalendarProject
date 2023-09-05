package com.mybb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient.Redirect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
//		CalendarVO cvvo = new CalendarVO();

		// 오늘 날짜 상수로 받아옴
		final List<CalendarVO> getTodayList = service.getTodayDate();
		final int tFullYear = getTodayList.get(0).getFullyear();
		final int tYear = getTodayList.get(0).getYear();
		final int tMonth = getTodayList.get(0).getMonth();
		final int tDay = getTodayList.get(0).getDay();
		final String tDow = getTodayList.get(0).getDow();
		final int tD = getTodayList.get(0).getD();
		System.out.println("오늘 날짜 상수로 받아 옴 : " + getTodayList);

		// List<> newTodayList = service.getTodayDate();
		// 상수로 받아온 오늘날자 newTodayList로 넣어줌
		Map<String, Object> newTodayList = new HashMap<>();
		newTodayList.put("tFullYear", tFullYear);
		newTodayList.put("tYear", tYear);
		newTodayList.put("tMonth", tMonth);
		newTodayList.put("tDay", tDay);
		newTodayList.put("tDow", tDow);
		newTodayList.put("tD", tD);
		
		// 모듈화 또는 인자로 넘길 필요성 있으므로 찾아보도록 (0905)
		
		System.out.println(newTodayList.get("tYear"));
		System.out.println(newTodayList.get("tFullYear"));
		
		System.out.println("새로운 뉴 투데이 : " + newTodayList);

		model.addAttribute("getTodayList", getTodayList);
		model.addAttribute("newTodayList", newTodayList);
		System.out.println(getTodayList.get(0).getYear());
		System.out.println(getTodayList.get(0).getMonth());
		int year = getTodayList.get(0).getYear();
		int month = getTodayList.get(0).getMonth() - 1;
		System.out.println(year + "년  " + month + "월");

		// return "/calendar/main";
	}

	@GetMapping(value = "/lastMonth")
	public String lastMonth() throws Exception {
		System.out.println("get");
		return "forward:/calendar/lastMonth";
	}

	@PostMapping(value = "/lastMonth")
	public String lastMonth(Model model) throws Exception {

		// 오늘 날짜 상수로 받아옴
		final List<CalendarVO> getTodayList = service.getTodayDate();
		final int tFullYear = getTodayList.get(0).getFullyear();
		final int tYear = getTodayList.get(0).getYear();
		final int tMonth = getTodayList.get(0).getMonth();
		final int tDay = getTodayList.get(0).getDay();
		final String tDow = getTodayList.get(0).getDow();
		final int tD = getTodayList.get(0).getD();
		System.out.println("오늘 날짜 상수로 받아 옴 : " + getTodayList);

		// List<> newTodayList = service.getTodayDate();
		// 상수로 받아온 오늘날자 newTodayList로 넣어줌
		List newTodayList = new ArrayList<>();
		newTodayList.add(0, tFullYear);
		newTodayList.add(1, tYear);
		newTodayList.add(2, tMonth);
		newTodayList.add(3, tDay);
		newTodayList.add(4, tDow);
		newTodayList.add(5, tD);

		System.out.println("새로운 뉴 투데이 : " + newTodayList);
		
		model.addAttribute("newTodayList", newTodayList);
		System.out.println(newTodayList);		

//		List<CalendarVO> getTodayList = service.getTodayDate();
//		model.addAttribute("getTodayList", getTodayList);
//		System.out.println("모델 : " + model);
//
//		int year = getTodayList.get(0).getYear();
//		int month = getTodayList.get(0).getMonth();
//
//		System.out.println(year + "년  " + month + "월");
//
//		List<CalendarVO> newTodayList = getTodayList;
//		System.out.println("newTodayList" + newTodayList);
//		model.addAttribute("newTodayList", newTodayList);
//		int newMonth = newTodayList.get(0).getMonth();
//		newMonth = newMonth - 1;
//		newTodayList.get(0).setMonth(newMonth);
//		System.out.println("newTodayList" + newTodayList);
//		System.out.println("newMonth" + newMonth);
//		System.out.println("ㅈㅈㅇㅈㅇ");

		return "/calendar/main";
	}

	@GetMapping(value = "/nextMonth")
	public String nextMonth() {
		System.out.println("getget");
		return "calendar/main";
	}

	@PostMapping(value = "/nextMonth")
	public String nextMonth(Model model) throws Exception {

		List<CalendarVO> getTodayList = service.getTodayDate();
		model.addAttribute("getTodayList", getTodayList);
		// System.out.println("모델 : " + model);

		// int year = getTodayList.get(0).getYear();
		// int month = getTodayList.get(0).getMonth();

		// System.out.println(year + "년 " + month + "월");

		List<CalendarVO> newTodayList = service.getTodayDate();
		// System.out.println("newTodayList" + newTodayList);
		model.addAttribute("newTodayList", newTodayList);
		System.out.println(newTodayList);
		int newMonth = newTodayList.get(0).getMonth();
		int newYear = newTodayList.get(0).getYear();
		System.out.println("newMonth 이전 : " + newMonth);
		System.out.println("1. newTodayList" + newTodayList);
		if (newMonth == 12) {
			newYear = newYear + 1;
			newMonth = 1;
		} else {
			newMonth = newMonth + 1;
		}
		newTodayList.get(0).setYear(newYear);
		newTodayList.get(0).setMonth(newMonth);
		System.out.println("newMonth 이후 : " + newMonth);
		model.addAttribute("newTodayList", newTodayList);
		System.out.println("2. newTodayList" + newTodayList);
		getTodayList.get(0).setYear(newYear);
		getTodayList.get(0).setMonth(newMonth);
		// System.out.println("newTodayList" + newTodayList);
		// System.out.println("newMonth" + newMonth);
		// System.out.println("nextnext");

		return "calendar/nextMonth";
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

	/*
	 * @PostMapping("/main") public String addHoliday(CalendarVO cvo,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * log.info("이전달");
	 * 
	 * List<CalendarVO> getTodayList; getTodayList = service.getTodayDate(); int
	 * year = Integer.parseInt(request.getParameter("year")); int month
	 * =Integer.parseInt(request.getParameter("month"));
	 * 
	 * return "redirect:/calendar/main"; }
	 */

//	@RequestMapping(value = "/main", method = RequestMethod.POST)
//	public String lastMonth(Model model, @ModelAttribute CalendarVO cvo) throws Exception {
//		log.info("이전달");
//
//		model.addAttribute("cvo", cvo);
//		List<CalendarVO> getTodayList;
//		getTodayList = service.getTodayDate();
//
//		return "redirect:/calendar/main";
//	}

	/*
	 * @GetMapping("/lastmonth") public String next(HttpServletRequest request,
	 * HttpServletResponse response, Model model) throws Exception {
	 * log.info("이전달");
	 * 
	 * List<CalendarVO> getTodayList; getTodayList = service.getTodayDate();
	 * model.addAttribute("getTodayList", getTodayList);
	 * System.out.println(getTodayList);
	 * 
	 * request.setCharacterEncoding("utf-8"); int year =
	 * Integer.parseInt(request.getParameter("year")); int month =
	 * Integer.parseInt(request.getParameter("month"));
	 * 
	 * return "redirect:/calendar/main?year=year&month=month-1"; }
	 */

}
