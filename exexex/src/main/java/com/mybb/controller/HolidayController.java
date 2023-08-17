package com.mybb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mybb.ddd.HolidayVO;
import com.mybb.service.HolidayService;

@Controller
@RequestMapping("/holiday/*")
public class HolidayController {

	private static final Logger log = LoggerFactory.getLogger(HolidayController.class);

	@Autowired
	private HolidayService service;

	@GetMapping("/list")
//	@RequestMapping(value = "list", method = RequestMethod.GET) 랑 같음
	public void HoildayList(Model model) {
		log.info("휴일 테이블 데이터 출력");

		List<HolidayVO> list = service.selectlist();

		model.addAttribute("list", service.selectlist());
//		model.addAttribute("list", list);
		System.out.println("**list : " + list.get(0).getFullyear()+list.get(0).getDow());
		System.out.println("**list : " + service.selectlist());
		
		
	}

	@GetMapping("/add")
	public void addHoliday() {
		log.info("휴일 등록");
	}

	@PostMapping("/add")
	public String addHoliday(HolidayVO hvo, RedirectAttributes rttr) {
		log.info("휴일 데이터 : " + hvo);

		service.addholiday(hvo);
		rttr.addFlashAttribute("result", "add success");

		return "redirect:/holiday/list";
	}

}
