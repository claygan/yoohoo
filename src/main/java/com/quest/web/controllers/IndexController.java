package com.quest.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {
	@RequestMapping({"","index"})
	public String toIndex(){
		return "/views/index";
	}
	@RequestMapping("login")
	public String tologinPage(){
		return "/views/login";
	}
	@RequestMapping("class-system")
	public String toClassSystem(){
		return "/views/class-system";
	}
	@RequestMapping("attend-class")
	public String toAttendClass(){
		return "/views/attend-class";
	}
	@RequestMapping("detail")
	public String toDetail(){
		return "/views/detail";
	}
	@RequestMapping("detail-2")
	public String toDetail2(){
		return "/views/detail-2";
	}
}
