package com.hy.controller.advertiser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hy.business.advertisement.ICreativeBusiness;
import com.hy.controller.common.BaseController;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.JsonUtil;
import com.hy.util.common.QueryPage;

/**
 * 创意
 * @author hy
 *
 */
@Controller
@RequestMapping("/admin/generalizeManager")
public class CreativeController extends BaseController{

	@Autowired
	ICreativeBusiness creativeBusiness;
	
	/**
	 * 添加创意信息
	 * @author hy
	 * @date 2016年6月24日下午3:42:26
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/addCreative", method = RequestMethod.POST)
	public void addCreative(@RequestParam Map<String,Object> map) {
		Map<String,Object> returnmap = creativeBusiness.insertCreative(map);
		this.writeJson(returnmap);
	}
	
	/**
	 * 删除单条/多条创意信息
	 * 统一用Arrayjson 的方式。
	 * @author hy
	 * @date 2016年6月24日下午4:47:06
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/deleteCreativeByid", method = RequestMethod.POST)
	public void deleteCreativeByid(String Arrayjsonid) {
		List<Map<String, Object>> listmap = JsonUtil.readJson2ListMap(Arrayjsonid);
		List<Integer> idlist = new ArrayList<Integer>();
		for (Map<String, Object> map : listmap) {
			Object idobj = map.get("id");
			if (!CommonUtil.isEmpty(idobj)) {
				idlist.add(Integer.parseInt(idobj.toString()));
			}
		}
		creativeBusiness.deleteCreativeByid(idlist);
	}
	
	/**
	 * 修改创意信息
	 * @author hy
	 * @date 2016年6月24日下午4:48:37
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/updateCreative", method = RequestMethod.POST)
	public void updateCreative(@RequestParam Map<String, Object> parammap) {
		Map<String, Object> returnmap = creativeBusiness.updateCreative(parammap);
		this.writeJson(returnmap);
	}
	
	/**
	 * 根据条件查询创意信息
	 * @author hy
	 * @date 2016年6月24日下午4:10:28
	 * @param parammap
	 * @param queryPage
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findAdvertiserListAndPage", method = RequestMethod.POST)
	public void findAdvertiserListAndPage(@RequestParam Map<String, Object> parammap, QueryPage queryPage) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listmap = creativeBusiness.selectCreativeAndPageByAdvertisementid(parammap, queryPage);

			String vmPath = File.separator + "vm" + File.separator + "advertiser";

			map1 = initpage("creative.vm", vmPath, listmap, queryPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(map1);
	}
}
