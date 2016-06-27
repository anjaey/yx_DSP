package com.hy.util.export.value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 竞价报表 set value
 * @author linw
 *
 */
public class BiddingReportSetValue {

	/**
	 * 绑定 竞价参数报表（竞价情况） value list
	 * @param mapList 业务bean集合
	 * @return
	 */
	public static List<String[]> setValueByCon1(List<Map<String, Object>> mapList){
		List<String[]> cellList = new ArrayList<String[]>();
		if (mapList != null && !mapList.isEmpty()) {
			for (Map<String, Object> map : mapList) {
				List<String> lineList = new ArrayList<>();
				
				lineList.add(map.get("CREATE_TIME") == null ? "" : map.get("CREATE_TIME").toString());
				lineList.add(map.get("SUM_DISPLAY") == null ? "" : map.get("SUM_DISPLAY").toString());
				lineList.add(map.get("SUM_CLICK") == null ? "" : map.get("SUM_CLICK").toString());
				lineList.add(map.get("CLICK_RATE") == null ? "" : map.get("CLICK_RATE").toString());
				lineList.add(map.get("AVG_PRICE") == null ? "" : map.get("AVG_PRICE").toString());
				lineList.add(map.get("THOUSAND_PRICE") == null ? "" : map.get("THOUSAND_PRICE").toString());
				lineList.add(map.get("SUM_PRICE") == null ? "" : map.get("SUM_PRICE").toString());
				
				String[] line = lineList.toArray(new String[lineList.size()]);
				cellList.add(line);
			}
		}
		return cellList;
	}
	
	/**
	 * 绑定 竞价参数报表 value list
	 * @param mapList 业务bean集合
	 * @return
	 */
	public static List<String[]> setValueByParam(List<Map<String, Object>> mapList){
		List<String[]> cellList = new ArrayList<String[]>();
		if (mapList != null && !mapList.isEmpty()) {
			for (Map<String, Object> map : mapList) {
				List<String> lineList = new ArrayList<>();
				
				lineList.add(map.get("CREATE_TIME") == null ? "" : map.get("CREATE_TIME").toString());
				lineList.add(map.get("C_CREATIVE_APP_NAME") == null ? "" : map.get("C_CREATIVE_APP_NAME").toString());
				lineList.add(map.get("SUM_REQUESTE") == null ? "" : map.get("SUM_REQUESTE").toString());
				lineList.add(map.get("SUM_BIDDINGS") == null ? "" : map.get("SUM_BIDDINGS").toString());
				lineList.add(map.get("SUM_BIDDING_SUCCESS") == null ? "" : map.get("SUM_BIDDING_SUCCESS").toString());
				
				String line5Str = "0-20ms: " + (map.get("SUM_RESPONSE_TIME_20") == null ? "" : map.get("SUM_RESPONSE_TIME_20").toString()) + "<br/>"
								+ "20-60ms: " + (map.get("SUM_RESPONSE_TIME_60") == null ? "" : map.get("SUM_RESPONSE_TIME_60").toString()) + "<br/>"
								+ "60-90ms: " + (map.get("SUM_RESPONSE_TIME_90") == null ? "" : map.get("SUM_RESPONSE_TIME_90").toString());
				lineList.add(line5Str);
				
				lineList.add(map.get("SUM_BIDDING_ERROR") == null ? "" : map.get("SUM_BIDDING_ERROR").toString());
				
				String line7Str = "响应超时: " + (map.get("SUM_RESPONSE_TIMEOUT") == null ? "" : map.get("SUM_RESPONSE_TIMEOUT").toString()) + "<br/>"
								+ "解析错误: " + (map.get("SUM_PARSE_ERROR") == null ? "" : map.get("SUM_PARSE_ERROR").toString()) + "<br/>"
								+ "解析错误: " + (map.get("SUM_UNEFFECT_BIDDINGS") == null ? "" : map.get("SUM_UNEFFECT_BIDDINGS").toString()) + "<br/>"
								+ "竞价非最高: " + (map.get("SUM_NO_PRICE_HIGHEST") == null ? "" : map.get("SUM_NO_PRICE_HIGHEST").toString());
				lineList.add(line7Str);
				
				lineList.add(map.get("AVG_BIDDING_SUCCESS_RATE") == null ? "" : map.get("AVG_BIDDING_SUCCESS_RATE").toString());
				
				String[] line = lineList.toArray(new String[lineList.size()]);
				cellList.add(line);
			}
		}
		return cellList;
	}
	
	/**
	 * 绑定 竞价参数报表（有效响应时间） value list
	 * @param mapList 业务bean集合
	 * @return
	 */
	public static List<String[]> setValueByParam1(List<Map<String, Object>> mapList){
		List<String[]> cellList = new ArrayList<String[]>();
		if (mapList != null && !mapList.isEmpty()) {
			for (Map<String, Object> map : mapList) {
				List<String> lineList = new ArrayList<>();
				
				lineList.add(map.get("CREATE_TIME") == null ? "" : map.get("CREATE_TIME").toString());
				lineList.add(map.get("SUM_REQUESTE") == null ? "" : map.get("SUM_REQUESTE").toString());
				lineList.add(map.get("SUM_BIDDINGS") == null ? "" : map.get("SUM_BIDDINGS").toString());
				lineList.add(map.get("SUM_BIDDING_SUCCESS") == null ? "" : map.get("SUM_BIDDING_SUCCESS").toString());
				lineList.add(map.get("AVG_BIDDING_SUCCESS_RATE") == null ? "" : map.get("AVG_BIDDING_SUCCESS_RATE").toString());
				
				String[] line = lineList.toArray(new String[lineList.size()]);
				cellList.add(line);
			}
		}
		return cellList;
	}
	
	/**
	 * 绑定 竞价参数报表（竞价未成功） value list
	 * @param mapList 业务bean集合
	 * @return
	 */
	public static List<String[]> setValueByParam2(List<Map<String, Object>> mapList){
		List<String[]> cellList = new ArrayList<String[]>();
		if (mapList != null && !mapList.isEmpty()) {
			for (Map<String, Object> map : mapList) {
				List<String> lineList = new ArrayList<>();
				
				lineList.add(map.get("CREATE_TIME") == null ? "" : map.get("CREATE_TIME").toString());
				lineList.add(map.get("AVG_RESPONSE_TIMEOUT_RATE") == null ? "" : map.get("AVG_RESPONSE_TIMEOUT_RATE").toString());
				lineList.add(map.get("AVG_PARSE_ERROR_RATE") == null ? "" : map.get("AVG_PARSE_ERROR_RATE").toString());
				lineList.add(map.get("AVG_UNEFFECT_BIDDINGS_RATE") == null ? "" : map.get("AVG_UNEFFECT_BIDDINGS_RATE").toString());
				lineList.add(map.get("AVG_NO_PRICE_HIGHEST_RATE") == null ? "" : map.get("AVG_NO_PRICE_HIGHEST_RATE").toString());
				
				String[] line = lineList.toArray(new String[lineList.size()]);
				cellList.add(line);
			}
		}
		return cellList;
	}
	
	/**
	 * 绑定 竞价参数报表（有效响应时间） value list
	 * @param mapList 业务bean集合
	 * @return
	 */
	public static List<String[]> setValueByParam3(List<Map<String, Object>> mapList) {
		List<String[]> cellList = new ArrayList<String[]>();
		if (mapList != null && !mapList.isEmpty()) {
			for (Map<String, Object> map : mapList) {
				List<String> lineList = new ArrayList<>();
				
				lineList.add(map.get("CREATE_TIME") == null ? "" : map.get("CREATE_TIME").toString());
				lineList.add(map.get("SUM_RESPONSE_TIME_20") == null ? "" : map.get("SUM_RESPONSE_TIME_20").toString());
				lineList.add(map.get("SUM_RESPONSE_TIME_60") == null ? "" : map.get("SUM_RESPONSE_TIME_60").toString());
				lineList.add(map.get("SUM_RESPONSE_TIME_90") == null ? "" : map.get("SUM_RESPONSE_TIME_90").toString());
				
				String[] line = lineList.toArray(new String[lineList.size()]);
				cellList.add(line);
			}
		}
		return cellList;
	}
}
