package com.hy.business.popularizeActivity;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hy.util.common.QueryPage;

/**
 * 
 * 推广活动相关
 * @author hy
 *
 */
@Service
public interface IPopularizeActivityBusiness {
	
	/**
	 * 查询这个用户创建的所有有效的活动
	 * @author hy
	 * @date 2016年6月21日上午10:06:42
	 * @param parammap
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectActivityByUserid(Integer createuserid);
	
	
	/**
	 * 查询指定所有活动信息
	 * @author hy
	 * @date 2016年6月21日上午10:06:42
	 * @param parammap
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectActivityAndPage(Map<String, Object> parammap, QueryPage queryPage, Integer createuserid);
	

	/**
	 * 分页查询推广活动
	 * 
	 * @author hy
	 * @date 2016年6月17日下午3:38:04
	 * @param parammap 
	 * starttime 开始时间
	 * endtime 结束时间
	 * name 活动名称
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectActivity(Map<String, Object> parammap);	
	
	/**
	 * 添加推广活动信息
	 * @author hy
	 * @date 2016年6月17日下午3:39:32
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> insertActivity(Map<String, Object> map);
	
	/**
	 * 修改推广活动信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:05
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> updateActivity(Map<String, Object> map);
	
	/**
	 * 查询推广活动详细信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:42
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectActivityByid(Integer id);
}
