package com.hy.util.common;

import java.util.List;

/**
* 创 建 人： zhangyu
* 日     期： 2015年7月29日下午2:36:42
* 描     述：分页信息
* --------------------------------------
* 修 改 人： 
* 日     期： 
* 描     述：  扼要说明修改原因，修改详细请注明到方法级
* --------------------------------------
 */
public class PageInfoUtil<T> {

	private int pagenum;		// 当前页数
	private long rowsCount;		// 总的条数
	private int pagesize;		// 显示条数
	private List<T> list;		// 返回的结果集
	
	public PageInfoUtil(){
	};
	
	public PageInfoUtil(int pagesize, int pagenum) {
		this.pagenum = pagenum;
		this.pagesize = pagesize;
	}
	
	//setter/getter
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public long getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(long rowsCount) {
		this.rowsCount = rowsCount;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	

}
