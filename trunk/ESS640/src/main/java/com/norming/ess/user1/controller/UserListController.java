package com.norming.ess.user1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.user1.model.User;
import com.norming.ess.user1.service.IUserService;

@Controller(value="list1")
@RequestMapping(value="/user1/userList")
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
