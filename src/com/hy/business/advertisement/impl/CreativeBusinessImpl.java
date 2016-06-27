package com.hy.business.advertisement.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.advertisement.ICreativeBusiness;
import com.hy.dao.mybatis.mapper.CreativeMapper;
import com.hy.dao.mybatis.model.Creative;
import com.hy.dao.mybatis.model.CreativeCriteria;
import com.hy.dao.mybatis.model.CreativeCriteria.Criteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;

@Service
public class CreativeBusinessImpl implements ICreativeBusiness{

	@Autowired
	private CreativeMapper creativeMapper;
	
	@Override
	public List<Map<String, Object>> selectCreativeAndPageByAdvertisementid(Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		//查询所有非内置角色
		try {
			
			//广告组id
			Object advertisementGroupidobj = parammap.get("advertisementid");
			if (!CommonUtil.isEmpty(advertisementGroupidobj)) {
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
			creativeMapper.insertSelective(creative);

			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

	@Override
	public Map<String, Object> updateCreative(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			Creative creative = (Creative)ListMapUtil.setEntityValue(map, Creative.class);
			creativeMapper.updateByPrimaryKey(creative);

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
