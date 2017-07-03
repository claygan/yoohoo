package com.quest.service;

import com.quest.entity.User;
import com.quest.exception.NotAdminException;
import com.quest.exception.PasswordWrongException;
import com.quest.exception.UserNotExistException;

public interface UserService {
	User login(User user) throws UserNotExistException,PasswordWrongException;
	
	User adminLogin(User user) throws UserNotExistException,PasswordWrongException,NotAdminException;
}
