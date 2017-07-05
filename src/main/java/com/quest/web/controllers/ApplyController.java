package com.quest.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("apply")
public class ApplyController {
	
	@RequestMapping("submit")
	public String applySubmit(HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
}
