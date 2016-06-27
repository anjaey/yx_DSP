package com.hy.dao.common;

import java.util.List;
import java.util.Map;

import com.hy.util.common.QueryPage;

/**
 * jdbc base dao
 * @author linw
 *
 */
public interface JdbcBaseDao {
	
	/**
	 * 执行 sql
	 * @param sql
	 * @param params
	 * @return
	 */
	public int execute(String sql, Object[] params);
	
	/**
	 * 查询 list
	 * @param queryPage 分页
	 * @param sql
	 * @param params 参数
	 * @param asName 查询总数量SQL(替换from之前的Sql) 例如 select count(distinct rt) //rt主表别名
	 * @param isRemoveOrderBy 查询总数量SQL 是否删除 order by
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findList(
			QueryPage queryPage, 
			String sql, 
			Object[] params,
			String asName,
			Boolean isRemoveOrderBy);

	/**
	 * 查询 list
	 * @param queryPage 分页
	 * @param sql
	 * @param params 参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findList(
			QueryPage queryPage, 
			String sql, 
			Object[] params);

	/**
	 * 查询 list
	 * @param sql
	 * @param params 参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findList(
			String sql, 
			Object[] params);
	
	/**
	 * 查询  map
	 * @param sql
	 * @param params
	 * @return
	 */
	public Map<?, ?> findMap(
			String sql, 
			Object[] params);
	
	/**
	 * 查询 数量
	 * @param sql
	 * @param params
	 * @return
	 */
	public Long queryForLong(
			String sql, 
			Object[] params);
	
	/**
	 * 查询 数量
	 * @param sql
	 * @param params 参数
	 * @return
	 */
	public int getCount(
			String sql, 
			Object[] params);
}
