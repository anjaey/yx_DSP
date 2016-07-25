package com.hy.business.advertisement.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.advertisement.ICreativeBusiness;
import com.hy.dao.common.JdbcBaseDao;
import com.hy.dao.common.impl.BaseDaoImpl;
import com.hy.dao.mybatis.mapper.CreativeMapper;
import com.hy.dao.mybatis.model.Creative;
import com.hy.dao.mybatis.model.CreativeCriteria;
import com.hy.dao.mybatis.model.CreativeCriteria.Criteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.DateUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;

@Service
public class CreativeBusinessImpl extends BaseDaoImpl implements ICreativeBusiness{

	@Autowired
	private CreativeMapper creativeMapper;
	
	@Override
	public List<Map<String, Object>> selectCreativeAndPageByAdvertisementid(Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		//查询所有非内置角色
		try {
			
			//广告id
			Object advertisementGroupidobj = parammap.get("advertisementid");
			if (CommonUtil.isEmpty(advertisementGroupidobj)) {
				return listmap;
			}
			
			int advertisementid = Integer.parseInt(advertisementGroupidobj.toString());
			
			CreativeCriteria cc = new CreativeCriteria();
			int pagesize = queryPage.getPageSize();
			int pageindex = queryPage.getTargetPage();

			//分页参数
			cc.setLimitStart(PageUtil.getStart(pageindex, pagesize));
			cc.setLimitEnd(PageUtil.getEnt(pageindex, pagesize));
			
			//条件
			Criteria criteria = cc.createCriteria();
			criteria.andAdvertisementIdEqualTo(advertisementid);
			
			//创意id， 精准查询。
			Object advertIdobj = parammap.get("advertId");
			if (!CommonUtil.isEmpty(advertIdobj)) {
				criteria.andCreativeAddressEqualTo(advertIdobj.toString());
			}
			
			List<Creative> rolelist = creativeMapper.selectByExample(cc);
			listmap = ListMapUtil.convertListEntityToListMap(rolelist);
			for (Map<String, Object> map : listmap) {
				//处理时间
				String createtimestr = DateUtil.getDateStrByLongObj(map.get("createtime"), DateUtil.YYYY_MM_DD_HH);
				map.put("createtimestr", createtimestr);
			}

			//统计数量
			int pagecount = creativeMapper.countByExample(cc);
			queryPage.setRecordCount(pagecount);

			//总页数
			queryPage.setPageCount(PageUtil.getpagecount(pagecount, pagesize));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listmap;
	}

	@Override
	public Map<String, Object> insertCreative(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			Creative creative = (Creative)ListMapUtil.setEntityValue(map, Creative.class);
			
			//生成创意ID
			String creativeId = createCreativeId(this.jdbcBaseDao);
			creative.setCreativeId(creativeId);
			creativeMapper.insertSelective(creative);

			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}
	
	/**
	 * 创建一个线程安全的方法生成创意id
	 * @author hy
	 * @date 2016年7月1日下午4:40:55
	 * @return
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	private static synchronized String createCreativeId(JdbcBaseDao jdbcBaseDao) {
		String keyid = "ad_00000000";  //默认可以id 
		
		//生成id, 得到最大id
		String sql = "select (CONVERT(substring(creative_id, 5, 9), SIGNED) + 1) as nextkeyid from"
				+ " yx_creative order by creative_id desc limit 1";
		
		List<Map<String, Object>> list = jdbcBaseDao.findList(sql, null);
		
		if (!CommonUtil.isEmpty(list) && list.size() > 0) {
			Object keyidobj = list.get(0);
			if (!CommonUtil.isEmpty(keyidobj)) {
				String keyidstr = keyidobj.toString();
				
				String zero = "ad_";
				for (int i = 0; i < 8 - keyidstr.length(); i++) {
					zero = zero + "0";
				}

				keyid = zero + keyidstr;
			}
		}
		
		return keyid;
	}

	@Override
	public Map<String, Object> updateCreative(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			Creative creative = (Creative)ListMapUtil.setEntityValue(map, Creative.class);
			creativeMapper.updateByPrimaryKeySelective(creative);

			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

	@Override
	public Map<String, Object> selectCreativeByid(Integer id) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			Creative dict = creativeMapper.selectByPrimaryKey(id);
			returnmap = ListMapUtil.convertEntityToMap(dict);
			
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

	@Override
	public Map<String, Object> deleteCreativeByid(List<Integer> id) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			CreativeCriteria cc = new CreativeCriteria();
			cc.createCriteria().andIdIn(id);
			creativeMapper.deleteByExample(cc);

			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}
	
}
