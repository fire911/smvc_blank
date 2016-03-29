package com.mvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.web.model.Admin;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	Logger log=LoggerFactory.getLogger(AdminController.class);
	
//	@ResponseBody
//	@RequestMapping("login")
//	public Object login(@RequestBody Admin admin) {
//		log.debug("管理员登录："+admin.getUsername());
//		return admin;
//	}
	
	@RequestMapping("login")
	public Object login( Admin admin) {
		log.debug("管理员登录："+admin.getUsername());
		ModelAndView mav=new ModelAndView("admin/home");
		mav.addObject("admin", admin);
		return mav;
	}
}
