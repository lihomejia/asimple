package com.company.gap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class IndexController {
	
	
	@RequestMapping("index")
	public String index() {
		return "web/index";
	}
}
