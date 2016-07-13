package com.hy.business.dict.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.dict.IDictBusiness;
import com.hy.dao.common.JdbcBaseDao;
import com.hy.dao.common.impl.BaseDaoImpl;
import com.hy.dao.mybatis.mapper.DictionaryMapper;
import com.hy.dao.mybatis.model.Dictionary;
import com.hy.dao.mybatis.model.DictionaryCriteria;
import com.hy.dao.mybatis.model.DictionaryCriteria.Criteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;
import com.hy.util.dict.DictKeyMappingUtil;

@Service
public class DictBusinessImpl extends BaseDaoImpl implements IDictBusiness{

	@Autowired
	DictionaryMapper dictionaryMapper;

	@Override
	public List<Map<String, Object>> selectDictByParentid(Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		//查询所有非内置角色
		try {
			DictionaryCriteria dc = new DictionaryCriteria();
			int pagesize = queryPage.getPageSize();
			int pageindex = queryPage.getTargetPage();

			dc.setLimitStart(PageUtil.getStart(pageindex, pagesize));
			dc.setLimitEnd(PageUtil.getEnt(pageindex, pagesize));
			Criteria criteria = dc.createCriteria();

			Object obj = parammap.get("parentid");
			if (CommonUtil.isEmpty(parammap)) {
				obj = 0;
			}
			int parentid = Integer.parseInt(obj.toString());
			criteria.andParentidEqualTo(parentid);

			List<Dictionary> rolelist = dictionaryMapper.selectByExample(dc);
			listmap = ListMapUtil.convertListEntityToListMap(rolelist);

			//统计数量
			int pagecount = dictionaryMapper.countByExample(dc);
			queryPage.setRecordCount(pagecount);

			//总页数
			queryPage.setPageCount(PageUtil.getpagecount(pagecount, pagesize));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listmap;
	}
	
	
	/**
	 * 创建线程安全的得到最新的流水号
	 * @author hy
	 * @date 2016年7月1日下午4:43:36
	 * @param jdbcBaseDao
	 * @return
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	private static synchronized String createDictKeyId(JdbcBaseDao jdbcBaseDao) {
		String keyid = "dd_000";  //默认可以id 
		
		//生成id, 得到最大id
		String sql = "select (CONVERT(substring(key_id, 4, 3), SIGNED) + 1) as nextkeyid from"
				+ " yx_dictionary order by key_id desc limit 1";
		
		List<Map<String, Object>> list = jdbcBaseDao.findList(sql, null);
		
		if (!CommonUtil.isEmpty(list) && list.size() > 0) {
			Object keyidobj = list.get(0);
			if (!CommonUtil.isEmpty(keyidobj)) {
				String keyidstr = keyidobj.toString();
				if (keyidstr.length() == 1) {
					keyid = "dd_00" + keyidobj.toString();
				} else if (keyidstr.length() == 2) {
					keyid = "dd_0" + keyidobj.toString();
				} else if (keyidstr.length() == 3) {
					keyid = "dd_" + keyidobj.toString();
				}
			}
		}
		
		return keyid;
	}
	
	@SuppressWarnings("unchecked")
	private String selectDictKeySon(Integer parentid) {
		String keyid = "dd_00";  //默认可以id 
		
		//查询父级
		Dictionary dict = dictionaryMapper.selectByPrimaryKey(parentid);
		
		if (!CommonUtil.isEmpty(dict)) {
			return null;
		}
		
		//生成id, 得到最大id
		String sql = "select (CONVERT(substring(key_id, 8, 2), SIGNED) + 1) as nextkeyid from "
				+ "yx_dictionary where parentid=" + parentid + " order by key_id desc limit 1";
		
		List<Map<String, Object>> list = this.jdbcBaseDao.findList(sql, null);
		
		if (!CommonUtil.isEmpty(list) && list.size() > 0) {
			Object keyidobj = list.get(0);
			if (!CommonUtil.isEmpty(keyidobj)) {
				String keyidstr = keyidobj.toString();
				if (keyidstr.length() == 1) {
					keyid = "_0" + keyidobj.toString();
				} else if (keyidstr.length() == 2) {
					keyid = "_" + keyidobj.toString();
				}
			}
		}
		
		return dict.getKeyId() + keyid;
	}

	@Override
	public boolean insertDictParent(Map<String, Object> map) {
		try {
			Dictionary dict = (Dictionary)ListMapUtil.setEntityValue(map, Dictionary.class);
			
			String keyid = createDictKeyId(this.jdbcBaseDao);
			dict.setKeyId(keyid);
			
			dictionaryMapper.insertSelective(dict);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean insertDictSon(Map<String, Object> map) {
		try {
			Dictionary dict = (Dictionary)ListMapUtil.setEntityValue(map, Dictionary.class);
			
			String keyid = selectDictKeySon(dict.getParentid());
			
			if (keyid == null) {
				return false;
			}
			
			dict.setKeyId(keyid);
			
			dictionaryMapper.insertSelective(dict);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateDict(Map<String, Object> map) {
		try {
			Dictionary dict = (Dictionary)ListMapUtil.setEntityValue(map, Dictionary.class);
			dictionaryMapper.updateByPrimaryKey(dict);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> selectDiceByKey(String key) {
		Map<String, Object> returnmap = null;
		try {
			key = DictKeyMappingUtil.map.get(key);
			
			DictionaryCriteria dc = new DictionaryCriteria();
			dc.createCriteria().andKeyIdEqualTo(key);

			Dictionary dict = dictionaryMapper.selectByExampleForOne(dc);
			returnmap = ListMapUtil.convertEntityToMap(dict);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}

	@Override
	public List<Map<String, Object>> selectDiceByParent(String key) {
		List<Map<String, Object>> returnlistmap = new ArrayList<Map<String, Object>>();
		try {
			DictionaryCriteria dc = new DictionaryCriteria();
			dc.createCriteria().andKeyIdEqualTo(key);
			Dictionary dict = dictionaryMapper.selectByExampleForOne(dc);
			
			if (CommonUtil.isEmpty(dict)) {
				return returnlistmap;
			}
			
			dc = new DictionaryCriteria();
			dc.createCriteria().andParentidEqualTo(dict.getId());

			List<Dictionary> listdict = dictionaryMapper.selectByExample(dc);

			returnlistmap = ListMapUtil.convertListEntityToListMap(listdict);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnlistmap;
	}
}
