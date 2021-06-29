package com.callor.book.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.service.NaverService;
import com.callor.book.service.model.BookDTO;

import lombok.RequiredArgsConstructor;

@RequestMapping(value="/naver")
@Controller
@RequiredArgsConstructor
public class NaverController {
	
	protected final NaverService<BookDTO> nBookService;
	
	@ResponseBody
	@RequestMapping(value="/book", method=RequestMethod.GET, produces = "application/json;char=UTF8")
	public List<BookDTO> book(String search) throws IOException, ParseException {
		
		String queryURL = nBookService.queryURL(search);
		String jsonString = nBookService.getJsonString(queryURL);
		
		List<BookDTO> bookList = nBookService.getNaverList(jsonString);
		return bookList;
	}
}
