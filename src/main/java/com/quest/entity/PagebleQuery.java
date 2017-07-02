package com.quest.entity;

import java.io.Serializable;

public class PagebleQuery implements Serializable {

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
	private long records;

	/**
	 * @Description:总页数
	 */
	private int total;

	/**
	 * @Description:排序
	 */
	private String orderBy;
	

	public long getStartOffset() {
		if (records % pageSize == 0) {
			total = (int)(records / pageSize);
		} else {
			total = (int)(records / pageSize + 1);
		}
		long startOffset = (page - 1) * pageSize;
		return startOffset;
	}


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


	public long getRecords() {
		return records;
	}


	public void setRecords(long records) {
		this.records = records;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getOrderBy() {
		return orderBy;
	}


	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
