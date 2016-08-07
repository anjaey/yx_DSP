package com.hy.business.popularizeActivity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.business.popularizeActivity.IPopularizeActivityBusiness;
import com.hy.dao.common.JdbcBaseDao;
import com.hy.dao.common.impl.BaseDaoImpl;
import com.hy.dao.mybatis.mapper.AdvertisementBasicMapper;
import com.hy.dao.mybatis.mapper.CreativeMapper;
import com.hy.dao.mybatis.mapper.PopularizeActivityMapper;
import com.hy.dao.mybatis.model.AdvertisementBasic;
import com.hy.dao.mybatis.model.AdvertisementBasicCriteria;
import com.hy.dao.mybatis.model.Creative;
import com.hy.dao.mybatis.model.CreativeCriteria;
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
	@Autowired
	AdvertisementBasicMapper advertisementBasicMapper;
	@Autowired
	CreativeMapper creativeMapper;

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
	public List<Map<String, Object>> selectActivityAndPage(Map<String, Object> parammap, QueryPage queryPage, Integer createuserid) {
		List<Map<String, Object>> listmap = null;

		try {
			PopularizeActivityCriteria pac = new PopularizeActivityCriteria();
			pac.setOrderByClause(" create_time desc");
			Criteria criteria = pac.createCriteria();

			//这个用户创建的
			criteria.andCreateUserEqualTo(createuserid);

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
				Object createTimeobj = map.get("createtime");
				String createTimestr = DateUtil.getDateStrByLongObj(createTimeobj, DateUtil.YYYY_MM_DD);
				map.put("createtime", createTimestr);

				//推广日期。
				//开始
				Object startTimeobj = map.get("starttime");
				String startTimestr = DateUtil.getDateStrByLongObj(startTimeobj, DateUtil.YYYY_MM_DD);
				map.put("begintime", startTimestr);

				//结束	
				Object endTimeobj = map.get("endtime");
				String endTimestr = DateUtil.getDateStrByLongObj(endTimeobj, DateUtil.YYYY_MM_DD);
				map.put("endtime", endTimestr);

				map.put("promotiontime", startTimestr + "~" + endTimestr);

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
			String id = createActivityId(jdbcBaseDao);
			
			Long starttime = DateUtil.getstrDateLong(map.get("starttime"));
			map.put("starttime", starttime);
			
			Long endtime = DateUtil.getstrDateLong(map.get("endtime"));
			map.put("endtime", endtime);

			PopularizeActivity pa = (PopularizeActivity)ListMapUtil.setEntityValue(map, PopularizeActivity.class);
			pa.setActivityId(id);
			pa.setCreateTime(new Date().getTime());
			pa.setState(1);
			
			popularizeActivityMapper.insertSelective(pa);

			//返回id
			returnmap.put("activityid", pa.getId());
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return returnmap;
	}

	/**
	 * 创建一个线程安全的方法生成活动id
	 * @author hy
	 * @date 2016年7月1日下午4:40:55
	 * @return
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	private static synchronized String createActivityId(JdbcBaseDao jdbcBaseDao) {
		String keyid = "act_00000000";  //默认可以id 

		//生成id, 得到最大id
		String sql = "select (CONVERT(substring(activity_id, 5, 9), SIGNED) + 1) as nextkeyid from"
				+ " yx_popularize_activity order by activity_id desc limit 1";

		List<Map<String, Object>> list = jdbcBaseDao.findList(sql, null);

		if (!CommonUtil.isEmpty(list) && list.size() > 0) {
			Map<String, Object> keyidobj = list.get(0);
			if (!CommonUtil.isEmpty(keyidobj)) {
				String keyidstr = keyidobj.get("nextkeyid").toString();

				String zero = "act_";
				for (int i = 0; i < 8 - keyidstr.length(); i++) {
					zero = zero + "0";
				}

				keyid = zero + keyidstr;
			}
		}

		return keyid;
	}

	@Override
	public Map<String, Object> updateActivity(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			PopularizeActivity pa = (PopularizeActivity)ListMapUtil.setEntityValue(map, PopularizeActivity.class);
			
			//如果停用/启用时/更改广告下面创意的状态
			if (pa.getState() == 0) {
				//查询这个活动的说有广告
				AdvertisementBasicCriteria abc = new AdvertisementBasicCriteria();
				abc.createCriteria().andActivityIdEqualTo(pa.getId());
				
				List<AdvertisementBasic> listbasic = advertisementBasicMapper.selectByExample(abc);
				List<Integer> idlist = new ArrayList<Integer>();
				
				if (listbasic.size() > 0) {
					for (AdvertisementBasic ab : listbasic) {
						idlist.add(ab.getId());
					}
					
					Creative creative = new Creative();
					creative.setProcessState(6);  //创意全部改为暂停
					
					CreativeCriteria cc = new CreativeCriteria();
					com.hy.dao.mybatis.model.CreativeCriteria.Criteria criteria = cc.createCriteria();
					criteria.andAdvertisementIdIn(idlist);  //当前活动下所有的广告
					
					creativeMapper.updateByExampleSelective(creative, cc);
				}
			}
			
			popularizeActivityMapper.updateByPrimaryKeySelective(pa);
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
			Object startTimeobj = returnmap.get("starttime");
			String startTimestr = DateUtil.getDateStrByLongObj(startTimeobj, DateUtil.YYYY_MM_DD);

			//结束	
			Object endTimeobj = returnmap.get("endtime");
			String endTimestr = DateUtil.getDateStrByLongObj(endTimeobj, DateUtil.YYYY_MM_DD);

			returnmap.put("endtimeformat", endTimestr);
			returnmap.put("starttimeformat", startTimestr);

			if (endTimestr == null) {
				endTimestr = "无限期";
			}
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

	@Override
	public List<Map<String, Object>> selectActivityByUserid(Integer createuserid) {
		List<Map<String, Object>> listpopmap = new ArrayList<Map<String, Object>>();
		PopularizeActivityCriteria pac = new PopularizeActivityCriteria();

		try {
			pac.setOrderByClause(" create_time desc");
			Criteria criteria = pac.createCriteria();
			criteria.andCreateUserEqualTo(createuserid);

			List<PopularizeActivity>  listpop = popularizeActivityMapper.selectByExample(pac);
			listpopmap = ListMapUtil.convertListEntityToListMap(listpop);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listpopmap;
	}
}
