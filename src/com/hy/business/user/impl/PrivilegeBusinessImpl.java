package com.hy.business.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.user.IPrivilegeBusiness;
import com.hy.dao.mybatis.mapper.NavPrivilegeMapper;
import com.hy.dao.mybatis.mapper.NavigationMapper;
import com.hy.dao.mybatis.mapper.UserRoleMapper;
import com.hy.dao.mybatis.model.NavPrivilege;
import com.hy.dao.mybatis.model.NavPrivilegeCriteria;
import com.hy.dao.mybatis.model.NavPrivilegeCriteria.Criteria;
import com.hy.dao.mybatis.model.Navigation;
import com.hy.dao.mybatis.model.NavigationCriteria;
import com.hy.dao.mybatis.model.UserRole;
import com.hy.dao.mybatis.model.UserRoleCriteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ListMapUtil;

/**
 * 用户权限相关
 * 包括导航权限/功能权限信息。
 * @author hy
 *
 */
@Service
public class PrivilegeBusinessImpl implements IPrivilegeBusiness{

	@Autowired
	private NavPrivilegeMapper navPrivilegeMapper;
	@Autowired
	private NavigationMapper navigationMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
	 * 查询用户导航（菜单）权限
	 * map: key  = parentid , 根据父级和角色查询当前导航信息。
	 * @author hy
	 * @date 2016年6月15日下午1:54:26
	 * @param map  参数  为NULL查询所有导航， 包括顶级导航
	 * @param loginUserid
	 * @return  子级保存到map 里面： key: sonnav 
	 * @update
	 * @date
	 */
	@Override
	public List<Map<String, Object>> selectNavByLoginUserid(Map<String, Object> map, Integer userid) {
		List<Map<String, Object>> listmapnav = new ArrayList<Map<String, Object>>();

		//顶级导航父级为0
		Integer parentid = 0; 
		if (!CommonUtil.isEmpty(map)) {  //如果存在， 根据父级查询导航信息。
			Object parentidobj = map.get("parentid");
			if (!CommonUtil.isEmpty(parentidobj)) {
				parentid = Integer.parseInt(parentidobj.toString());
			}
		}

		//查询用户角色, 注意，此处的 角色为内直角色， 默认有所有前台的导航权限。
		UserRole userrole = selectUserRoleByuserid(userid);

		if (!CommonUtil.isEmpty(userrole)) {
			try {
				List<Navigation> listnavinfo = selectNavInfoByParentid(parentid, userrole.getRoleid());

				listmapnav = ListMapUtil.convertListEntityToListMap(listnavinfo);

				selectNavByLoginUseridAndparentNavid(parentid, userrole.getRoleid(), listmapnav);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listmapnav;
	}

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
	@Override
	public UserRole selectUserRoleByuserid(Integer userid) {
		//查询用户角色
		UserRoleCriteria urc = new UserRoleCriteria();
		urc.createCriteria().andUseridEqualTo(userid);
		UserRole userrole = userRoleMapper.selectByExampleForOne(urc);
		return userrole;
	}

	/**
	 * 根据 登录用户角色， 父级id 查询这个角色的导航信息（权限信息）
	 * 
	 * @author hy
	 * @date 2016年6月16日上午10:19:15
	 * @param parentid
	 * @param roleid
	 * @return
	 * @update
	 * @date
	 */
	private List<Navigation> selectNavInfoByParentid(Integer parentid, Integer roleid) {
		List<Navigation> listnavinfo = null;

		NavPrivilegeCriteria npc = new NavPrivilegeCriteria();
		Criteria criteria = npc.createCriteria();
		criteria.andParentidEqualTo(parentid);
		criteria.andRoleidEqualTo(roleid);

		List<NavPrivilege> listnavPrivilege = navPrivilegeMapper.selectByExample(npc);

		List<Integer> listnavid = new ArrayList<Integer>();
		for (NavPrivilege navPrivilege : listnavPrivilege) {
			listnavid.add(navPrivilege.getNavid());
		}

		if (!CommonUtil.isEmpty(listnavPrivilege) && listnavPrivilege.size() > 0) {
			NavigationCriteria nc = new NavigationCriteria();
			nc.createCriteria().andIdIn(listnavid);
			listnavinfo = navigationMapper.selectByExample(nc);
		}



		return listnavinfo;
	}

	/**
	 * 根据用户角色id， 父级导航id，
	 * 查询用户导航权限信息
	 * 
	 * 递归查询所有子级
	 * 
	 * @author hy
	 * @throws Exception 
	 * @date 2016年6月15日下午2:54:01
	 * @update
	 * @date
	 */
	private List<Map<String, Object>> selectNavByLoginUseridAndparentNavid(Integer parentid, Integer userRoleid, List<Map<String, Object>> listmapinfo) throws Exception{
		//查询权限信息
		for (Map<String, Object> navigation : listmapinfo) {
			List<Navigation> listnavinfo = selectNavInfoByParentid(
					Integer.parseInt(navigation.get("id").toString()), userRoleid);

			List<Map<String, Object>> listmap = ListMapUtil.convertListEntityToListMap(listnavinfo);
			try {
				//查询子级 
				if (parentid != 0) {
					navigation.put("sonnav", listmap);
				} else {
					navigation.put("sonnav", selectNavByLoginUseridAndparentNavid(
							Integer.parseInt(navigation.get("id").toString()), userRoleid, listmap));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listmapinfo;
	}

	/**
	 * 查询用户相关的顶级导航并排序
	 * @author hy
	 * @date 2016年6月16日上午10:14:30
	 * @return
	 * @throws Exception 
	 * @update
	 * @date
	 */
	@Override
	public List<Map<String, Object>> selectAllTopLevel(Integer userid) {
		try {
			//查询用户角色
			UserRole userrole = selectUserRoleByuserid(userid);

			if (!CommonUtil.isEmpty(userrole)) {
				List<Navigation> listnav = selectNavInfoByParentid(0, userrole.getRoleid());
				List<Map<String, Object>> listmap = ListMapUtil.convertListEntityToListMap(listnav);
				return listmap;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
