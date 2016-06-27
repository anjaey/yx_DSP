package com.hy.util.common;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CacheMapUtil {
	private static Log log = LogFactory.getLog(CacheMapUtil.class);
	private static Map<String, Object> configPropMap;

	public static Map<String, Object> getConfigPropMap() {
		if (configPropMap == null) {
			try {
				configPropMap = CommonUtil.readToMapString(ConstantUtil.CONFIG_PATH);
			} catch (Exception e) {
				log.error("读取配置文件时出错", e);
			}
		}
		return configPropMap;
	}
	
	
}
