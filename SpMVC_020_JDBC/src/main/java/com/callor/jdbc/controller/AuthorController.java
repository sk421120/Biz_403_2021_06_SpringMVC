package com.callor.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

	@RequestMapping(value="/author/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "author/input";
	}
}
