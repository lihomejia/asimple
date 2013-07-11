package com.norming.ess.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/framework/logout")
public class LogoutController {
	
	@RequestMapping
	public String index() {
		return "framework/logout/index";
	}

}
