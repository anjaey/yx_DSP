package com.hy.util.common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 关于日期类型转换,获取数据库服务器的时间等的一些通用方法;
 * <ul>
 * <li>1.1</li>
 * <li>增加常用的日期格式变量</li>
 * <li>增加日志记录,级别为debug</li>
 * <li>优化部分代码</li>
 * </ul>
 * 
 * @author 张强 2013年9月16日 22时18分
 * @version 1.1
 */
public class DateUtil {
	static Log log = LogFactory.getLog(DateUtil.class);

	public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss:sss";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY = "yyyy";
	public static final String HH_MM_SS_SSS = "HH:mm:ss:sss";
	public static final String HH_MM_SS = "HH:mm:ss";
	public static final String HH_MM = "HH:mm";
	public static final String HH = "HH";
	
	public static final String PATTERN_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	public static final String PATTERN_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String PATTERN_yyyyMM = "yyyyMM";
	public static final String PATTERN_yyyy = "yyyy";

	/**
	 * 获取整型时间
	 * @param date 传入当前时间
	 * @return 返回LONG型的时间
	 */
	public synchronized static Long dateToFullLong(Date date) {
		String date2String = null;
		try {
			if (date == null){
				return null;
			}
			
			date2String = date2String(date, PATTERN_yyyyMMddHHmmssSSS);
		} catch (Exception e) {
			log.debug("获取整形时间出错!", e);
		}
		return Long.parseLong(date2String);
	}
	
	
	/**
	 * 获取整型时间
	 * @param date 传入当前时间
	 * @return 返回LONG型的时间
	 */
	public static Long dateToTimeLong(Date date) {
		String date2String = null;
		try {
			if (date == null){
				return null;
			}
			
			date2String = date2String(date, PATTERN_yyyyMMddHHmmss);
		} catch (Exception e) {
			log.debug("获取整形时间出错!", e);
		}
		return Long.parseLong(date2String);
	}

	public static void main(String[] args) {
		long tiem = dateToTimeLong(new Date());
		System.out.println(" tiem "+tiem);
	}
	/**
	 * 获取当前时间的INT型数据
	 * @param date 当前时间
	 * @return 返回INT型的时间
	 */
	public synchronized static Integer dateToyyyyMMInteger(Date date) {
		String date2String = null;
		try {
			if (date == null){
				return null;
			}
			
			date2String = date2String(date, PATTERN_yyyyMM);
		} catch (Exception e) {
			log.debug("获取当前时间的INT型数据出错!", e);
		}
		return Integer.parseInt(date2String);
	}
	
	/**
	 * 根据毫秒值得时间字符窜。
	 * @author hy
	 * @date 2016年6月20日上午11:23:14
	 * @param obj
	 * @param datestr
	 * @return
	 * @update
	 * @date
	 */
	public static String getDateStrByLongObj(Object obj, String datestr) {
		if (!CommonUtil.isEmpty(obj)) {
			String createTime = obj.toString();
			Date date = new Date(Long.parseLong(createTime));
			return DateUtil.date2String(date, datestr);
		} else {
			return null;
		}
	}

	/**
	 * 获取当前年度 INT型 
	 * @param date 当前时间
	 * @return 返回年度INT
	 */
	public synchronized static Integer dateToyyyyInteger(Date date) {
		String date2String = null;
		try {
			if (date == null){
				return null;
			}
			
			date2String = date2String(date, PATTERN_yyyy);
		} catch (Exception e) {
			log.debug("获取当前年度 INT型 出错!", e);
		}
		return Integer.parseInt(date2String);
	}

	/**
	 * 将特定的字符串日期转化成日期类型 <br />
	 * 1.需要格式化的字符型日期str <br />
	 * 2.可判断的格式为：yyyy-MM-dd和yyyy-MM-dd HH:mm:ss; <br />
	 * 得到日期型数据
	 * 
	 * @param str
	 *            需要处理的日期型字符串
	 * @return 返回一个日期类型的对象
	 * @see Date
	 * @see SimpleDateFormat
	 * @see StringUtil
	 * @see ParseException
	 * 
	 */
	public static Date str2Date(String str) {
		str=str.replace(".0", "");
		String formatStr = "";
		String reg1 = "^\\d{4}-\\d{1,2}-\\d{1,2}$";
		String reg2 = "^\\d{4}-\\d{1,2}-\\d{1,2}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}$";
		String reg3 = "^\\d{4}-\\d{1,2}";
		if(str.matches(reg1)){
			formatStr = YYYY_MM_DD;
		}
		if(str.matches(reg2)){
			formatStr = YYYY_MM_DD_HH_MM_SS;
		}
		if(str.matches(reg3)){
			formatStr = YYYY_MM;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		
		try {
			if (!StringUtil.isNull(str)) {
				str = StringUtil.str2Trim(str);
				Date date = sdf.parse(str);
				return date;
			}
		} catch (ParseException e) {
			log.debug("字符串日期转化成日期类型时出错!", e);
		} finally {
			sdf = null;
		}
		return null;
	}
	
	/**
	 * 将特定的字符串日期转化成日期类型 <br />
	 * 1.需要格式化的字符型日期str <br />
	 * 2.可判断的格式为：yyyy-MM-dd和yyyy-MM-dd HH:mm:ss; <br />
	 * 得到日期型数据
	 * 
	 * @param str
	 *            需要处理的日期型字符串
	 * @param formatStr
	 *            需要处理成什么格式
	 * @return 返回一个日期类型的对象
	 * @see Date
	 * @see SimpleDateFormat
	 * @see StringUtil
	 * @see ParseException
	 * 
	 */
	public static Date str2Date(String str, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		
		try {
			if (!StringUtil.isNull(str)) {
				str = StringUtil.str2Trim(str);
				Date date = sdf.parse(str);
				return date;
			}
		} catch (ParseException e) {
			log.error("字符串日期转化成日期类型时出错!", e);
		} finally {
			sdf = null;
		}
		return null;
	}

	/**
	 * 将日期型转化为特定格式的字符型日期 <br />
	 * 1.需要的日期date <br />
	 * 2.需要格式化成什么样的字符串formatStr--(yyyy-MM-dd HH:mm:ss); <br />
	 * 得到需要的字符串型日期
	 * 
	 * @param date
	 *            需要处理的日期
	 * @param formatStr
	 *            需要处理成什么样的格式
	 * @return 返回一个日期型的日期类型
	 * @see SimpleDateFormat
	 * @see Date
	 * @see Exception
	 */
	public static String date2String(Date date, String formatStr) {
		SimpleDateFormat sdf = null;
		String formatDate = null;
		try {
			if (date != null) {
				sdf = new SimpleDateFormat(formatStr);
				formatDate = sdf.format(date);
				return formatDate;
			}
		} catch (Exception e) {
			log.debug("日期型转化为特定格式的字符型时出错!!", e);
		} finally {
			sdf = null;
			formatDate = null;
		}
		return null;
	}
	
	/**
	 * 获取日期中的年
	 * 
	 * @param date 需要提取的日期
	 * @return 返回年
	 * @throws Exception
	 */
	public static Integer getYear(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);
		 
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 * 获取日期中的月
	 * 
	 * @param date 需要提取的日期
	 * @return 返回月
	 * @throws Exception
	 */
	public static Integer getMonth(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);
		
		int re = cal.get(Calendar.MONTH);
		return re;
	}
	
	/**
	 * 获取日期中的日
	 * 
	 * @param date 需要提取的日期
	 * @return 返回日
	 * @throws Exception
	 */
	public static Integer getDate(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);
		
		int re = cal.get(Calendar.DATE);
		return re;
	}
	
	/**
	 * 获取日期中的时
	 * 
	 * @param date 需要提取的日期
	 * @return 返回时
	 * @throws Exception
	 */
	public static Integer getHour(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);
		
		int re = cal.get(Calendar.HOUR);
		return re;
	}
	
	/**
	 * 获取日期中的时
	 * 
	 * @param date 需要提取的日期
	 * @return 返回时
	 * @throws Exception
	 */
	public static Integer getMinutes(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);
		
		int re = cal.get(Calendar.MINUTE);
		return re;
	}
	
	/**
	 * 获取日期中的秒
	 * 
	 * @param date 需要提取的日期
	 * @return 返回秒
	 * @throws Exception
	 */
	public static Integer getSeconds(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);
		
		int re = cal.get(Calendar.SECOND);
		return re;
	}
	
	/**
	 * 获取日期中的星期
	 * 
	 * @param date 需要提取的日期
	 * @return 返回星期
	 * @throws Exception
	 */
	public static Integer getWeek(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);
		
		int re = cal.get(Calendar.WEEK_OF_MONTH);
		return re;
	}

	/**
	 * 创 建 人：  zhangyu
	 * 日     期：  2015年8月12日上午10:28:40
	 * 描     述：  类型转换
	 * @param obj
	 * @return
	 * <br>-----------------------------<br>
	 * 修 改 人： 
	 * 日     期： 
	 * 描     述： (注明修改原因) 
	 * <br>-----------------------------<br>
	 */
	public static BigDecimal bigObjConvert(Object obj) {
		if (!CommonUtil.isEmpty(obj)) {
			Double priceLon = Double.valueOf(obj.toString());
			BigDecimal big = BigDecimal.valueOf(priceLon);
			return big;
		} else {
			return BigDecimal.valueOf(0);
		}
	}
	
	/**
	 * 获取时间差
	 * 注:当传入的时间差,不成立时,取最小值
	 * 
	 * @param dateStr 返回相应的时间
	 * @param dateType 0全部返回 1年 2月 3日 4时 5分 6秒 null空视为全部
	 * @return
	 * @throws Exception
	 */
	public static String getDaysDiff(Date nowDate, String dateStr, Integer dateType) throws Exception {
		Date myDate = str2Date(dateStr);
		
		if (nowDate == null) {
			nowDate = new Date();
		}
		
		long yd = 1000 * 24 * 60 * 60 * 30 * 12;// 一年的毫秒数
		long md = 1000 * 24 * 60 * 60 * 30;// 一月的毫秒数
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        
        long diff;
        long year = 0;
        long month = 0;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        
        // 获得两个时间的毫秒时间差异
        diff = myDate.getTime() - nowDate.getTime();
        year = diff / yd;// 计算差多少天
        month = diff / md;// 计算差多少天
        day = diff / nd;// 计算差多少天
        hour = diff % nd / nh + day * 24;// 计算差多少小时
        min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
        sec = diff % nd % nh % nm / ns;// 计算差多少秒
        
        String reStr = null;
        
        switch (dateType) {
		case 0:// 全部
			reStr = year + "年" + month + "月" + day + "日" + hour + "时" + sec + "分" + min + "秒"; 
			break;
		case 1: // 年
			if (year == 0) {
				reStr = getDaysDiff(nowDate, dateStr, (dateType + 1));
			} else {
				reStr = year + "日";
			}
			break;
		case 2: // 月
			if (month == 0) {
				reStr = getDaysDiff(nowDate, dateStr, (dateType + 1));
			} else {
				reStr = month + "月";
			}
			break;
		case 3: // 日
			if (day == 0) {
				reStr = getDaysDiff(nowDate, dateStr, (dateType + 1));
			} else {
				reStr = day + "日";
			}
			break;
		case 4: // 时
			if (hour == 0) {
				reStr = getDaysDiff(nowDate, dateStr, (dateType + 1));
			} else {
				reStr = hour + "小时";
			}
			break;
		case 5: // 分
			if (sec == 0) {
				reStr = getDaysDiff(nowDate, dateStr, (dateType + 1));
			} else {
				reStr = sec + "分";
			}
			break;
		case 6: // 秒
			if (min == 0) {
				reStr = getDaysDiff(nowDate, dateStr, (dateType + 1));
			} else {
				reStr = min + "秒";
			}
			break;
		default:
			break;
		}
		return reStr;
	}
}
