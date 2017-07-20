package com.quest.web.common;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
	/**
	 * 存入adminId登录信息
	 * @param request
	 * @param adminId
	 */
	public static void writeSessionForAdmin(HttpServletRequest request, String adminId){
		request.getSession().setAttribute(GlobalDefine.session.USER_SESSION, adminId);
	}
	/**
	 * 移除adminId登录信息
	 */
	public static void clearSessionForAdmin(HttpServletRequest request){
		request.getSession().removeAttribute(GlobalDefine.session.USER_SESSION);
	}
	/**
	 * session判断用户是否登录
	 * @param request
	 * @return
	 */
	public static Boolean isAdminLogin(HttpServletRequest request){
		String result = (String)request.getSession().getAttribute(GlobalDefine.session.USER_SESSION);
		if(result != null){
			return true;
		}else{
			return false;
		}
	}
}
