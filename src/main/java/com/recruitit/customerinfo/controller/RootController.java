package com.recruitit.customerinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RootController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return "<html><body>Created by John Michael Gerona, for Recruit IT requirement.</body></html>";
	}
	
}
