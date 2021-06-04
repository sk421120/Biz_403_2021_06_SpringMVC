package com.callor.spring;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger("Home Controller");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		// logger 의 method 들
		// 이 method 들을 logger에서는 level
		
		// 예)
		// logback-test.xml의 level을 INFO로 설정
		// 코드 곳곳에 logger.trace(), logger.debug()로 모두 출력코드가 무시
		logger.trace("트레이스");
		logger.debug("디버그");
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.warn("경고");
		logger.error("에러");
		
		logger.debug(String.valueOf(30+40));
		logger.debug("여기는 Home Controller return 바로 위");
		return "home";
	}
	
}
