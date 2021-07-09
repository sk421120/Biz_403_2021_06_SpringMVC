package com.callor.gallery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/gallery")
@RequiredArgsConstructor
public class GalleryController {
	
	@Qualifier("galleryServiceV2")
	protected final GalleryService gService;
	
	/*
	 * 주소창에 직접 입력후 Enter
	 * localhost:8080/rootPath/gallery/dumy로 요청했을때 Request를 처리할 method
	 * a tag 클릭
	 * 	<a href="${rootPath}/gallery/dumy">나와라</a>
	 * 
	 * JS
	 * 	location.href="${rootPath}/gallery/dumy"가 실행
	 */
	@RequestMapping(value="/dumy", method=RequestMethod.GET)
	public String dumy() {
		return "home";
	}
	
	/*
	 * <form action="${rootPath}/gallery/dumy" method="POST">
	 * 	<input name="str">
	 * 	<button type="submit">전송</button>
	 * </form>
	 */
	@RequestMapping(value="/dumy", method=RequestMethod.POST)
	public String dumy(String str) {
		return "home";
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<GalleryDTO> gList = gService.selectAll();
//		log.debug("Gallery List {}", gList.toString());
		model.addAttribute("GALLERYS", gList);
		model.addAttribute("BODY", "GA_LIST");
		return "home";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(Model model) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		GalleryDTO gDTO =
				GalleryDTO.builder().g_date(curDate).g_time(curTime).
				g_writer("먀먀").build();
		model.addAttribute("CMD",gDTO);
		
		model.addAttribute("BODY","GA_INPUT");
		return "home";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input( GalleryDTO gDTO,
			MultipartFile one_file, MultipartHttpServletRequest m_file,
			Model model, HttpSession session ) throws Exception {
		MemberVO mVO = (MemberVO) session.getAttribute("MEMBER");
		if(mVO == null) {
			return "redirect:/member/login";
		}
		log.debug("Gallery Info {}", gDTO.toString());
		log.debug("One file {}", one_file.getOriginalFilename());
		log.debug("Multi files {}", m_file.getFileMap().toString());
		
		gService.input(gDTO, one_file, m_file);
		
		return "redirect:/gallery";
	}
	
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model) {
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return "redirect:/gallery";
		}
		
		List<GalleryFilesDTO> gfList = gService.findByIdGalleryFiles(g_seq);
		model.addAttribute("GFLIST", gfList);
		model.addAttribute("BODY", "GA_DETAIL");
		return "home";
	}

	@RequestMapping(value="/detail2/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model,
			HttpSession session) {
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.debug("갤러리 ID 값 오류");
			return "redirect:/";
		}
		
		
		GalleryDTO galleryDTO = gService.findByIdGallery(g_seq);
		model.addAttribute("GALLERY", galleryDTO);
		model.addAttribute("BODY", "GA_DETAIL_V2");
		return "home";
	}
	
	// 첨부파일이 있는 게시물의 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("g_seq") String seq, HttpSession session){
		
		// 삭제 요구 > 로그인 되었나 확인
		MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
		if(memVO == null) {
			return "redirect:/member/login";
		}
		
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.debug("갤러리 SEQ 오류");
			return "redirect:/gallery";
		}
		
		int ret = gService.delete(g_seq);
		
		return "redirect:/gallery";
	}
}
