package com.quest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.quest.dao.UserMapper;
import com.quest.entity.User;
import com.quest.exception.NotAdminException;
import com.quest.exception.PasswordWrongException;
import com.quest.exception.UserNotExistException;
import com.quest.service.UserService;
import com.quest.utils.MD5Util;

@Service("userService")
public class UserSeviceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User login(User user) throws UserNotExistException, PasswordWrongException {
		try {
			if (user == null) {
				throw new UserNotExistException("输入用户为空");
			}
			User resultUser = userMapper.selectByUsername(user.getUsername());
			//验证用户是否存在
			if (resultUser == null) {
				throw new UserNotExistException();
			}
			//验证用户输入密码是否正确
			String encodePwd = MD5Util.getMD5FormatWithSalt(user.getPassword(), resultUser.getSalt());
			if (!encodePwd.equals(resultUser.getPassword())) {
				throw new PasswordWrongException();
			} 
			return resultUser;
		} catch (UserNotExistException e) {
			throw e;
		} catch (PasswordWrongException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User adminLogin(User user) throws UserNotExistException, PasswordWrongException, NotAdminException {
		try {
			if (user == null) {
				throw new UserNotExistException("输入用户为空");
			}
			User resultUser = userMapper.selectByUsername(user.getUsername());
			//验证用户是否存在
			if (resultUser == null) {
				throw new UserNotExistException();
			}
			//检查是否是管理员用户
			if(!"1".equals(resultUser.getIsAdmin())){
				throw new NotAdminException();
			}
			//验证用户输入密码是否正确
			String encodePwd = MD5Util.getMD5FormatWithSalt(user.getPassword(), resultUser.getSalt());
			if (!encodePwd.equals(resultUser.getPassword())) {
				throw new PasswordWrongException();
			} 
			return resultUser;
		} catch (UserNotExistException e) {
			throw e;
		} catch (NotAdminException e) {
			throw e;
		} catch (PasswordWrongException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
