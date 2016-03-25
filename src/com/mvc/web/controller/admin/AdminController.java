package com.mvc.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	Logger log=LoggerFactory.getLogger(AdminController.class);
	/**
	 * 跳转到登陆页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String toLoginPage(HttpServletRequest request) {
		return "admin/login";
	}
	
//	@RequestMapping("login")
//	public String login(HttpServletRequest request) {
//			//return "admin/home";
//	}
}
