
package com.quest.web.cookies;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;


/**
 * @author Gansm
 *
 */
public class CookieUtil {
	/**
	 * @Description:默认生命周期
	 */
	public static final int DEFUALT_EXPIRE = 7*24*3600;
	
	/** 
	 * @Description:用户id
	 */  
	public static final String COOKIE_USER_ID = "userId";
	
	/**
	 * @Description:管理员id
	 */
	public static final String COOKIE_ADMIN_ID = "adminId";
	
	public static void writeCookie(HttpServletRequest request, String key, String value, int expire) {

		Assert.notNull(request, "write cookie error. http request cannot be null!");

		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);
		if (jar == null) {
			throw new NullPointerException();
		}
		jar.remove(key);
		jar.set(key, value, expire);
	}

	public static void clearCookie(HttpServletRequest request, String key) {
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);
		if (jar != null) {
			jar.remove(key);
		}
	}
	
	/** 
	 * @Title: clearCookie
	 * @Description: 清空cookie
	 * @author ganshimin@zhongzhihui.com
	 * @param request  
	 */  
	public static void clearCookie(HttpServletRequest request) {
		clearCookie(request,COOKIE_USER_ID);
		clearCookie(request,COOKIE_ADMIN_ID);
	}
	
	/** 
	 * @Title: writeCookieForUser
	 * @Description: 写入用户id到cookie
	 * @author ganshimin@zhongzhihui.com
	 * @param request
	 * @param userId
	 * @param expire  
	 */  
	public static void writeCookieForUser(HttpServletRequest request, String userId, int expire) {
		writeCookie(request, COOKIE_USER_ID, userId, expire);
	}
	
	public static void writeCookieForUser(HttpServletRequest request, String userId) {
		writeCookie(request, COOKIE_USER_ID, userId, DEFUALT_EXPIRE);
	}
	public static void writeCookieForAdmin(HttpServletRequest request, String adminId, int expire) {
		writeCookie(request, COOKIE_ADMIN_ID, adminId, expire);
	}
	
	public static void writeCookieForAdmin(HttpServletRequest request, String adminId) {
		writeCookie(request, COOKIE_ADMIN_ID, adminId, DEFUALT_EXPIRE);
	}
	
	/** 
	 * @Title: getUserId
	 * @Description: 获取userId
	 * @author ganshimin@zhongzhihui.com
	 * @param request
	 * @return  
	 */  
	public static Long getUserId(HttpServletRequest request) {
		if (request == null) {
			throw new IllegalArgumentException();
		}
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);

		if (jar == null) {
			return null;
		}
		String idStr = jar.get(COOKIE_USER_ID);
		if (StringUtils.isNumeric(idStr)) {
			return Long.valueOf(idStr);
		}
		return null;
	}
	public static Long getAdminId(HttpServletRequest request) {
		if (request == null) {
			throw new IllegalArgumentException();
		}
		CookieModule jar = (CookieModule) request.getAttribute(CookieModule.COOKIE);
		
		if (jar == null) {
			return null;
		}
		String idStr = jar.get(COOKIE_ADMIN_ID);
		if (StringUtils.isNumeric(idStr)) {
			return Long.valueOf(idStr);
		}
		return null;
	}
	
	/** 
	 * @Title: isLogin
	 * @Description: 判断是否登录
	 * @author ganshimin@zhongzhihui.com
	 * @param request
	 * @return  
	 */  
	public static boolean isLogin(HttpServletRequest request) {
		Long userId = getUserId(request);
		if (userId != null) {
			return true;
		}
		return false;
	}
	public static boolean isAdminLogin(HttpServletRequest request) {
		Long adminId = getAdminId(request);
		if (adminId != null) {
			return true;
		}
		return false;
	}
	
}
