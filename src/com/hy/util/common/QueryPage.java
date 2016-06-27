package com.hy.util.common;

import java.io.Serializable;

public class QueryPage implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 7290328507994026392L;
	
	// 定义默认每页中显示记录数
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	// 每页记录数
	private int pageSize = DEFAULT_PAGE_SIZE;

	// 总页数
	private int pageCount = 1;

	// 总记录数
	private int recordCount = 0;

	// 目标页
	private int targetPage = 1;
	
	public QueryPage() {
		
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize <= 0) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(int targetPage) {
		if (targetPage <= 0) {
			targetPage = 1;
		}
		this.targetPage = targetPage;
	}
}