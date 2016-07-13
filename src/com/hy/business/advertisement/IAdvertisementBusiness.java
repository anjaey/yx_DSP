package com.hy.business.advertisement;

import java.util.List;
import java.util.Map;

import com.hy.util.common.QueryPage;

/**
 * 广告接口
 * 
 * @author hy
 *
 */
public interface IAdvertisementBusiness {
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
	public List<Map<String, Object>> selectAdvertisementByParentid(Map<String, Object> parammap, 
			QueryPage queryPage, Integer userid);
	
	/**
	 * 添加广告信息
	 * @author hy
	 * @date 2016年6月17日下午3:39:32
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> insertAdvertisement(Map<String, Object> map, Integer userid);
	
	/**
	 * 修改广告信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:05
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> updateAdvertisement(Map<String, Object> map);
	
	/**
	 * 查询广告详细信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:42
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectAdvertisementByid(Integer id);
}
