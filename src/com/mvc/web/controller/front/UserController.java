package com.mvc.web.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.web.model.Users;

@Controller
@RequestMapping("/user")
public class UserController {
//	Logger log=Logger.getLogger(UserController.class);
	Logger log=LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, Users user) {
		log.info(request.getParameter("username")+"***********//");
		if ("admin".equals(user.getUsername())
				&& "admin".equals(user.getPassword())) {
			return "front/home";
		} else {
			return "redirect:/";
		}
	}
}