package com.hy.dao.common;

/**
 * 所有应用DAO接口可以继承此类，该类提供一些通用操作数据库方面
 * @author linw
 *
 */
public interface BaseDao {
	
	//public HqlBaseDao getHqlBaseDao();
	
	public JdbcBaseDao getJdbcBaseDao();
}
