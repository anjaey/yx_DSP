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
import com.hy.util.common.QueryPage;

/**
 * 推广活动
 * @author hy
 *
 */
@Controller
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
	@RequestMapping(value = "/admin/popularizeActivity/toPopularizeActivity", method = RequestMethod.GET)
	public ModelAndView toPopularizeActivity() {
		//统计曝光量、点击量、消费
		return forwardPage("popularizeActivity/index");
	}

	/**
	 * 添加活动信息
	 * @author hy
	 * @date 2016年6月24日下午2:07:14
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/popularizeActivity/addActvity", method = RequestMethod.POST)
	public void addActvity(@RequestParam Map<String, Object> map) {
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
	@RequestMapping(value = "/admin/popularizeActivity/updateActvity", method = RequestMethod.POST)
	public void updateActvity(@RequestParam Map<String, Object> map) {
		Map<String, Object> returnmap = popularizeActivityBusiness.updateActivity(map);
		this.writeJson(returnmap);
	}
	
	/**
	 * 推广活动分页查询。
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/popularizeActivity/findPopularizeActivityListAndPage", method = RequestMethod.POST)
	public void findPopularizeActivityListAndPage(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
//			List<Map<String, Object>> listmap = popularizeActivityBusiness.selectActivityAndPage(parammap, queryPage);

			String vmPath = File.separator + "vm" + File.separator + "popularizeActivity";

//			map1 = initpage("popularizeActivityPage.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
}

