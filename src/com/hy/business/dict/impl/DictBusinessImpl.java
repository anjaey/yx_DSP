package com.hy.business.dict.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.dict.IDictBusiness;
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
			criteria.andIsdeleteEqualTo(1);

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

	@Override
	public Map<String, Object> selectDiceByKey(String key) {
		Map<String, Object> returnmap = null;
		try {
			key = DictKeyMappingUtil.map.get(key);
			
			DictionaryCriteria dc = new DictionaryCriteria();
			Criteria criteria = dc.createCriteria();
			criteria.andKeyIdEqualTo(key);
			criteria.andIsdeleteEqualTo(1);

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
			Criteria criteria = dc.createCriteria();
			criteria.andParentidEqualTo(dict.getId());
			criteria.andIsdeleteEqualTo(1);
			
			List<Dictionary> listdict = dictionaryMapper.selectByExample(dc);

			returnlistmap = ListMapUtil.convertListEntityToListMap(listdict);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnlistmap;
	}
}
