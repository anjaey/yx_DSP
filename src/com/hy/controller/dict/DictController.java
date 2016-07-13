package com.hy.controller.dict;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hy.business.dict.IDictBusiness;
import com.hy.controller.common.BaseController;

/**
 * 
 * 字典操作
 * @author hy
 *
 */
@Controller
public class DictController extends BaseController{

	@Autowired
	IDictBusiness dictBusiness;
	
	/**
	 * 根据字典key 查询这个字典的子级。
	 * @author hy
	 * @date 2016年6月24日下午2:21:52
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/dict/findDictListSonBykey")
	public void findDictListSonBykey(String key) {
		List<Map<String, Object>> listmap = dictBusiness.selectDiceByParent(key);
		
		this.writeJson(listmap);
	}
	
	
	
}
