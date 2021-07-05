package com.callor.book.controller.notuse;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverAbstractService;

//@RequestMapping(value="/naver")
//@Controller
public class NaverExitController {
	
	protected final NaverAbstractService nBookService;
	
	public NaverExitController(@Qualifier("naverServiceV1") NaverAbstractService nBookService) {
		this.nBookService = nBookService;
	}
	
	@ResponseBody
	@RequestMapping(value="/book", method=RequestMethod.GET, produces = "application/json;char=UTF8")
	public List<BookDTO> book(String search) throws Exception {
		
		String queryURL = nBookService.queryURL(search);
		String jsonString = nBookService.getJsonString(queryURL);
		
		List<BookDTO> bookList = nBookService.getNaverList(jsonString);
		return bookList;
	}
}
