package com.company.gap.feed.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.feed.entity.FeedResource;
import com.company.gap.feed.entity.GodownEntry;
import com.company.gap.feed.enumeration.FeedResourceEnum;
import com.company.gap.feed.enumeration.GodownEntryStatus;
import com.company.gap.feed.service.FeedResourceService;
import com.company.gap.feed.service.FeedService;

@Controller
@RequestMapping("/feed")
public class FeedController {
	
	@Autowired
	private FeedResourceService feedResourceService;
	@Autowired
	private FeedService feedService;
	/**
	 * 去入库页面
	 */
	@RequestMapping("/toStorage")
	public String toStorage(HttpServletRequest request){
		List<FeedResource> rsList = feedResourceService.findResourceByType(FeedResourceEnum.NAME);
		List<FeedResource> spList = feedResourceService.findResourceByType(FeedResourceEnum.SPECIFICATION);
		List<FeedResource> typeList = feedResourceService.findResourceByType(FeedResourceEnum.TYPE);
		List<FeedResource> batchList = feedResourceService.findResourceByType(FeedResourceEnum.BATCH_NUMBER);
		List<FeedResource> producterList = feedResourceService.findResourceByType(FeedResourceEnum.PRODUCER);
		request.setAttribute("rsList", rsList);
		request.setAttribute("spList", spList);
		request.setAttribute("typeList", typeList);
		request.setAttribute("batchList", batchList);
		request.setAttribute("producterList", producterList);
		return "feed/storage";
	}

	/**
	 * 饲料入库
	 */
	@RequestMapping("/storage")
	public String storage(GodownEntry godownEntry){
		String id = UUID.randomUUID().toString();
		int status = GodownEntryStatus.UNAUDITED.getNumber();
		godownEntry.setId(id);
		godownEntry.setStatus(status);
		feedService.storage(godownEntry);
		return "feed/godownEntryList";
	}
	
}
