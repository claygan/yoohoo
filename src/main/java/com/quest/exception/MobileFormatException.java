package com.quest.exception;

public class MobileFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public MobileFormatException(){
		super("该手机号码格式错误");
	}
	
	public MobileFormatException(String msg){
		super(msg);
	}
	
}
