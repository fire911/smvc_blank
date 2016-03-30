package com.mvc.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.mvc.web.model.Admin;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	Logger log=LoggerFactory.getLogger(AdminController.class);
	
	@ResponseBody
	@RequestMapping("login")
	public Object login(String username,String password) {
		log.debug("管理员登录："+username);
//		Admin adminObj=JSON.parseObject(admin, Admin.class);
		return null;
	}
//	
//	@RequestMapping("login")
//	public Object login( Admin admin) {
//		log.debug("管理员登录："+admin.getUsername());
//		ModelAndView mav=new ModelAndView("admin/home");
//		mav.addObject("admin", admin);
//		return mav;
//	}
//	多文件上传使用MultipartHttpServletRequest
//	@RequestMapping("upload")
//	public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
//		ModelAndView mav=new ModelAndView("success");
//		String url="";
//		if(!file.isEmpty()){
//			url="/Users/lene/"+System.currentTimeMillis()+file.getOriginalFilename();
//			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(url));
//		}
//		mav.addObject("url",url);
//		return mav;
//	}
}
