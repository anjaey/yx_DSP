package com.hy.util.common;

/**
 * 只有业务层的一些公共方法/类
 * 包括分页的一些公共方法，不能存在工具类
 * 
 * @Description
 * @author zhangyu [2015年7月24日 下午2:27:12]
 */
public class BusinessUtil {
	
	/**
	 * 得到分页 LimitStart
	 * zhangyu [2015年7月24日 下午2:28:41]
	 * 
	 * @param pagesize 每页显示的条数
	 * @param pageindex 当前页码
	 * @return
	 */
	public static int getLimitStart(int pagesize,int pageindex){
		return (pageindex-1)*pagesize;
	}
	
	/**
	 * 得到分页 LimitEnd
	 * zhangyu [2015年7月24日 下午2:28:41]
	 * 
	 * @param pagesize 每页显示的条数
	 * @param pageindex 当前页码
	 * @return
	 */
	public static int getLimitEnd(int pagesize,int pageindex){
		return pagesize*pageindex;
	}
	
}
