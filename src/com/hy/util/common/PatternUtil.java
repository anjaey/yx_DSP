package com.hy.util.common;

import java.util.regex.Pattern;

/**
 * 正则表达式检查
 * 
 * ^ 开始
 * $ 结束
 * 
 * \d : 0-9
 * \w : 0-9 a-z A-Z _
 * 
 * + : 1次到多次
 * * : 0次到多次
 * ? : 0次或1次
 * 
 * @author linw
 */
public class PatternUtil {

	/**
	 * 固定电话
	 * @param str
	 * @return
	 */
	public static boolean matchesFixedPhone(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "(\\d{3,4}-?)[1-9]\\d{7}";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 固定电话（全数字）
	 * @param str
	 * @return
	 */
	public static boolean matchesFixedPhone2(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "(\\d{3,4})[1-9]\\d{7}";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 移动电话
	 * @param str
	 * @return
	 */
	public static boolean matchesMobilePhone(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "[1]\\d{10}";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 移动电话
	 * @param str
	 * @param section 号码段 格式 : 139|151|189
	 * @return
	 */
	public static boolean matchesMobilePhone(String str, String section) {
		boolean result = false;
		if(str != null && section != null) {
			String regex = "(" + section + ")\\d{8}$";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 邮政编码
	 * @param str
	 * @return
	 */
	public static boolean matchesPostCode(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "\\d{6}";
			result = Pattern.matches(regex, str);
		}
		return result;
		
	}
	
	/**
	 * 邮箱
	 * @param str
	 * @return
	 */
	public static boolean matchesEmail(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "\\w+[@]\\w+[.]\\w+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 中文汉字
	 * @param str
	 * @return
	 */
	public static boolean matchesChinese(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "[\\u4e00-\\u9fa5]+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 中文汉字 不包含
	 * @param str
	 * @return
	 */
	public static boolean matchesChineseNotIn(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "[^\\u4e00-\\u9fa5]+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 英文
	 * @param str
	 * @return
	 */
	public static boolean matchesEnglish(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "[a-zA-Z]+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 网址
	 * @param str
	 * @return
	 */
	public static boolean matchesUrl(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "([a-zA-Z]+(://))?((\\w)+(.))?(\\w)+(.)(\\w)+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * ipv4
	 * @param str
	 * @return
	 */
	public static boolean matchesIPv4(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 身份证
	 * @param str
	 * @return
	 */
	public static boolean matchesIDcards(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\\d{3}(x|X))|(\\d{4}))";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 数字整数（大于等于0）
	 * @param str
	 * @return
	 */
	public static boolean matchesNumber(String str) {
		boolean result = false;
		if (str != null) {
			String regex = "[0-9]+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 数字（大于等于0）
	 * @param str
	 * @param num 几位小数
	 * @return
	 */
	public static boolean matchesNumber(String str, int num) {
		boolean result = false;
		if (str != null) {
			String regex = "^\\d+(\\.[0-9]{0," + num + "})?$";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 验证金额
	 * @param dou	
	 * @return
	 */
	public static boolean matchesMoney(Double dou){
		return matchesNumber(String.valueOf(dou), 2);
	}
	
	/**
	 * 英文 + 中文
	 * @param str
	 * @return
	 */
	public static boolean matchesEnAndCn(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "[\\u4E00-\\u9FA5a-zA-Z]+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 英文 + 数字
	 * @param str
	 * @return
	 */
	public static boolean matchesEnAndNum(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "[a-zA-Z0-9]+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
	
	/**
	 * 英文 + 数字 + 中文
	 * @param str
	 * @return
	 */
	public static boolean matchesEnAndNumAndCn(String str) {
		boolean result = false;
		if(str != null) {
			String regex = "[\\u4e00-\\u9fa5a-zA-Z0-9]+";
			result = Pattern.matches(regex, str);
		}
		return result;
	}
}
