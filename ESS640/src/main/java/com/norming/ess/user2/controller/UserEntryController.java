package com.norming.ess.user2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.user1.model.User;
import com.norming.ess.user1.service.IUserService;

@Controller(value="entry2")
@RequestMapping(value="/user2/userEntry")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserEntryController {
	
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/toAdd")
	public String toAdd(HttpServletRequest request) {
		return "user/userEntry/add";
	}

	@RequestMapping(value="/add")
	public String add(User user) {
		userService.addUser(user);
		return "redirect:/user2/userList/findList";
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
		return "redirect:/user2/userList/findList";
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		userService.deleteUser(id);
		return "redirect:/user2/userList/findList";
	}
}
