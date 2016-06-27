package com.hy.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.dao.common.ICommonDao;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;

@Service
public class BaseBusiness {

	@Autowired
	protected ICommonDao commonDao;

	// 日志
	protected Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	// 影响行数
	@Deprecated
	protected Integer rows = -1;
	// 主键
	protected Integer primaryKey = -1;
	// 当前页数
	@Deprecated
	protected Integer pageIndex = -1;
	// 每页显示数
	@Deprecated
	protected Integer pageSize = -1;
	// 排序参数
	@Deprecated
	protected String orderParam = "";
	// 排序方式
	@Deprecated
	protected String orderRank = "";
	// 错误代码
	@Deprecated
	protected String errorCode = "0000";
	// 总页数
	@Deprecated
	protected Integer total = -1;
	// 查询返回的数据集合
	@Deprecated
	protected List<Map<String, Object>> list = null;
	// 从 tablename.properties 取出的数据库表名
	public static Map<String, String> tablename = null;
	// 模糊查询
	@Deprecated
	public String fuzzly = "";

	/**
	 * 返回MAP状态值
	 */
	public static final String KEY_STATE = "state";
	/**
	 * 状态码0 服务器错误
	 */
	public static final Integer STATE_ZERO = 0;
	/**
	 * 状态码1 操作成功
	 */
	public static final Integer STATE_ONE = 1;
	/**
	 * 状态码2 操作失败
	 */
	public static final Integer STATE_TWO = 2;
	/**
	 * 状态码3 参数错误(包含无必填参数，参数类型不匹配)
	 */
	public static final Integer STATE_THREE = 3;
	
	

	/**
	 * @author: 林
	 * @date: 2015年9月1日下午5:37:54
	 * @description: 拼装分页LIMIT
	 * @return <br>
	 *         -----------------------------<br>
	 * @update:
	 * @date:
	 * @description: (注明修改原因) <br>
	 *               -----------------------------<br>
	 */
	@Deprecated
	protected String limit() {
		String str = " limit ";
		if (pageSize > 0 && pageIndex > 0) {
			str += ((pageIndex - 1) * pageSize) + ", " + pageSize;
		}
		return str;
	}

	/**
	 * @author: 林
	 * @date: 2015年9月1日下午5:37:36
	 * @description: 初始化查询需要的参数
	 * @param map
	 * @throws ClassCastException
	 *             <br>
	 *             -----------------------------<br>
	 * @update:
	 * @date:
	 * @description: (注明修改原因) <br>
	 *               -----------------------------<br>
	 */
	@Deprecated
	public void init(Map<String, Object> map) throws ClassCastException {
		pageIndex = map.get("pageIndex") == null ? -1 : (Integer) map.get("pageIndex");
		pageSize = map.get("pageSize") == null ? -1 : (Integer) map.get("pageSize");
		orderParam = (String) map.get("orderParam");
		orderRank = (String) map.get("orderRank");
		fuzzly = (String) map.get(ConstantUtil.RESULT_FUZZY) == null ? "" : (String) map.get(ConstantUtil.RESULT_FUZZY);
	}

	/**
	 * @author: 林
	 * @date: 2015年9月1日下午5:37:17
	 * @description: 重置基础业务层中所有数据 <br>
	 *               -----------------------------<br>
	 * @update:
	 * @date:
	 * @description: (注明修改原因) <br>
	 *               -----------------------------<br>
	 */
	@Deprecated
	public void reset() {
		rows = -1;
		primaryKey = -1;
		pageIndex = -1;
		pageSize = -1;
		orderParam = "";
		orderRank = "";
		errorCode = "0000";
		total = -1;
		list = null;
	}

	/**
	 * @author: 林
	 * @date: 2015年9月1日下午5:32:05
	 * @description: 获取map中的参数值
	 * @param map
	 * @return <br>
	 *         -----------------------------<br>
	 * @update:
	 * @date:
	 * @description: (注明修改原因) <br>
	 *               -----------------------------<br>
	 */
	@Deprecated
	public List<Object> getParam(Map<String, Object> map) {
		List<Object> list = new ArrayList<Object>();
		for (String key : map.keySet()) {
			if (map.get(key) != null && !"".equals(map.get(key)) && compareKey(key)) {
				list.add(map.get(key));
			}
		}
		return list;
	}

	/**
	 * @author: 林
	 * @date: 2015年9月1日下午5:32:20
	 * @description: 获取查询sql
	 * @param map
	 *            参数
	 * @param entitynam
	 *            tablename.properties 中实体名字
	 * @return <br>
	 *         -----------------------------<br>
	 * @update:
	 * @date:
	 * @description: (注明修改原因) <br>
	 *               -----------------------------<br>
	 */
	@Deprecated
	public String getSql(Map<String, Object> map, String entityname) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from " + tablename.get(entityname) + " where 1 = 1");
		for (String key : map.keySet()) {
			if (map.get(key) != null && !"".equals(map.get(key)) && compareKey(key)) {
				if (Arrays.asList(fuzzly.split(",")).contains(key)) {
					sql.append(" and " + key + " like '%' ? '%' ");
				} else {
					sql.append(" and " + key + "= ? ");
				}
			}
		}

		/* 排序 */
		if (orderParam != null && !"".equals(orderParam.trim())) {
			sql.append(" order by " + orderParam + " " + orderRank);
		}

		if (pageIndex > 0 && pageSize > 0) {
			sql.append(limit());
		}
		log.debug(sql.toString());
		return sql.toString();
	}

	/**
	 * @author: 林
	 * @date: 2015年9月2日上午11:37:32
	 * @description: 比较key中是否包含了某些值[pageIndex,pageSize,orderpParam,orderRank,fuzzy_query]
	 * @param key
	 * @return 包含返回false,不包含返回true <br>
	 *         -----------------------------<br>
	 * @update:
	 * @date:
	 * @description: (注明修改原因) <br>
	 *               -----------------------------<br>
	 */
	@Deprecated
	private boolean compareKey(String key) {
		if (key != ConstantUtil.RESULT_PAGEINDEX && key != ConstantUtil.RESULT_PAGESIZE && key != ConstantUtil.RESULT_ORDERPARAM && key != ConstantUtil.RESULT_ORDERRANK
				&& key != ConstantUtil.RESULT_FUZZY) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 处理sql
	 * 
	 * @author 林
	 * @date 2015年9月7日下午2:19:24
	 * @param dataMap
	 *            需要处理的参数Map
	 * @param sql
	 *            处理后的sql
	 * @param paramsList
	 *            处理后的参数
	 * @param likeParams
	 *            需要模糊查询的字段
	 * @throws Exception
	 * @update
	 * @date
	 */
	protected void handleSql(Map<String, Object> dataMap, StringBuffer sql, List<Object> paramsList, String likeParams) throws Exception {
		handleParams(dataMap, sql, paramsList, likeParams);
		if (dataMap.containsKey("orderBy")) {
			handleOrderSql(dataMap, sql, paramsList);
		}
		if (dataMap.containsKey("pageIndex") && dataMap.containsKey("pageSize")) {
			handlePageSql(dataMap, sql, paramsList);
		}
	}

	/**
	 * 普通参数的sql拼接(内部使用)
	 * 
	 * @author 林
	 * @date 2015年9月7日下午2:30:21
	 * @param paramsMap
	 *            需要处理的参数Map
	 * @param sql
	 *            处理后的sql
	 * @param paramsList
	 *            处理后的参数
	 * @param likeStrs
	 *            需要模糊查询的字段
	 * @throws Exception
	 * @update
	 * @date 修改方法为私有
	 */
	private void handleParams(Map<String, Object> paramsMap, StringBuffer sql, List<Object> paramsList, String likeStrs) throws Exception {
		if (!CommonUtil.isEmpty(paramsMap)) {
			List<String> likeList = ListMapUtil.splitStrToList(likeStrs, ",");

			String whereStr = " where 1 = 1 ";
			sql.append(whereStr);

			Iterator<Entry<String, Object>> iterator = paramsMap.entrySet().iterator();
			int count = 0;
			while (iterator.hasNext()) {
				Entry<String, Object> next = iterator.next();
				String key = next.getKey();
				Object value = next.getValue();

				if (!key.equals("pageIndex") && !key.equals("pageSize") && !key.equals("orderBy")) {
					count++;
					if (likeList.contains(key)) {
						sql.append(" and ").append(key).append(" like ").append(" '%'?'%' ");
					} else {
						sql.append(" and ").append(key).append(" = ").append(" ? ");
					}
					paramsList.add(value);
				}
			}

			if (count > 0) {
				int whereIndex = sql.indexOf(whereStr);
				sql.substring(whereIndex + 1, sql.length());
			}
		}
	}

	/**
	 * 排序的sql拼接(内部使用)
	 * 
	 * @author 林
	 * @date 2015年9月7日下午2:32:16
	 * @param paramsMap
	 *            需要处理的参数Map
	 * @param sql
	 *            处理后的sql
	 * @param paramsList
	 *            处理后的参数
	 * @update
	 * @date 修改方法为私有
	 */
	private void handleOrderSql(Map<String, Object> paramsMap, StringBuffer sql, List<Object> paramsList) {
		if (paramsMap.containsKey("orderBy")) {
			sql.append(" order by ").append(" ? ");
			paramsList.add(paramsMap.get("orderBy"));
		}
	}

	/**
	 * 分页的sql拼接(内部使用)
	 * 
	 * @author 林
	 * @date 2015年9月7日下午2:32:16
	 * @param paramsMap
	 *            需要处理的参数Map
	 * @param sql
	 *            处理后的sql
	 * @param paramsList
	 *            处理后的参数
	 * @update
	 * @date 修改方法为私有
	 */
	private void handlePageSql(Map<String, Object> paramsMap, StringBuffer sql, List<Object> paramsList) throws Exception {
		if (paramsMap.containsKey("pageIndex") && paramsMap.containsKey("pageSize")) {
			Integer pageIndex = Integer.parseInt(paramsMap.get("pageIndex").toString());
			Integer pageSize = Integer.parseInt(paramsMap.get("pageSize").toString());

			sql.append(" limit ").append(" ?,? ");
			paramsList.add(PageUtil.getStart(pageIndex, pageSize));
			paramsList.add(pageSize);
		}
	}

	public static void main(String[] args) throws Exception {
		StringBuffer sql = new StringBuffer(" select * from sys_user");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		List<Object> paramsList = new ArrayList<Object>();
		BaseBusiness baseBusiness = new BaseBusiness();

		paramsMap.put("userName", "sdfdsf");
		paramsMap.put("status", "1");
		paramsMap.put("title", "地地");
		paramsMap.put("pageIndex", 2);
		paramsMap.put("pageSize", 20);
		paramsMap.put("orderBy", "createTime desc");

		baseBusiness.handleSql(paramsMap, sql, paramsList, "userName");
		
		System.err.println(sql.toString());
		System.err.println(paramsList);
	}
}
