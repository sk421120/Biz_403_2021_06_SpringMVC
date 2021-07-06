package com.callor.gallery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/gallery")
@RequiredArgsConstructor
public class GalleryController {
	
	protected final GalleryService gService;
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<GalleryDTO> gList = gService.selectAll();
		log.debug("Gallery List {}", gList.toString());
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
	public String input(
			GalleryDTO gDTO,
			MultipartFile one_file, MultipartHttpServletRequest m_file,
			Model model) throws Exception {
		log.debug("Gallery Info {}", gDTO.toString());
		log.debug("One file {}", one_file.getOriginalFilename());
		log.debug("Multi files {}", m_file.getFileMap().toString());
		
		gService.input(gDTO, one_file, m_file);
		
		return "redirect:/gallery";
	}
}