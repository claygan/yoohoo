/**
 * Project Name: zzh-common
 * File Name: ValidateUtils.java
 * Package Name: com.zzh.common.utils
 * Date: 2016-11-15下午3:11:01 
 * Copyright (c) 2016, www.zhongzhihui.com All Rights Reserved. 
 */

package com.quest.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/** 
 * ClassName: ValidateUtils
 * Description: TODO(用一句话描述这个类)
 * 
 * @author wangzhen@zhongzhihui.com
 * @date: 2016-11-15 下午3:11:01
 */
public class ValidateUtils {

	
	/** 
	 * @Title: isMobileNO
	 * @Description: 验证手机号是否合法
	 * @author wangzhen@zhongzhihui.com
	 * @param mobiles
	 * @return  
	 */  
	public static boolean isMobileNO(String mobiles){ 
		if(StringUtils.isBlank(mobiles)){
			return false;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");  
		Matcher m = p.matcher(mobiles);  
		return m.matches();  
	}
	
	/** 
	 * @Title: isQQNo
	 * @Description:验证qq是否合法
	 * @author wangzhen@zhongzhihui.com
	 * @param qq
	 * @return  
	 */  
	public static boolean isQQNo(String qq){
		Pattern p = Pattern.compile("[1-9][0-9]{4,14}");
		Matcher m = p.matcher(qq);
		return m.matches();
	}
	
	/** 
	 * @Title: isEmail
	 * @Description: 验证eMail是否合法
	 * @author wangzhen@zhongzhihui.com
	 * @param email
	 * @return  
	 */  
	public static boolean isEmail(String email){
		if (StringUtils.isBlank(email)) {
			return false;
		}
		Pattern emailP = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher emailM = emailP.matcher(email);
		if (!emailM.matches()) {
			return false;
		}
		return true;
	}
	
	/** 
	 * @Title: isIdentityNum
	 * @Description: 验证身份证是否合法
	 * @author wangzhen@zhongzhihui.com
	 * @param identityNum
	 * @return  
	 */  
	public static boolean isIdentityNum(String identityNum){
		if(StringUtils.isBlank(identityNum)){
			return false;
		}
		Pattern identityP = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
		Matcher identityM = identityP.matcher(identityNum);
		if(!identityM.matches()){
			return false;
		}
		return true;
	}
	
}
