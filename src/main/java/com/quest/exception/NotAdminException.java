package com.quest.exception;

public class NotAdminException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotAdminException(){
		super("非管理员用户");
	}
	
	public NotAdminException(String msg){
		super(msg);
	}
	
}
