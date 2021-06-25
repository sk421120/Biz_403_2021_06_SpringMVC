package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/student")
public class StudentController {
	
	protected final StudentService stService;
	protected final ScoreService scService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String list(Model model) {
		List<StudentVO> stList = stService.selectAll();
		
		model.addAttribute("STLIST", stList);
//		String BODY = "STUDENT_LIST";
//		view.rendering(BODY);
	    model.addAttribute("BODY", "STUDENT_LIST");
		
	    return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String input(Model model) {
		
		StudentVO stVO = new StudentVO();
		stVO.setSt_num( stService.makeStNum() );
		
		model.addAttribute("STUDENT", stVO);
		model.addAttribute("BODY", "STUDENT_INPUT");
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String input(StudentVO vo, Model model) {
		log.debug("Req 학생정보 {}", vo.toString());
		
		int ret = stService.insert(vo);
		
		model.addAttribute("BODY", "STUDENT_INPUT");
		return "redirect:/student";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String st_num, Model model) {
		List<SubjectAndScoreDTO> ssList = 
				scService.selectScore(st_num);
		
		model.addAttribute("SSLIST", ssList);
		model.addAttribute("STUDENT", stService.findById(st_num));
		model.addAttribute("BODY", "STUDENT_DETAIL");
		return "home";
	}
}
