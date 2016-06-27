package com.hy.business.advertisement;

import java.util.List;
import java.util.Map;

import com.hy.util.common.QueryPage;

/**
 * 创意接口
 * 
 * @author hy
 *
 */
public interface ICreativeBusiness {

	/**
	 * 分页查询创意
	 * 默认根据广告组id 查询 这个广告组的创意。
	 * 
	 * @author hy
	 * @date 2016年6月17日下午3:38:04
	 * @param parammap 
	 * advertisementGroupid 广告组id
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectCreativeAndPageByAdvertisementid(Map<String, Object> parammap, QueryPage queryPage);
	
	/**
	 * 添加创意
	 * @author hy
	 * @date 2016年6月17日下午3:39:32
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> insertCreative(Map<String, Object> map);
	
	/**
	 * 修改创意
	 * @author hy
	 * @date 2016年6月17日下午3:40:05
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> updateCreative(Map<String, Object> map);
	
	/**
	 * 删除创意信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:05
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> deleteCreativeByid(List<Integer> id);
	
	/**
	 * 查询创意详细信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:42
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectCreativeByid(Integer id);
}
