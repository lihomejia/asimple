package com.norming.ess.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.user.domain.User;
import com.norming.ess.user.service.IUserService;

@Controller
@RequestMapping(value="/user/userEntry")
public class UserEntryController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value="/toAdd")
	public String toAdd(HttpServletRequest request) {
		return "user/userEntry/add";
	}

	@RequestMapping(value="/add")
	public String add(User user) {
		userService.addUser(user);
		return "redirect:/user/userList/findList";
	}

	@RequestMapping(value="/toEdit")
	public String toEdit(HttpServletRequest request) {
		String id = request.getParameter("id");
		User user = userService.findUserById(id);
		request.setAttribute("user", user);
		return "user/userEntry/edit";
	}

	@RequestMapping(value="/edit")
	public String edit(User user) {
		userService.editUser(user);
		return "redirect:/user/userList/findList";
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		userService.deleteUser(id);
		return "redirect:/user/userList/findList";
	}
}
