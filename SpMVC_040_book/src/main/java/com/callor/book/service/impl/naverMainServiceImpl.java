package com.callor.book.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverBookService;
import com.callor.book.service.NaverMovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("naverMainServiceV1")
public class naverMainServiceImpl {

	@Qualifier("naverBookServiceV2")
	protected final NaverBookService nBookService;
	
	@Qualifier("naverMovieServiceV1")
	protected final NaverMovieService nMovieService;

	public void naverGetData(String cat, String search, Model model)
			throws ParseException, MalformedURLException, IOException {
		if (search != null && !search.equals("")) {
			if (cat.equals("BOOK")) {
				// 도서 검색
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.getJsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				model.addAttribute("BOOKS",books);
			} else if (cat.equals("MOVIE")) {
				// 영화 검색
				String queryURL = nMovieService.queryURL(search);
				String jSonString = nMovieService.getJsonString(queryURL);
				List<MovieDTO> movies = nMovieService.getNaverList(jSonString);
				model.addAttribute("MOVIES", movies);
			} else if (cat.equals("NEWS")) {
				// 뉴스 검색
			}

		}
	}
}
