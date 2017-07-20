package com.quest.web.common;

public class GlobalDefine {
	
	public static class session{
		/**
		 * 用户信息键值
		 */
		public static final String USER_SESSION = "USER_SESSION";
	}
	
	/** 
	 * @ClassName: resultCode
	 * @Description:返回状态码规范
	 * 
	 * @author ganshimin@zhongzhihui.com
	 * @date: 2017年3月29日 下午2:33:45
	 */  
	public static class resultCode {
		/** 
		 * @Description:返回成功
		 */  
		public static final int SUCCESS = 0;
		/** 
		 * @Description:后端接口未知错误
		 */  
		public static final int INTERNAL_ERROR = 1;
		/** 
		 * @Description:页面跳转响应
		 */  
		public static final int REDIRECT_ERROR = 2;
		/** 
		 * @Description:登录异常 
		 */  
		public static final int LOGIN_ERROR = -100;
		/** 
		 * @Todo:业务状态码扩展从100开始
		 */
		
	}
}
