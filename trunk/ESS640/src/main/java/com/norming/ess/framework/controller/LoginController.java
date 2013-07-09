package com.norming.ess.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/framework/login")
public class LoginController {
	
	@RequestMapping(value="/index")
	public String index() {
		return "framework/login/index";
	}

}
