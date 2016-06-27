package com.hy.business.user.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.user.IRoleBusiness;
import com.hy.dao.common.impl.BaseDaoImpl;
import com.hy.dao.mybatis.mapper.NavPrivilegeMapper;
import com.hy.dao.mybatis.mapper.RoleMapper;
import com.hy.dao.mybatis.model.NavPrivilege;
import com.hy.dao.mybatis.model.NavPrivilegeCriteria;
import com.hy.dao.mybatis.model.Role;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ListMapUtil;

@Service
public class RoleBUsinessImpl extends BaseDaoImpl  implements IRoleBusiness {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private NavPrivilegeMapper navPrivilegeMapper;

	@Override
	public Map<String, Object> selectRoleinfoByid(Map<String, Object> map) {
		Map<String, Object> returndata = null;
		try {
			if (!CommonUtil.isEmpty(map)) {
				String roleidstr = map.get("id").toString();
				Integer roleid = Integer.parseInt(roleidstr);
				Role role = roleMapper.selectByPrimaryKey(roleid);
				returndata = ListMapUtil.convertEntityToMap(role);
				
				//查询对于的导航信息
				NavPrivilegeCriteria npc = new NavPrivilegeCriteria();
				npc.createCriteria().andRoleidEqualTo(roleid);
				List<NavPrivilege> listnpc = navPrivilegeMapper.selectByExample(npc);
				returndata.put("navs", listnpc);
			}
		} catch (Exception e) {  
			e.printStackTrace();
		}
		return returndata;
	}
}
