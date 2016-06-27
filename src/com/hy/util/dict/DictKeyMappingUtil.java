package com.hy.util.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 字典key于nameen对照类
 * 方便取字典数据。解耦字典表key 与程序的关联。
 * 
 * key: 字典英文名称，并且不重复，  value： 数据库key
 * @author hy
 *
 */
public class DictKeyMappingUtil {

	public static final Map<String, String> map = new
			HashMap<String, String>();
	
	static {
		//推广类型
		map.put("constellation", "dd_001"); //星座
		map.put("", "dd_002"); //学历
		map.put("", "dd_003"); //收入
		map.put("", "dd_004"); //感情状况
		map.put("", "dd_005"); //兴趣爱好
		map.put("", "dd_006"); //广告尺寸
		map.put("", "dd_007"); //创意形式
		map.put("", "dd_008"); //创意类型  
		map.put("", "dd_009"); //角色范围
	}
}
