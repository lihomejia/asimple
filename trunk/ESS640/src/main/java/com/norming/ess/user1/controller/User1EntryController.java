package com.norming.ess.user1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.user1.model.User;
import com.norming.ess.user1.service.IUserService;

@Controller
@RequestMapping(value="/user1/userEntry")
public class User1EntryController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value="/toAdd")
	public String toAdd(HttpServletRequest request) {
		return "user1/userEntry/add";
	}

	@RequestMapping(value="/add")
	public String add(User user) {
		userService.addUser(user);
		return "redirect:/user1/userList/findList";
	}

	@RequestMapping(value="/toEdit")
	public String toEdit(HttpServletRequest request) {
		String id = request.getParameter("id");
		User user = userService.findUserById(id);
		request.setAttribute("user", user);
		return "user1/userEntry/edit";
	}

	@RequestMapping(value="/edit")
	public String edit(User user) {
		userService.editUser(user);
		return "redirect:/user1/userList/findList";
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		userService.deleteUser(id);
		return "redirect:/user1/userList/findList";
	}
}
