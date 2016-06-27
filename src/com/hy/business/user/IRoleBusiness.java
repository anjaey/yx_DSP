package com.hy.business.user;

import java.util.Map;

import org.springframework.stereotype.Service;


/**
 * 角色接口
 * @author hy
 *
 */
@Service
public interface IRoleBusiness {
	
	/**
	 * 
	 * 根据角色id 查询角色信息
	 * @author hy
	 * @date 2016年5月6日上午11:58:21
	 * @param roleid
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectRoleinfoByid ( Map<String, Object> map);
	
}
