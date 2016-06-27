package com.hy.dao.common.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hy.dao.common.JdbcBaseSspDao;
import com.hy.util.common.QueryPage;

/**
 * jdbc base dao impl (ssp)
 * @author linw
 *
 */
@Repository
public class JdbcBaseSspDaoImpl implements JdbcBaseSspDao {
	
	private static final Log log = LogFactory.getLog(JdbcBaseSspDaoImpl.class);
	
	//@Autowired
	@Resource(name = "jdbcTemplateSsp")
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 执行 sql
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public int execute(String sql, Object[] params) {
		return jdbcTemplate.update(sql, params);
		
	}
	
	/**
	 * 查询 list
	 * @param queryPage 分页
	 * @param sql
	 * @param params 参数
	 * @param asName 查询总数量SQL(替换from之前的Sql) 例如 select count(distinct rt) //rt主表别名
	 * @param isRemoveOrderBy 查询总数量SQL 是否删除 order by
	 * @return
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List findList(
			QueryPage queryPage, 
			String sql, 
			Object[] params,
			String asName,
			Boolean isRemoveOrderBy) {
		
		if (queryPage != null) {
			
			if (isRemoveOrderBy == null) {
				isRemoveOrderBy = true;
			}
			
			// 每页记录数
			int pageSize = queryPage.getPageSize();
			
			// 总记录数
			StringBuffer sb = new StringBuffer();
			
			if (StringUtils.isEmpty(asName)) {
				sb.append(" select count(*) ");
			} else {
				sb.append(" select count(distinct " + asName + ") ");
			}
	//		if (isRemoveOrderBy) {
	//			sb.append(this.removeOrders(this.removeSelect(sql)));
	//		} else {
				sb.append(this.removeSelect(sql));
	//		}
			
			int recordCount = this.getCount(sb.toString(), params);
			queryPage.setRecordCount(recordCount);
			
			// 总页数
			int pageCount = recordCount / pageSize;
			if (recordCount % pageSize > 0) {
				pageCount++;
			}
			queryPage.setPageCount(pageCount);
			
			sql = this.getSql(queryPage, sql);
		}
		return jdbcTemplate.queryForList(sql, params);
	}

	/**
	 * 查询 list
	 * @param queryPage 分页
	 * @param sql
	 * @param params 参数
	 * @return
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List findList(
			QueryPage queryPage, 
			String sql, 
			Object[] params) {
		return this.findList(queryPage, sql, params, null, null);
	}

	/**
	 * 查询 list
	 * @param sql
	 * @param params 参数
	 * @return
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List findList(
			String sql, 
			Object[] params) {
		return this.findList(null, sql, params, null, null);
	}
	
	/**
	 * 查询  map
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public Map<?, ?> findMap(
			String sql, 
			Object[] params) {
		try {
			return jdbcTemplate.queryForMap(sql, params);
		} catch (RuntimeException re) {
			log.error("查询失败", re);
			throw re;
		}
	}
	
	/**
	 * 查询 数量
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Long queryForLong(
			String sql, 
			Object[] params) {
		return jdbcTemplate.queryForLong(sql, params);
	}
	
	/**
	 * 查询 数量
	 * @param sql
	 * @param params 参数
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Override
	public int getCount(
			String sql, 
			Object[] params) {
		int count = jdbcTemplate.queryForInt(sql, params);
		return count;
	}
	
	private String getSql(
			QueryPage queryPage, 
			String sql) {
		
		int targetPage = queryPage.getTargetPage();
		int pageSize = queryPage.getPageSize();
		
		int startRow = (targetPage - 1) * pageSize;
	//	int endRow = targetPage * pageSize;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(sql);
		sb.append(" LIMIT " + startRow + "," + pageSize);
		
		return sb.toString();
	}
	
	/**
	 * 去掉SQL语句前面的select
	 * @param sql
	 * @return
	 */
	private String removeSelect(String sql) {
		int beginPos = sql.toLowerCase().indexOf("from");
		return sql.substring(beginPos);
	}	

	/**
	 * 去年SQL语句后面的ORDER BY
	 * @param sql
	 * @return
	 */
	private String removeOrders(String sql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
}
