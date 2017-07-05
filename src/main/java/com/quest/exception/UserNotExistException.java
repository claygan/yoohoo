package com.quest.exception;

public class UserNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotExistException(){
		super("该用户不存在");
	}
	
	public UserNotExistException(String msg){
		super(msg);
	}
	
}
