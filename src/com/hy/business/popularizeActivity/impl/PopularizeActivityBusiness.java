package com.hy.business.popularizeActivity.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.business.popularizeActivity.IPopularizeActivityBusiness;
import com.hy.dao.common.impl.BaseDaoImpl;
import com.hy.dao.mybatis.mapper.PopularizeActivityMapper;
import com.hy.dao.mybatis.model.PopularizeActivity;
import com.hy.dao.mybatis.model.PopularizeActivityCriteria;
import com.hy.dao.mybatis.model.PopularizeActivityCriteria.Criteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.DateUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;

@Service
public class PopularizeActivityBusiness extends BaseDaoImpl implements IPopularizeActivityBusiness{

	@Autowired
	PopularizeActivityMapper popularizeActivityMapper;

	/**
	 * 分页查询推广活动
	 * 
	 * @author hy
	 * @date 2016年6月17日下午3:38:04
	 * @param parammap 
	 * starttime 开始时间
	 * endtime 结束时间
	 * name 活动名称
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	@Override
	public List<Map<String, Object>> selectActivityAndPage(Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		
		try {
			PopularizeActivityCriteria pac = new PopularizeActivityCriteria();
			pac.setOrderByClause(" createTime desc");
			Criteria criteria = pac.createCriteria();
			
			//开始日期
			Object starttimeobj = parammap.get("starttime");
			if (!CommonUtil.isEmpty(starttimeobj)) {
				String starttimestr = starttimeobj.toString();
				Date starttime = DateUtil.str2Date(starttimestr);
				long start = starttime.getTime();
				criteria.andStartTimeEqualTo(start);
			}

			//开始日期
			Object endtimeobj = parammap.get("endtime");
			if (!CommonUtil.isEmpty(endtimeobj)) {
				String endtimestr = endtimeobj.toString();
				Date endtime = DateUtil.str2Date(endtimestr);
				long end = endtime.getTime();
				criteria.andStartTimeEqualTo(end);
			}

			//活动名称
			Object nameobj = parammap.get("name");
			if (!CommonUtil.isEmpty(nameobj)) {
				criteria.andNameEqualTo(nameobj.toString());
			}
			
			
			int pagesize = queryPage.getPageSize();
			int pageindex = queryPage.getTargetPage();
			pac.setLimitStart(PageUtil.getStart(pageindex, pagesize));
			pac.setLimitEnd(PageUtil.getEnt(pageindex, pagesize));
			
			List<PopularizeActivity>  listpop = popularizeActivityMapper.selectByExample(pac);
			listmap = ListMapUtil.convertListEntityToListMap(listpop);
			
			for (Map<String, Object> map : listmap) {
				//状态, 暂无。
				
				//时间
				Object createTimeobj = map.get("createTime");
				String createTimestr = DateUtil.getDateStrByLongObj(createTimeobj, DateUtil.YYYY_MM_DD);
				map.put("createTime", createTimestr);
				
				//推广日期。
				//开始
				Object startTimeobj = map.get("createTime");
				String startTimestr = DateUtil.getDateStrByLongObj(startTimeobj, DateUtil.YYYY_MM_DD);
				
				//结束	
				Object endTimeobj = map.get("createTime");
				String endTimestr = DateUtil.getDateStrByLongObj(endTimeobj, DateUtil.YYYY_MM_DD);
				map.put("promotionTime", startTimestr + "~" + endTimestr);
				
			}
			
			//统计数量
			int pagecount = popularizeActivityMapper.countByExample(pac);
			queryPage.setRecordCount(pagecount);

			//总页数
			queryPage.setPageCount(PageUtil.getpagecount(pagecount, pagesize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return listmap;
	}

	@Override
	public Map<String, Object> insertActivity(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			PopularizeActivity pa = (PopularizeActivity)ListMapUtil.setEntityValue(map, PopularizeActivity.class);
			popularizeActivityMapper.insertSelective(pa);

			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

	@Override
	public Map<String, Object> updateActivity(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			PopularizeActivity pa = (PopularizeActivity)ListMapUtil.setEntityValue(map, PopularizeActivity.class);
			popularizeActivityMapper.updateByPrimaryKey(pa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}

	@Override
	public Map<String, Object> selectActivityByid(Integer id) {
		Map<String, Object> returnmap = null;
		try {
			PopularizeActivity pa = popularizeActivityMapper.selectByPrimaryKey(id);
			
			returnmap = ListMapUtil.convertEntityToMap(pa);
			
			//推广日期。
			//开始
			Object startTimeobj = returnmap.get("createTime");
			String startTimestr = DateUtil.getDateStrByLongObj(startTimeobj, DateUtil.YYYY_MM_DD);
			
			//结束	
			Object endTimeobj = returnmap.get("createTime");
			String endTimestr = DateUtil.getDateStrByLongObj(endTimeobj, DateUtil.YYYY_MM_DD);
			returnmap.put("promotionTime", startTimestr + "~" + endTimestr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}

	@Override
	public List<Map<String, Object>> selectActivity(Map<String, Object> parammap) {
		PopularizeActivityCriteria pac = new PopularizeActivityCriteria();
		
		List<Map<String, Object>> listmap = null;
		try {
			List<PopularizeActivity>  listpop = popularizeActivityMapper.selectByExample(pac);
			
			listmap = ListMapUtil.convertListEntityToListMap(listpop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listmap;
	}
}
