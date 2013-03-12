package com.company.gap.feed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.feed.entity.GodownEntry;

@Controller
@RequestMapping("/feed")
public class FeedController {
	
	/**
	 * 去入库页面
	 */
	@RequestMapping("/toStorage")
	public String toStorage(){
		return "feed/storage";
	}

	/**
	 * 饲料入库
	 */
	public String storage(GodownEntry godownEntry){
		return null;
	}
	
}
