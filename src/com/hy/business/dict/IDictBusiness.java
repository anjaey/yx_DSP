package com.hy.business.dict;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hy.util.common.QueryPage;

/**
 * 
 * 字典接口
 * @author hy
 *
 */
@Service
public interface IDictBusiness {
	
	/**
	 * 根据父级iD 查询字典数据
	 * 顶级字典数据默认父级导航为0
	 * @author hy
	 * @date 2016年6月17日下午3:38:04
	 * @param parammap
	 * @param queryPage
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectDictByParentid(Map<String, Object> parammap, QueryPage queryPage);
	
	/**
	 * 根据key  查询字典详细信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:42
	 * @return
	 * @update
	 * @date
	 */
	public Map<String, Object> selectDiceByKey(String key);
	
	/**
	 * 根据built_in_key 查询
	 * 字典子级信息，
	 * @author hy
	 * @date 2016年6月17日下午3:40:42
	 * @return
	 * @update
	 * @date
	 */
	public List<Map<String, Object>> selectDiceByParent(String key);
}
