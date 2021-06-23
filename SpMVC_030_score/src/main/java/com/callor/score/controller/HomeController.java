package com.callor.score.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;
import com.callor.score.service.SubjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	protected final StudentService stService;
	protected final ScoreService scService;
	protected final SubjectService sbService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<StudentVO> stList = stService.selectAll();
		List<ScoreVO> scList = scService.selectAll();
		List<SubjectVO> sbList = sbService.selectAll();
		log.debug("Controller {}", stList.toString());
		log.debug("Controller {}", scList.toString());
		log.debug("Controller {}", sbList.toString());
		return "home";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		List<ScoreDTO> scViewList = scService.selectViewAll();
		log.debug("Controller {}", scViewList.toString());
		return "home";
	}
	
}
