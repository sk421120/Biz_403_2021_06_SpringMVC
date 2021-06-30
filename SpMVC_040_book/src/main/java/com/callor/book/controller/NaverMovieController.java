package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value="/movie")
public class NaverMovieController {
	
//	@Qualifier("naverServiceV2")
//	protected final NaverService<MovieDTO> nMovieService;

	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(@RequestParam(name="search", required = false,
			defaultValue = "")String search, Model model)
					throws MalformedURLException, IOException, ParseException {
		
		model.addAttribute("pHolder", "영화 검색어");
		
		if(search != null && !search.equals("")) {
//			String queryURL = nMovieService.queryURL(search.trim());
//			String jsonString = nMovieService.getJsonString(queryURL);
			
//			List<BookDTO> bookList = nMovieService.getNaverList(jsonString);
			
//			model.addAttribute("BOOKS", bookList);
		}
		return "home";
	}
}
