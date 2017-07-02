package com.quest.entity;

import java.io.Serializable;
import java.util.List;

public class Pageble<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 
	 * @Description:默认记录数
	 */  
	public static final int DEFAULT_PAGE_SIZE = 10;

	/** 
	 * @Description:每页的记录数
	 */  
	private int pageSize = DEFAULT_PAGE_SIZE;

	/** 
	 * @Description:当前页
	 */  
	private int page = 1;

	/** 
	 * @Description:总行数
	 */  
	private int records;

	/** 
	 * @Description:总页数
	 */  
	private int total;

	/** 
	 * @Description:每页的记录
	 */  
	private List<T> rows;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
