/**
 * Project Name: zzh-cloud-web
 * File Name: CommonInterceptor.java
 * Package Name: com.zzh.cloud.web.interceptors
 * Date: 2015-8-21下午3:47:35 
 * Copyright (c) 2015, www.zhongzhihui.com All Rights Reserved. 
 */

package com.quest.web.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.quest.web.cookies.CookieModule;
import com.quest.web.cookies.CookieModuleConfigurer;
import com.quest.web.cookies.RootContextCookieModule;

/**
 * 初始setCookie
 *
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	private CookieModuleConfigurer cookieModuleConfigurer;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			//set cookie
			CookieModule cookieModule = null;
			if (this.cookieModuleConfigurer != null) {
				cookieModule = new RootContextCookieModule(this.cookieModuleConfigurer.getClientName2CfgMap(), this.cookieModuleConfigurer.getName2CfgMap(), request, response);
			}
			request.setAttribute(CookieModule.COOKIE, cookieModule);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
