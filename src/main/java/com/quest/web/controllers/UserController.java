package com.quest.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quest.entity.User;
import com.quest.exception.NotAdminException;
import com.quest.exception.PasswordWrongException;
import com.quest.exception.UserNotExistException;
import com.quest.service.UserService;
import com.quest.web.common.ApiResult;
import com.quest.web.common.GlobalDefine;
import com.quest.web.cookies.CookieUtil;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
	@SuppressWarnings({ "rawtypes"})
	@RequestMapping("login")
	@ResponseBody
	public ApiResult login(HttpServletRequest request,HttpServletResponse response, User user){
		ApiResult result = new ApiResult(); 
		try {
			if(user == null || user.getUsername().isEmpty() || user.getPassword().isEmpty()){
				throw new UserNotExistException("参数错误");
			}
			User resultUser = userService.adminLogin(user);
			//管理员成功登录，存入cookie
			CookieUtil.writeCookieForAdmin(request, ""+resultUser.getId());
			result.setMsg("登录成功");
			result.setError(GlobalDefine.resultCode.SUCCESS);
		} catch (UserNotExistException e) {
			result.setError(GlobalDefine.resultCode.LOGIN_ERROR);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		} catch (PasswordWrongException e) {
			result.setError(GlobalDefine.resultCode.LOGIN_ERROR);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		} catch (NotAdminException e) {
			result.setError(GlobalDefine.resultCode.LOGIN_ERROR);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		} catch (Exception e){
			result.setError(GlobalDefine.resultCode.INTERNAL_ERROR);
			result.setMsg("系统异常");
			e.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("logout")
	@ResponseBody
	public ApiResult logout(HttpServletRequest request, HttpServletResponse response){
		ApiResult result = new ApiResult(); 
		CookieUtil.clearCookie(request);
		result.setMsg("登出成功！");
		return result;
	}
	
}
