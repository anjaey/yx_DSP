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
	 * 添加父级字典信息
	 * @author hy
	 * @date 2016年6月17日下午3:39:32
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public boolean insertDictParent(Map<String, Object> map);
	
	/**
	 * 添加子级信息
	 * @author hy
	 * @date 2016年6月17日下午3:39:32
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public boolean insertDictSon(Map<String, Object> map);
	
	/**
	 * 修改字典信息
	 * @author hy
	 * @date 2016年6月17日下午3:40:05
	 * @param map
	 * @return
	 * @update
	 * @date
	 */
	public boolean updateDict(Map<String, Object> map);
	
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
