package com.company.gap.feed.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.feed.entity.FeedResource;
import com.company.gap.feed.enumeration.FeedResourceEnum;
import com.company.gap.feed.service.FeedResourceService;

@Controller
@RequestMapping("/feed/resource")
public class FeedResourceController {

	@Autowired
	private FeedResourceService feedResourceService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		int resourceNumber = Integer.valueOf(request.getParameter("resourceNumber"));
		FeedResourceEnum resource = FeedResourceEnum.valueOf(resourceNumber);
		List<FeedResource> resources = feedResourceService.findResourceByType(resource);
		request.setAttribute("resource", resource);
		request.setAttribute("resources", resources);
		return "feed/resource/index";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request){
		//资源名称
		String resourceName = request.getParameter("resourceName");
		int resourceNumber = Integer.valueOf(request.getParameter("resourceNumber"));
		FeedResource resource = new FeedResource(UUID.randomUUID().toString(), resourceName, resourceNumber);
		feedResourceService.add(resource);
		return "redirect:/feed/resource/index.html?resourceNumber=" + resourceNumber;
	}
	
	@RequestMapping("/toEdit")
	public String toEdit(HttpServletRequest request){
		String rid = request.getParameter("rid");
		FeedResource feedResource = feedResourceService.findById(rid);

		int resourceNumber = Integer.valueOf(request.getParameter("resourceNumber"));
		FeedResourceEnum resource = FeedResourceEnum.valueOf(resourceNumber);
		
		request.setAttribute("resource", resource);
		request.setAttribute("feedResource", feedResource);
		return "feed/resource/edit";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request){
		String rid = request.getParameter("rid");
		String resourceName = request.getParameter("resourceName");
		int resourceNumber = Integer.valueOf(request.getParameter("resourceNumber"));
		feedResourceService.edit(rid,resourceName);
		return "redirect:/feed/resource/index.html?resourceNumber=" + resourceNumber;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		String rid = request.getParameter("rid");
		feedResourceService.delete(rid);
		int resourceNumber = Integer.valueOf(request.getParameter("resourceNumber"));
		return "redirect:/feed/resource/index.html?resourceNumber=" + resourceNumber;
	}
}
