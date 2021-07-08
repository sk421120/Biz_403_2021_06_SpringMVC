package com.callor.gallery.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	@Qualifier("fileServiceV2")
	protected final FileService fileService;
	
	// localhost:8080/rootPath/dumy/gallery/detail을 요청했을때 Request를 처리할 method
	// a tag를 클릭했을 때 : <a hef="${rootPath}/dumy.....detail">클릭</a>
	// 주소창에 직접 입력하고 Enter를 눌렀을때
	//	http://localhost:8080/rootPath/dumy.....detail
	// location.href=${rootPath}/dumy.....detail 을 실행했을 때
	@RequestMapping(value="/dumy/gallery/detail", method=RequestMethod.GET)
	public String dumy() {
		return "home";
	}
	
	/*
	 * <form action="${rootPath}/dumy/gallery/detail" method="POST">
	 * 	<input name="str">
	 * 	<button type="submit">전송</button>
	 * </form>
	 * 
	 * JSP, HTML에서 위 코드를 만들고 입력화면을 보여준 후 input box에 어떤 문자열을
	 * 	입력한 후 전송 button을 클릭하면 이 method가 Request를 수신하고
	 *  input box에 입력한 문자열은 str 변수에 담기게 된다
	 * 
	 */
	@RequestMapping(value="/dumy/gallery/detail", method=RequestMethod.POST)
	public String dumy(String str) {
		return "home";
	}
	
	// localhost:8080/rootPath/dumy/gallery/detail/image 요청했을때 Request를 처리할 method
	@RequestMapping(value="/dumy/gallery/detail/image", method=RequestMethod.GET)
	public String dumy1() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		return "home";
		return "redirect:/gallery";
	}
	
	/*
	 * MultipartHttpServletRequest
	 * 이 클래스는 @RequestParam을 붙이면 안된다 > 400오류
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(@RequestParam("one_file") MultipartFile one_file,
			MultipartHttpServletRequest m_file, Model model) throws Exception {
//		List<MultipartFile> files = m_file.getFiles("m_file");
//		String fileName = fileService.fileUp(files.get(0));
//		
//		model.addAttribute("ONEF", fileName);
		
		List<String> fileNames = fileService.filesUp(m_file);
		model.addAttribute("FILES", fileNames);
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String home(@RequestParam("one_file") MultipartFile one_file,
			MultipartHttpServletRequest m_file) {
		log.debug("m_file size {}", m_file.getFile("m_file").getSize());
		
		/*
		 * 다수의 파일이 업로드되면 파일들의 정보가 m_file 객체에 담기게 된다
		 * 
		 * m_file  객체에서 getFiles() method를 사용하여 파일들 list를 추출
		 * List<MultipartFile> type의 객체에 담든다
		 * 
		 * 이때 getFiles()에는 form에서 설정된 input tag의 name 값을 지정
		 * 또한 input tag에는 multiple="multiple"이 설정되어있어야 한다
		 */
		List<MultipartFile> files = m_file.getFiles("m_file");
		for(MultipartFile file : files) {
			log.debug("파일들 {}", file.getOriginalFilename());
		}
		
		return "home";
	}
	
}
