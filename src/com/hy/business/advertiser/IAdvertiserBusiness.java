package com.hy.business.advertiser;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hy.util.common.QueryPage;

/**
 * 广告主管理
 * 
 * @author hy
 *
 */
@Service
public interface IAdvertiserBusiness{
	
	/**
	 * 查询广告主，并分页。
	 * @author hy
	 * @date 2016年5月6日上午11:19:50
	 * @param parammap
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAllAdvertiserAndPage(Map<String, Object> parammap, 
			QueryPage queryPage);
	
	/**
	 * 查询所有广告主，
	 * 没有条件时parammap 为 null
	 * 
	 * @author hy
	 * @date 2016年5月6日上午11:19:50
	 * @param parammap   	
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectAllAdvertiser(Map<String, Object> parammap);
	
	/**
	 * 根据id 查询广告主详细信息
	 * 
	 * @author hy
	 * @date 2016年5月3日下午2:29:31
	 * @return map
	 *  
	 *  
	 * @update
	 * @date
	 */
	public Map<String, Object> selectAdvertiserDetilByid(Integer id);
	
}
