package com.hy.business.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hy.dao.mybatis.model.UserRole;

/**
 * 相关权限接口
 * 包括导航权限/功能权限。
 * @author hy
 *
 */
@Service
public interface IPrivilegeBusiness {
	
	/**
	 * 查询用户导航（菜单）权限
	 * map: key  = parentid , 根据父级和角色查询当前导航信息。
	 * @author hy
	 * @date 2016年6月15日下午1:54:26
	 * @param map  参数
	 * @param loginUserid
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectNavByLoginUserid(Map<String, Object> map, Integer userid);

	/**
	 * 查询用户相关的顶级导航并排序
	 * @author hy
	 * @date 2016年6月16日上午10:14:30
	 * @return
	 * @throws Exception 
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAllTopLevel(Integer userid);
	
	/**
	 * 查询用户角色信息
	 * 
	 * 注意：：一个用户有且只有一个角色。
	 * @author hy
	 * @date 2016年6月16日上午10:24:56
	 * @return
	 * @update
	 * @date
	 */
	public UserRole selectUserRoleByuserid(Integer userid);
}
