package com.quest.entity;

public class ApplyQuery extends PagebleQuery{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 是否联系过（默认查询未联系过）
	 */
	private Integer contacted = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getContacted() {
		return contacted;
	}

	public void setContacted(Integer contacted) {
		this.contacted = contacted;
	}
	
	
}
