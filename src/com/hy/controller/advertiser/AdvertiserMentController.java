package com.hy.controller.advertiser;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hy.business.advertisement.IAdvertisementBusiness;
import com.hy.business.advertisement.ICreativeBusiness;
import com.hy.business.dict.IDictBusiness;
import com.hy.business.popularizeActivity.IPopularizeActivityBusiness;
import com.hy.controller.common.BaseController;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.DictContantUtil;
import com.hy.util.common.JsonUtil;
import com.hy.util.common.QueryPage;

/**
 * 广告
 * 
 * @author hy
 *
 */
@Controller
@RequestMapping("/admin/generalizeManager")
public class AdvertiserMentController extends BaseController{

	@Autowired
	IAdvertisementBusiness advertisementBusiness;
	@Autowired
	IPopularizeActivityBusiness popularizeActivityBusiness;
	@Autowired
	IDictBusiness dictBusiness;
	@Autowired
	ICreativeBusiness creativeBusiness;

	/**
	 * 跳转到推广
	 * @author hy
	 * @date 2016年7月11日上午11:14:03
	 * @return
	 * @update
	 * @date
	 */
	@RequestMapping("/toadvertiserMent")
	public ModelAndView toadvertiserMent() {
		return forwardPage("admin/advertiserMent/advertiserMent");
	}
	
	/**
	 * 查询广告详情
	 * @author hy
	 * @date 2016年7月11日上午11:58:16
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findAdvertiserMentByid", method = RequestMethod.POST)
	public void findAdvertiserMentByid(@RequestParam Integer advertisermentid) {
		Map<String, Object> map = advertisementBusiness.selectAdvertisementByid(advertisermentid);
		
		if (!CommonUtil.isEmpty(map)) {
			Object activityIdobj = map.get("activityid");
			if (!CommonUtil.isEmpty(activityIdobj)) {
				Map<String, Object>  activitymap = popularizeActivityBusiness.selectActivityByid(Integer.parseInt(activityIdobj.toString()));
				map.put("activity", activitymap);
			}
		}
		
		this.writeJson(map);
	}
	
	/**
	 *  查询广告瞄准部分相关的字典内容
	 * @author hy
	 * @date 2016年7月12日下午4:35:52
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findDictInfoToCollimation", method = RequestMethod.POST)
	public void findDictInfoToCollimation() {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] keys = {DictContantUtil.OPERATINGSYSTEM, DictContantUtil.OPERATOR, DictContantUtil.OPERATORSTATE
				, DictContantUtil.INTEREST, DictContantUtil.DEVICETYPEKEY, DictContantUtil.SEX,
				DictContantUtil.AGE, DictContantUtil.PUTINTYPE, DictContantUtil.ADVERTISERTYPE, 
				DictContantUtil.ADVERTISERMODALITY, DictContantUtil.NORMSSIZE};
		
		for (String key : keys) {
			List<Map<String, Object>> listmap = dictBusiness.selectDiceByParent(key);
			map.put(key, listmap);
		}
		this.writeJson(map);
	}
	
	/**
	 * 
	 * 修改广告信息
	 * @author hy
	 * @date 2016年7月25日下午5:39:21
	 * @param map
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/updateAdvertiser", method = RequestMethod.POST)
	public void updateAdvertiser(@RequestParam Map<String, Object> map) {
		//同时添加活动信息
		Object activityInfoobj = map.get("activityInfo");
		if (!CommonUtil.isEmpty(activityInfoobj)) {  //创建新的活动
		 	String activityInfoJson = map.get("activityInfo").toString();
		 	Map<String, Object> activityInfoMap = JsonUtil.readJson2Map(activityInfoJson);
		 	if (activityInfoMap.keySet().size() > 0) {
		 		activityInfoMap.put("createuser", this.getSessionLoginUserid());
		 		popularizeActivityBusiness.insertActivity(activityInfoMap);
		 	}
		}
		
		Map<String, Object> returnmap = advertisementBusiness.updateAdvertisement(map);
	 	this.writeJson(returnmap);
	}
	
	/**
	 * 添加广告信息
	 * 
	 * @author hy
	 * @date 2016年6月24日下午2:18:17
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/addAdvertiserMent", method = RequestMethod.POST)
	public void addAdvertiser(@RequestParam Map<String, Object> map) {
		
		//添加广告信息
	 	Map<String, Object> returnmap = advertisementBusiness.insertAdvertisement(map, this.getSessionLoginUserid());
	 	
	 	//添加创意信息
	 	String creativeJson = map.get("creative").toString();
	 	Map<String, Object> creativeMap = JsonUtil.readJson2Map(creativeJson);
	 	
	 	//放入广告信息
	 	creativeMap.put("advertisementid", returnmap.get("id"));
	 	returnmap = creativeBusiness.insertCreative(creativeMap);
	 	
	 	this.writeJson(returnmap);
	}
	
	/**
	 * 
	 * 修改广告信息
	 * 
	 * @author hy
	 * @date 2016年7月15日下午2:33:56
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/updateAdvertiserMent", method = RequestMethod.POST)
	public void updateAdvertiserMent(@RequestParam Map<String, Object> parammap) {
		Object basicobj = parammap.get("basic");
		if (!CommonUtil.isEmpty(basicobj)) {
			String basic = basicobj.toString();
			Map<String, Object> basicmap = JsonUtil.readJson2Map(basic);
			parammap.put("basic", basicmap);
		}
		
		Object pricingobj = parammap.get("pricing");
		if (!CommonUtil.isEmpty(pricingobj)) {
			String pricing = pricingobj.toString();
			Map<String, Object> pricingmap = JsonUtil.readJson2Map(pricing);
			parammap.put("pricing", pricingmap);
			
		}
		
		Object collimationobj = parammap.get("collimation");
		if (!CommonUtil.isEmpty(collimationobj)) {
			String collimation = pricingobj.toString();
			Map<String, Object> collimationmap = JsonUtil.readJson2Map(collimation);
			parammap.put("collimation", collimationmap);
		}
		
		
		Map<String, Object> returnmap = advertisementBusiness.updateAdvertisement(parammap);
	 	this.writeJson(returnmap);
	}
	
	/**
	 * 查询最新的广告
	 * @author hy
	 * @date 2016年7月12日下午4:32:26
	 * @param parammap
	 * @param queryPage
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findNewestAdvertiserMent", method = RequestMethod.POST)
	public void findNewestAdvertiserMent(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		List<Map<String, Object>> listmap = null;
		try {
			listmap = advertisementBusiness.selectAdvertisement(parammap, queryPage, this.getSessionLoginUserid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(listmap);
	}
	
	/**
	 * 查询广告信息
	 * @author hy
	 * @date 2016年6月24日下午4:10:28
	 * @param parammap
	 * @param queryPage
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findAdvertiserMentListAndPage", method = RequestMethod.POST)
	public void findAdvertiserMentListAndPage(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listmap = advertisementBusiness.selectAdvertisement(parammap, queryPage, this.getSessionLoginUserid());

			String vmPath = File.separator + "vm" + File.separator + "advertiser";

			map1 = initpage("advertiserMentPage.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
	
	/**
	 * 必须根据活动iD 或者  以及其他的查询广告信息
	 * @author hy
	 * @date 2016年6月24日下午4:10:28
	 * @param parammap
	 * @param queryPage
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findAdvertiserMentListAndPageByActivity", method = RequestMethod.POST)
	public void findAdvertiserMentListAndPageByActivity(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listmap = advertisementBusiness.selectAdvertisement(parammap, queryPage, this.getSessionLoginUserid());

			String vmPath = File.separator + "vm" + File.separator + "advertiser";

			map1 = initpage("advertiserMentPage.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
	
}
