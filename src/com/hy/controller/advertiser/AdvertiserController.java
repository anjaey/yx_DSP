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

import com.hy.business.advertisement.IAdvertisementBusiness;
import com.hy.controller.common.BaseController;
import com.hy.util.common.QueryPage;

/**
 * 广告
 * 
 * @author hy
 *
 */
@Controller
public class AdvertiserController extends BaseController{

	@Autowired
	IAdvertisementBusiness advertisementBusiness;
	
	/**
	 * 添加广告信息
	 * 
	 * @author hy
	 * @date 2016年6月24日下午2:18:17
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/advertiser/add", method = RequestMethod.POST)
	public void addAdvertiser(@RequestParam Map<String, Object> map) {
	 	Map<String, Object> returnmap = advertisementBusiness.insertAdvertisement(map);
	 	this.writeJson(returnmap);
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
	@RequestMapping(value = "/admin/advertiser/findAdvertiserListAndPage", method = RequestMethod.POST)
	public void findAdvertiserListAndPage(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listmap = advertisementBusiness.selectAdvertisementByParentid(parammap, queryPage);

			String vmPath = File.separator + "vm" + File.separator + "popularizeActivity";

			map1 = initpage("advertiserPage.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
	
}
