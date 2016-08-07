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
import com.hy.business.popularizeActivity.IPopularizeActivityBusiness;
import com.hy.controller.common.BaseController;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.DateUtil;
import com.hy.util.common.QueryPage;

/**
 * 推广活动
 * @author hy
 *
 */
@Controller
@RequestMapping("/admin/popularizeActivity")
public class PopularizeActivityController extends BaseController{

	@Autowired
	IPopularizeActivityBusiness popularizeActivityBusiness;

	/**
	 * 跳转推广活动
	 * @author hy
	 * @date 2016年4月29日下午4:13:19
	 * @return
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/toPopularizeActivity", method = RequestMethod.GET)
	public ModelAndView toPopularizeActivity() {
		//统计曝光量、点击量、消费
		return forwardPage("popularizeActivity/index");
	}
	
	/**
	 * 查看活动详情
	 * @author hy
	 * @date 2016年7月12日下午2:10:45
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findActvityInfo", method = RequestMethod.POST)
	public void findActvityInfo(@RequestParam Integer id) {
		Map<String, Object> map = popularizeActivityBusiness.selectActivityByid(id);
		this.writeJson(map);
	}

	/**
	 * 添加活动信息
	 * @author hy
	 * @date 2016年6月24日下午2:07:14
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/addActvity", method = RequestMethod.POST)
	public void addActvity(@RequestParam Map<String, Object> map) {
		map.put("createuser", this.getSessionLoginUserid());
		
		Map<String, Object> returnmap = popularizeActivityBusiness.insertActivity(map);
		this.writeJson(returnmap);
	}
	
	/**
	 * 修改活动信息
	 * @author hy
	 * @date 2016年6月24日下午2:07:14
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/updateActvity", method = RequestMethod.POST)
	public void updateActvity(@RequestParam Map<String, Object> map) {
		//转换类型
		Object startTime = map.get("starttime");
		if (!CommonUtil.isEmpty(startTime)) {
			String startTimestr = startTime.toString();
			Long startTimelong = DateUtil.str2Date(startTimestr, DateUtil.YYYY_MM_DD).getTime();
			map.put("starttime", startTimelong);
		}
		
		Object endTime = map.get("endtime");
		if (!CommonUtil.isEmpty(endTime)) {
			String endTimestr = endTime.toString();
			Long endTimestrlong = DateUtil.str2Date(endTimestr, DateUtil.YYYY_MM_DD).getTime();
			map.put("endtime", endTimestrlong);
		}
		
		Map<String, Object> returnmap = popularizeActivityBusiness.updateActivity(map);
		this.writeJson(returnmap);
	}
	
	/**
	 * 推广活动分页查询。
	 * 这个用户创建的
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findPopularizeActivityListAndPage", method = RequestMethod.POST)
	public void findPopularizeActivityListAndPage(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listmap = popularizeActivityBusiness.selectActivityAndPage(parammap, queryPage, this.getSessionLoginUserid());

			String vmPath = File.separator + "vm" + File.separator + "advertiser";

			map1 = initpage("popularizeActivityPage.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
	
	/**
	 * 查询这个用户创建的所有活动信息
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findPopularizeActivityList", method = RequestMethod.POST)
	public void findPopularizeActivityList() {
		try {
			List<Map<String, Object>> listmap = popularizeActivityBusiness.selectActivityByUserid(this.getSessionLoginUserid());
			this.writeJson(listmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

