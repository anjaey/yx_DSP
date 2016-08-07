package com.hy.business.address;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 地址相关接口
 * 
 * @author hy
 *
 */
@Service
public interface IAddressBusiness {

	/**
	 * 查询所有省级地址
	 * @author hy
	 * @date 2016年7月1日上午10:47:55
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAddressProvinces();
	
	/**
	 * 查询所有省级地址
	 * @author hy
	 * @date 2016年7月1日上午10:47:55
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAddressProvincesAndCreateTree();
	
	/**
	 * 根据省级id 查询市级地址
	 * @author hy
	 * @date 2016年7月1日上午10:50:24
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAddressCitiesByProvincesId(String provincesId);
}
