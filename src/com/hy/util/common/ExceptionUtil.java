package com.hy.util.common;

/**
 * 异常组合
 *
 * @author 张宇 2014年9月25日 上午10:32:50
 * <ul>
 * 	<li>张宇 2014年9月25日 上午10:32:50新增</li>
 * </ul>
 * @version 0.0.1
 */
public class ExceptionUtil {
	
	/**
	 * 拼接异信息
	 *
	 * @author 张宇 2014年9月25日 下午3:44:32
	 * <ul>
	 * 	<li>张宇 2014年9月25日 下午3:44:32新增</li>
	 * </ul>
	 * @param excName  异常模块
	 * @param type   异常错误类型
	 * @return
	 * @version 0.0.1
	 */
	public static String getFailException(String excName,String type){
		StringBuffer sb = new StringBuffer();
		sb.append(excName).append(type);
		return sb.toString();
	}
}
