package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	/*
	 * 보편적인 Spring에서 Bean을 사용하는 코드
	 * @AutoWired
	 * private BookDao bookDao
	 * 이 코드에서 메모리 leak(누수)현상이 보고되어 다음의 코드를 권장한다
	 */
//	protected BookDao bookDao;
	protected RentService rentService;
	
	public HomeController(RentService rentService) {
		this.rentService = rentService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		bookDao.selectAll();
//		compDao.selectAll();
//		authorDao.selectAll();
		rentService.viewBookAndComp();
		return "home";
	}
	
}
