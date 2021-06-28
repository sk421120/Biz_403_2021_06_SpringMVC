package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.StudentVO;
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
//		List<SubjectAndScoreDTO> ssList = 
//				scService.selectScore(st_num);
		String ret = stService.detail(model, st_num);
//		model.addAttribute("SSLIST", ssList);
//		model.addAttribute("STUDENT", stService.findById(st_num));
		if(ret.equals("OKOK")) {
			model.addAttribute("BODY", "STUDENT_DETAIL");	
		} else {
			model.addAttribute("BODY", "STUDENT_INPUT");
		}
		
		return "home";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.POST)
//	public String detail(
//			@RequestParam(name="subject") List<String> subject,
//			@RequestParam(name="score") List<String> score ) {
//		log.debug("Subject {}", subject.toString());
//		log.debug("Score {}", score.toString());
	public String detail(ScoreInputVO scInputVO) {
		log.debug("Score Input {}", scInputVO.toString());
		String ret = stService.scoreInput(scInputVO);
		/*
		 * redirect를 수행할때 query string을 보내고 싶으면
		 * 해당 변수와 값을 model에 속성(Attribute)로 추가(add)
		 * 
		 * redirect:/student/detail?st_num=" + st_num와
		 * 같이 사용하지 않아도 된다
		 */
		
		return "home";
	}
}
