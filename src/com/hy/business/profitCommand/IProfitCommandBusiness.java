package com.hy.business.profitCommand;

import java.util.Map;

/**
 * 利润控制接口
 * 
 * @author hy
 *
 */
public interface IProfitCommandBusiness {
	
	/**
	 * 查询利润控制数据
	 * @author hy
	 * @date 2016年7月26日下午4:01:39
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectProfitCommand();
	
}
