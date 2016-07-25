package com.hy.business.advertisement.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.advertisement.IAdvertisementBusiness;
import com.hy.business.popularizeActivity.IPopularizeActivityBusiness;
import com.hy.dao.mybatis.mapper.AdvertisementBasicMapper;
import com.hy.dao.mybatis.mapper.AdvertisementCollimationMapper;
import com.hy.dao.mybatis.mapper.AdvertisementPricingMapper;
import com.hy.dao.mybatis.model.AdvertisementBasic;
import com.hy.dao.mybatis.model.AdvertisementBasicCriteria;
import com.hy.dao.mybatis.model.AdvertisementBasicCriteria.Criteria;
import com.hy.dao.mybatis.model.AdvertisementCollimation;
import com.hy.dao.mybatis.model.AdvertisementCollimationCriteria;
import com.hy.dao.mybatis.model.AdvertisementPricing;
import com.hy.dao.mybatis.model.AdvertisementPricingCriteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.DateUtil;
import com.hy.util.common.JsonUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.PageUtil;
import com.hy.util.common.QueryPage;

/**
 * 
 * 广告
 * @author hy
 *
 */
@Service
public class AdvertisementBusinessImpl implements IAdvertisementBusiness{

	@Autowired
	AdvertisementBasicMapper advertisementBasicMapper;
	@Autowired
	AdvertisementPricingMapper advertisementPricingMapper;
	@Autowired
	AdvertisementCollimationMapper advertisementCollimationMapper;
	@Autowired
	IPopularizeActivityBusiness popularizeActivityBusiness;

	/**
	 * 分页查询广告
	 * 
	 * @author hy
	 * @date 2016年6月17日下午3:38:04
	 * @param parammap 
	 * activityid 活动id
	 * 
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAdvertisement(Map<String, Object> parammap, 
			QueryPage queryPage, Integer userid) {
		List<Map<String, Object>> listmap = null;
		//查询所有非内置角色
		try {
			AdvertisementBasicCriteria dc = new AdvertisementBasicCriteria();
			dc.setOrderByClause(" create_time desc");
			Criteria criteria = dc.createCriteria();

			int pagesize = queryPage.getPageSize();
			int pageindex = queryPage.getTargetPage();

			dc.setLimitStart(PageUtil.getStart(pageindex, pagesize));
			dc.setLimitEnd(PageUtil.getEnt(pageindex, pagesize));

			//活动id
			Object activityidobj = parammap.get("activity");
			if (!CommonUtil.isEmpty(activityidobj)) {
				criteria.andActivityIdEqualTo(Integer.parseInt(activityidobj.toString()));
			}
			
			//创建人
			criteria.andCreateUserEqualTo(userid);

			List<AdvertisementBasic> rolelist = advertisementBasicMapper.selectByExample(dc);
			listmap = ListMapUtil.convertListEntityToListMap(rolelist);
			
			for (Map<String, Object> map : listmap) {
				//查询推广活动
				Object activityObj = map.get("activityid");
				
				if (!CommonUtil.isEmpty(activityObj)) {
					Integer activityid = Integer.parseInt(map.get("activityid").toString());
					Map<String, Object> activitymap = popularizeActivityBusiness.selectActivityByid(activityid);
					map.put("activity", activitymap);
				}
				
				//处理时间
				String createtimestr = DateUtil.getDateStrByLongObj(map.get("createtime"), DateUtil.YYYY_MM_DD);
				map.put("createtimestr", createtimestr);
				
				int id = Integer.parseInt(map.get("id").toString());
				
				//查询瞄准信息
				AdvertisementCollimationCriteria acc = new AdvertisementCollimationCriteria();
				acc.createCriteria().andBasicIdEqualTo(id);
				AdvertisementCollimation ac = advertisementCollimationMapper.selectByExampleForOne(acc);
				Map<String, Object> acmap = ListMapUtil.convertEntityToMap(ac);
				
				map.put("advertisementCollimation", acmap);
				
				//查询定价信息
				AdvertisementPricingCriteria apc = new AdvertisementPricingCriteria();
				apc.createCriteria().andBasicIdEqualTo(id);
				
				AdvertisementPricing ap = advertisementPricingMapper.selectByExampleForOne(apc);
				Map<String, Object> apmap = ListMapUtil.convertEntityToMap(ap);
				
				map.put("advertisementPricing", apmap);
			}

			//统计数量
			int pagecount = advertisementBasicMapper.countByExample(dc);
			queryPage.setRecordCount(pagecount);

			//总页数
			queryPage.setPageCount(PageUtil.getpagecount(pagecount, pagesize));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listmap;
	}

	/**
	 * 添加广告信息
	 * @author hy
	 * @date 2016年6月17日下午3:39:32
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> insertAdvertisement(Map<String, Object> map, Integer userid) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {
			//保存基本信息
			String basic = map.get("basic").toString();
			Map<String, Object> basicmap = JsonUtil.readJson2Map(basic);
			AdvertisementBasic advertisementBasic = (AdvertisementBasic)ListMapUtil.setEntityValue(basicmap, AdvertisementBasic.class);
			advertisementBasic.setCreateTime(new Date().getTime());
			advertisementBasic.setCreateUser(userid);
			advertisementBasicMapper.insert(advertisementBasic);
			
			//保存瞄准信息
			String collimation = map.get("collimation").toString();
			String[] tojson = {"operatingsystemvaluejson", "networkenvironmentvaluejson", "operatorvaluejson", 
					"devicetypevaluejson", "sexvaluejson", "agevaluejson", "interestvaluejson", "areavaluejson"};
			Map<String, Object> collimationmap = JsonUtil.readJson2Map(collimation, tojson);
			AdvertisementCollimation advertisementCollimation = (AdvertisementCollimation)ListMapUtil.setEntityValue(collimationmap, AdvertisementCollimation.class);
			advertisementCollimation.setBasicId(advertisementBasic.getId());
			advertisementCollimationMapper.insert(advertisementCollimation);
			
			//保存定价信息
			String pricing = map.get("pricing").toString();
			Map<String, Object> pricingmap = JsonUtil.readJson2Map(pricing);
			AdvertisementPricing advertisementPricing = (AdvertisementPricing)ListMapUtil.setEntityValue(pricingmap, AdvertisementPricing.class);
			advertisementPricing.setBasicId(advertisementBasic.getId());
			advertisementPricingMapper.insert(advertisementPricing);

			//返回id
			returnmap.put("id", advertisementBasic.getId());
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}	

		return returnmap;
	}	

	/**
	 * 修改广告信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:05
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAdvertisement(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
				
		try {
			//保存基本信息
			Map<String, Object> basicmap = (Map<String, Object>)map.get("basic");
			if (!CommonUtil.isEmpty(basicmap)) {
				AdvertisementBasic advertisementBasic = (AdvertisementBasic)ListMapUtil.setEntityValue(basicmap, AdvertisementBasic.class);
				
				//主键id
				int basicid = advertisementBasic.getId();
				
				AdvertisementBasicCriteria abc = new AdvertisementBasicCriteria();
				abc.createCriteria().andIdEqualTo(basicid);
				advertisementBasicMapper.updateByExampleSelective(advertisementBasic, abc);
			}

			//保存定价信息
			Map<String, Object> pricingmap = (Map<String, Object>)map.get("pricing");
			if (!CommonUtil.isEmpty(pricingmap)) {
				AdvertisementPricing advertisementPricing = (AdvertisementPricing)ListMapUtil.setEntityValue(pricingmap, AdvertisementPricing.class);
				AdvertisementPricingCriteria apc = new AdvertisementPricingCriteria();
				
				//使用basic这个主键修改
				apc.createCriteria().andBasicIdEqualTo(advertisementPricing.getBasicId());
				
				//判断是否在修改最高出价，如果是在修改最高出价，当前的这个广告要重新审核， 此处改为未审核。
				if (advertisementPricing.getCheckBestBidPrice() != null) {
					AdvertisementBasic advertisementBasic = new AdvertisementBasic();
					advertisementBasic.setCheckState(0);
					
					AdvertisementBasicCriteria abc = new AdvertisementBasicCriteria();
					abc.createCriteria().andIdEqualTo(advertisementPricing.getBasicId());
					advertisementBasicMapper.updateByExampleSelective(advertisementBasic, abc);
				}
				
				advertisementPricingMapper.updateByExampleSelective(advertisementPricing, apc);
			}

			//保存瞄准信息
			Map<String, Object> collimationmap = (Map<String, Object>)map.get("collimation");

			if (!CommonUtil.isEmpty(collimationmap)) {
				AdvertisementCollimation advertisementCollimation = (AdvertisementCollimation)ListMapUtil.setEntityValue(collimationmap, AdvertisementCollimation.class);
				AdvertisementCollimationCriteria acc = new AdvertisementCollimationCriteria();
			
				acc.createCriteria().andBasicIdEqualTo(advertisementCollimation.getBasicId());
				
				advertisementCollimationMapper.updateByExampleSelective(advertisementCollimation, acc);
			}
			
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}	

		return returnmap;
	}

	/**
	 * 查询广告详细信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:42
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectAdvertisementByid(Integer id) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		try {

			//查询基本信息
			AdvertisementBasic ab = advertisementBasicMapper.selectByPrimaryKey(id);

			//查询瞄准信息
			AdvertisementPricingCriteria apc = new AdvertisementPricingCriteria();
			apc.createCriteria().andBasicIdEqualTo(id);
			AdvertisementPricing ap = advertisementPricingMapper.selectByExampleForOne(apc);

			//查询定价信息
			AdvertisementCollimationCriteria acc = new AdvertisementCollimationCriteria();
			acc.createCriteria().andBasicIdEqualTo(id);
			AdvertisementCollimation ac = advertisementCollimationMapper.selectByExampleForOne(acc);

			Map<String, Object> abmap = ListMapUtil.convertEntityToMap(ab);
			Map<String, Object> apmap = ListMapUtil.convertEntityToMap(ap);
			Map<String, Object> acmap = ListMapUtil.convertEntityToMap(ac);
			
			returnmap.putAll(abmap);
			returnmap.put("pricing", apmap);
			returnmap.put("collimation", acmap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnmap;
	}
}
