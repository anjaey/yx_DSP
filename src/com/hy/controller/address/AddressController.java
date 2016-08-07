package com.hy.controller.address;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hy.business.address.IAddressBusiness;
import com.hy.controller.common.BaseController;

/**
 * 地址控制器
 * 
 * @author hy
 *
 */
@Controller
@RequestMapping("/admin/address")
public class AddressController extends BaseController{
	
	@Autowired
	IAddressBusiness addressBusiness;
	
	/**
	 * 查询所有省级城市
	 * @author hy
	 * @date 2016年7月1日上午11:22:33
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findAddressProvinces")
	public void findAddressProvinces() {
		List<Map<String, Object>> listmap = addressBusiness.selectAddressProvinces();
		this.writeJson(listmap);
	}
	
	/**
	 * 查询省市 并形成树形结构
	 * @author hy
	 * @date 2016年7月1日上午11:22:33
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findAddressProvincesAndCreateTree", method = RequestMethod.POST)
	public void findAddressProvincesAndCreateTree() {
		List<Map<String, Object>> listmap = addressBusiness.selectAddressProvincesAndCreateTree();
		this.writeJson(listmap);
	}
	
	/**
	 * 根据省查询市
	 * @author hy
	 * @date 2016年7月1日上午11:23:33
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/findAddressCities", method = RequestMethod.POST)
	public void findAddressCities(@RequestParam String provincesId) {
		List<Map<String, Object>> listmap = addressBusiness.selectAddressCitiesByProvincesId(provincesId);
		this.writeJson(listmap);
	}
	
}
