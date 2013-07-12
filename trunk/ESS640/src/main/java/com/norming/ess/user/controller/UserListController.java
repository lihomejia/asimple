package com.norming.ess.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.user.model.User;
import com.norming.ess.user.service.IUserService;

@Controller
@RequestMapping(value="/user/userList")
public class UserListController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value="/findList")
	public String findList(HttpServletRequest request) {
		List<User> users = userService.findAll();
		request.setAttribute("users", users);
		return "user/userList/list";
	}
}
