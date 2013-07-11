package com.norming.ess.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/framework/homepage")
public class HomepageController {

	@RequestMapping
	public String index() {
		return "framework/homepage/index";
	}
	
}
