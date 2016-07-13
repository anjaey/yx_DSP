package com.hy.util.common;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json，java对象互相转换类
 * @author 
 *	<ul>
 *	 <li>高文相  2014  年  9月 22 日 新增<li>
 *	<ul>
 */
public class JsonUtil implements ConstantUtil{
	private static Log log = LogFactory.getLog(JsonUtil.class);
	private static ObjectMapper  objectMapper = null;
	private static JsonUtil json = null;

	/**
	 * 实例化JsonUtil
	 * @author 
	 *	<ul>
	 *	 <li>高文相  2014  年  9月 22 日 新增<li>
	 *	<ul>
	 */
	@SuppressWarnings("unused")
	private static JsonUtil instance() {
		if(json == null) {
			json = new JsonUtil();
		}
		return json;
	}
	
	/**
	 * 
	 *  把一个arrayjsonMap的字符串转换为所需要的map，
	 *  注意：map 的key 用json 里面的 name 属性
	 *  主要用于前台的json传值。 form 表单的情况
	 * @author hy
	 * @date 2016年6月27日下午3:24:10
	 * @return
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapJsonStrMap(String mapJson) {
		Map<String, Object> map = readJson2Map(mapJson);
	 	Set<String> setkey = map.keySet(); 
	 	for (String string : setkey) {
	 		Object keyvalue =  map.get(string);
	 		if (keyvalue instanceof List) {
	 			List<Map<String, Object>> listmap = (List<Map<String, Object>>)keyvalue;
	 			map.put(string, getMapbyArrayListmap(listmap));
	 		}
		}
		return map;
	}

	/**
	 *  把一个List<Map<String, Object>>的字符串转换为map，
	 *  注意：map 的key 用json 里面的 name 属性
	 *  主要用于前台的json传值。
	 * @author hy
	 * @date 2016年6月23日上午11:23:07
	 * @return
	 * @update  
	 * @date
	 */
	public static Map<String, Object> getMapbyArrayListmap(List<Map<String, Object>> listmap) {
		Map<String, Object> map = new HashMap<String, Object>();

		for (Map<String, Object> map2 : listmap) {
			Object nameobj =  map2.get("name");
			if (!CommonUtil.isEmpty(nameobj)) {
				String key = nameobj.toString();
				Object valueobj = map2.get("value");
				map.put(key, valueobj);
			}
		}

		return map;
	}
	
	/**
	 *  把一个arrayjson的字符串转换为map，
	 *  注意：map 的key 用json 里面的 name 属性
	 *  主要用于前台的json传值。
	 * @author hy
	 * @date 2016年6月23日上午11:23:07
	 * @return
	 * @update  
	 * @date
	 */
	public static Map<String, Object> getMapbyArrayJsonStr(String arrayJson) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> listmap = readJson2ListMap(arrayJson);
		for (Map<String, Object> map2 : listmap) {
			Object nameobj =  map2.get("name");
			if (!CommonUtil.isEmpty(nameobj)) {
				String key = nameobj.toString();
				Object valueobj = map2.get("value");
				map.put(key, valueobj);
			}
		}

		return map;
	}

	/**
	 * 将Object对象转为JSON字符串
	 * 
	 * @param obj JavaBean/Map/List<?> 等
	 * 例：User user， 实体User的对象
	 * Map<String,Object> map; map对象
	 * List<Object> list;list对象
	 * List<Map<String,Object>> listmap;listmap对象
	 * @author 
	 *	<ul>
	 *	 <li>高文相  2014  年  9月 22 日 新增<li>
	 *	<ul>
	 */
	public static String ObjectToJson(Object obj){
		if(obj == null){
			return JSONUTILE_JSONNULL;
		}
		try {
			objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.debug("Object转换json字符串错误!", e);
		};
		return JSONUTILE_JSONNULL;
	}

	/**
	 * 将JSON字符串转换为Object对象
	 * @param json 需要转换的json字符串;
	 * @param clas 需要转换成的类型
	 * 例：List.class; User.class(实体类)
	 * @author 
	 *	<ul>
	 *	 <li>高文相  2014  年  9月 22 日 新增<li>
	 *	<ul>
	 */
	public static <T> T JsonToObject(String json, Class<T> clas){
		if(json == null){
			return null;
		}
		try {
			objectMapper = new ObjectMapper();
			return objectMapper.readValue(json, clas);
		} catch (IOException e) {
			log.debug("json转换Object错误!", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static  List<Map<String, Object>> readJson2ListMap(String json) {
		try {
			objectMapper = new ObjectMapper();
			return objectMapper.readValue(json, List.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}

	/**
	 * json 字符串转换为map
	 * @author hy
	 * @date 2016年7月13日下午6:09:52
	 * @param json
	 * @return
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	public static  Map<String, Object> readJson2Map(String json) {
		try {
			objectMapper = new ObjectMapper();
			return objectMapper.readValue(json, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}
	
	/**
	 * json 字符串转换为map
	 * 原理： 转换成功后 在吧不需要转换的重新转换为json 字符串
	 * @author hy
	 * @date 2016年7月13日下午6:10:28
	 * @param json
	 * @param notToMapKey  不用转换的key
	 * @return
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	public static  Map<String, Object> readJson2Map(String json, String[] notToMapKey) {
		try {
			objectMapper = new ObjectMapper();
			Map<String, Object> map = objectMapper.readValue(json, Map.class);
			for (String string : notToMapKey) {
				if (map.containsKey(string)) {
					Object obj = map.get(string);
					String jsonstr = ObjectToJson(obj);
					map.put(string, jsonstr);  //还原成json字符串
				}
			}
			
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}




	/**
	 * 将JSON格式中的null值转换成""串
	 * @author 
	 *	<ul>
	 *	 <li>高文相  2014  年  9月 22 日 新增<li>
	 *	<ul>
	 */
	@SuppressWarnings("unused")
	private static String convertNullToEmpty(String json) {
		return json.replaceAll(JSONUTILE_ISNULL,JSONUTILE_REPLACE);
	}

	/**
	 * 设置时间格式
	 * setDateFormate(DateUtil.ddd);
	 * @param dateFormat 
	 * @author 
	 *	<ul>
	 *	 <li>高文相  2014  年  9月 22 日 新增<li>
	 *	<ul>
	 */
	public JsonUtil setDateFormate(String dateFormt) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormt);
		objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(sdf);  
		return this;  
	}

}


