package com.hy.dao.common.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hy.dao.common.BaseDao;
import com.hy.dao.common.JdbcBaseDao;
import com.hy.dao.common.JdbcBaseSspDao;

/**
 * 所有应用DAO接口可以继承此类，该类提供一些通用操作数据库方面
 * @author linw
 *
 */
public class BaseDaoImpl implements BaseDao {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	/*
	@Autowired
	public HqlBaseDao hqlBaseDao;
	*/
	@Autowired
	public JdbcBaseDao jdbcBaseDao;
	@Autowired
	public JdbcBaseSspDao jdbcBaseSspDao;

	/*
	public HqlBaseDao getHqlBaseDao() {
		return hqlBaseDao;
	}
	*/
	
	public JdbcBaseDao getJdbcBaseDao() {
		return jdbcBaseDao;
	}

	public JdbcBaseSspDao getJdbcBaseSspDao() {
		return jdbcBaseSspDao;
	}
}
