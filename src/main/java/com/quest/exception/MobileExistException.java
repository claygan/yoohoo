package com.quest.exception;

public class MobileExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public MobileExistException(){
		super("该手机号码已存在");
	}
	
	public MobileExistException(String msg){
		super(msg);
	}
	
}
