package com.quest.exception;

public class PasswordWrongException extends Exception {

	private static final long serialVersionUID = 1L;

	public PasswordWrongException(){
		super("密码错误");
	}
	
	public PasswordWrongException(String msg){
		super(msg);
	}
	
}
