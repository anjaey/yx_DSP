package com.hy.util.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 处理状态对象[是否操作成功，影响数，主键，错误代码]
 * @author schoff [2015年7月21日]
 */
public class BusinessData<T> { 
	
	private Boolean state = false; // 操作结果
	private Integer rows = null; // 影响行数
	private Integer pk = null; // 主键
	private Integer errorCode = null; // 错误代码
	private Integer pageSize = null; // 每页显示数
	private Integer pageIndex = null; // 当前页数
	private Integer count = null; // 总条数
	private List<T> list = null; // 需要返回的数据，可以是List<对象实体>, 可以是List<Map<String, Object>> map对象
	private T t = null;
	
	
	public BusinessData() {
	}
	
	/**
	 * 用于封装数据更新
	 * @param state
	 * @param infoCode
	 * @param rows
	 * @param pk
	 */
	public BusinessData(Boolean state, Integer errorCode, Integer rows, Integer pk) {
		this.state = state;
		this.errorCode = errorCode;
		this.rows = rows;
		this.pk = pk;
	}

	/**
	 * 用于封装查询指定数据
	 * @param state
	 * @param infoCode
	 * @param rows
	 * @param pk
	 */
	public BusinessData(Boolean state, Integer errorCode,T t) {
		this.state = state;
		this.errorCode = errorCode;
		this.t = t;
	}
	
	/**
	 * 用于返回分页查询
	 * @param pageIndex
	 * @param pageSize
	 * @param count
	 * @param list
	 */
	public BusinessData(Boolean state,Integer pageIndex, Integer pageSize, Integer errorCode , Integer count, List<T> list) {
		this.state = state;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.count = count;
		this.errorCode = errorCode;
		if (list == null || list.size() == 0) {
			this.list = new ArrayList<T>();
		}else {
			this.list = list;
			this.t = list.get(0);
		}
		
	}
	
	
	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @Description		操作是否成功
	 * @author schoff [2015年7月21日]
	 * @return Boolean
	 */
	public Boolean isSuccess() {
		return this.state;
	}
	
	/**
	 * @Description		获取infoCode
	 * @author schoff [2015年7月21日]
	 * @return Integer
	 */
	public Integer getErrorCode() {
		return this.errorCode;
	}
	
	/**
	 * @Description		获取pk主键
	 * @author schoff [2015年7月21日]
	 * @return Integer
	 */
	public Integer getPk() {
		return this.pk;
	}
	
	/**
	 * @Description		获取影响结果数
	 * @author schoff [2015年7月21日]
	 * @return Integer
	 */
	public Integer getRows() {
		return this.rows;
	}
	
	/**
	 * @Description 得到总页数
	 * @author schoff [2015年7月25日]
	 * @return Integer
	 */
	public Integer getCountPage() {
		if (count == null || pageSize == null || pageSize == 0) {
			return 0;
		}else {
			return (count + pageSize - 1) / pageSize;
		}
	}
	
	public List<T> getList() {
		return list;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	

}
