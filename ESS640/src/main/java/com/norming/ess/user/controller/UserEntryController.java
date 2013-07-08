package com.norming.ess.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.user.model.User;
import com.norming.ess.user.service.IUserService;

@Controller
@RequestMapping("user")
public class UserEntryController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/toAdd")
	public String toAdd(HttpServletRequest request) {
		return "user/add";
	}

	@RequestMapping("/add")
	public String add(User user) {
		userService.addUser(user);
		return "redirect:/user/findList";
	}

	@RequestMapping("/toEdit")
	public String toEdit(HttpServletRequest request) {
		String id = request.getParameter("id");
		User user = userService.findUserById(id);
		request.setAttribute("user", user);
		return "user/edit";
	}

	@RequestMapping("/edit")
	public String edit(User user) {
		userService.editUser(user);
		return "redirect:/user/findList";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		userService.deleteUser(id);
		return "redirect:/user/findList";
	}
}
