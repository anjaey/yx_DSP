package com.hy.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式转换，处理工具
 */
public class DateUtils {
	
	
	/**
	 * 按照指定的格式，将日期类型对象转换成字符串，例如：yyyy-MM-dd,yyyy/MM/dd,yyyy/MM/dd hh:mm:ss
	 * @param date
	 * @param pattern 格式
	 * @return
	 */
	public static String formatDate(Date date,String pattern){
		SimpleDateFormat formater=new SimpleDateFormat(pattern);
		return formater.format(date);
	}
	
	/**
	 * 按照指定的格式，将字符串转换成日期类型对象，例如：yyyy-MM-dd,yyyy/MM/dd,yyyy/MM/dd hh:mm:ss
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String dateStr,String pattern){
		SimpleDateFormat formater=new SimpleDateFormat(pattern);
		try {
			return formater.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将字符串（yyyy-MM-dd）解析成日期
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate(String dateStr){
		return parseDate(dateStr,"yyyy-MM-dd");
	}
	
	/**
	 * 将字符串（yyyy-MM-dd HH:mm:ss）解析成日期
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate2(String dateStr){
		return parseDate(dateStr,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取当前年份
	 * @return
	 */
	public static int getCurrentYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * 获取当前月份
	 * @return
	 */
	public static int getCurrentMonth(){
		return Calendar.getInstance().get(Calendar.MONTH)+1;
	}
	
/*	*//**
	 * 比较两个日期相差的天数
	 * @param d1 
	 * @param d2 
	 * @param hour 相差的小时 
	 * @return
	 *//*
	public static long getDayDiffer(Date d1,Date d2,int hour){
	    long rel =d2.getTime()-d1.getTime();
	    return Math.abs(rel/(1000*60*60*hour));
	}*/
	
	/**
	 * 比较两个日期相差的秒
	 * @param d1 
	 * @param d2 
	 * @param hour 相差的秒
	 * @return
	 */
	public static long getSencondDiffer(Date d1,Date d2){
	    long rel =d2.getTime()-d1.getTime();
	    return Math.abs(rel/(1000));
	}
	
	/**
     * 时间比较, 比较到日
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 0表示相同, 正数是date1 > date2, 负数是date1 < date2
     */
    public static int compareToDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date1).compareTo(sdf.format(date2));
    }
    
    /**
     * 时间比较, 比较到时
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 0表示相同, 正数是date1 > date2, 负数是date1 < date2
     */
    public static int compareToHour(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        return sdf.format(date1).compareTo(sdf.format(date2));
    }

    /**
     * 时间比较, 比较到秒
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 0表示相同, 正数是date1 > date2, 负数是date1 < date2
     */
    public static int compareToSecond(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date1).compareTo(sdf.format(date2));
    }

    /**
     * 取得所给的日期的日开始时间(00:00:00,000)
     *
     * @param day 要转换的日期
     * @return 日开始时间
     */
    public static Date getStartDateOfDay(Date day) {
        if (day == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

    /**
     * 取得所给的日期的日结束时间(23:59:59,000)
     *
     * @param day 要转换的日期
     * @return 日结束时间
     */
    public static Date getEndDateOfDay(Date day) {
        if (day == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        return cal.getTime();
    }

    /**
     * 取得所给的日期的月开始时间(00:00:00,000)
     *
     * @param day 要转换的日期
     * @return 月开始时间
     */
    public static Date getStartDateOfMonth(Date day) {
        if (day == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 取得所给的日期的月结束时间(23:59:59,000)
     *
     * @param day 要转换的日期
     * @return 月结束时间
     */
    public static Date getEndDateOfMonth(Date day) {
        if (day == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 取得所给的日期的年开始时间(00:00:00,000)
     *
     * @param day 要转换的日期
     * @return 年开始时间
     */
    public static Date getStartDateOfYear(Date day) {
        if (day == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        return cal.getTime();
    }

    /**
     * 取得所给的日期的年结束时间(23:59:59,000)
     *
     * @param day 要转换的日期
     * @return 年结束时间
     */
    public static Date getEndDateOfYear(Date day) {
        if (day == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }

    /**
     * 根据年月日创建的日期
     *
     * @param year  年 如2006年为2006
     * @param month 月 如12月为 11
     * @param day   日 如15日为15
     * @return 日期
     */
    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 根据年月日创建的日期
     *
     * @param year   年 如2006年为2006
     * @param month  月 如12月为 11
     * @param day    日 如15日为15
     * @param hour   小时 24时格式 如下午2点为 14
     * @param minute 分钟 如25分为25
     * @param second 秒 如30秒位30
     * @return 日期
     */
    public static Date getDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    /**
     * 取得年数字
     *
     * @param date 日期
     * @return 年数字
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 取得月数字,一月为 0
     *
     * @param date 日期
     * @return 月数字
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    /**
     * 取得日数字
     *
     * @param date 日期
     * @return 日数字
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 计算开始日期和结束日期中间相差几个月
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 相差几个月
     */
    public static int calculateMonthDistance(Date start, Date end) {
        int year1 = getYear(start);
        int year2 = getYear(end);
        int month1 = getMonth(start);
        int month2 = getMonth(end);
        return 12 * (year1 - year2) + (month1 - month2);
    }

    /**
     * 计算开始日期和结束日期中间相差多少天
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 相差多少天
     */
    public static int calculateDayDistance(Date start, Date end) {
        long startTimeInMillis = start.getTime();
        long endTimeInMillis = end.getTime();
        return (int) ((startTimeInMillis - endTimeInMillis) / (1000 * 60 * 60 * 24));
    }

    /**
     * 得到现在的时间
     *
     * @return Date
     */
    public static Date now() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 得到现在的时间, 以秒的形式
     *
     * @return long
     */
    public static long nowInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * 当前时间以指定格式传换成文字.
     *
     * @param pattern 格式
     * @return 文字
     */
    public static String nowInFormat(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(Calendar.getInstance().getTime());
    }
    
    /**
     * 获取传入日期的后一个月的日期
     * @param dateStr 日期
     * @param pattern 格式 例yyyy-MM-dd yyyy-MM
     */
    @SuppressWarnings("deprecation")
	public static String nowAfterMouth(String dateStr, String pattern){
		Date date = DateUtils.parseDate(dateStr,pattern);
		date.setMonth(date.getMonth() + 1);
        String datestr2 = DateUtils.formatDate(date, pattern);
        return datestr2;
	}
    
    /**
     * 取当前日期的前一个月的日期
     */
	public static String nowBeforeMouth(){
		//String dateStr = DateUtils.nowInFormat("yyyy-MM-dd");
		//Date now =DateUtils.parseDate(dateStr);
		Calendar c = Calendar.getInstance();
        c.setTime(new Date());   //设置当前日期
        c.add(Calendar.MONTH, -1); //日期加1
        Date date2 = c.getTime(); //结果
        String datestr2=DateUtils.formatDate(date2, "yyyy-MM-dd");
        return datestr2;
	}
	
	/**
	 * 传入一个日期和间隔天数，取到想要的日期
	 */
	public static Date changeDays(Date date,int count)
	{
		Date date1=(Date)date;
		//String dateStr = DateUtils.nowInFormat("yyyy-MM-dd");
		//Date now =DateUtils.parseDate(dateStr);
		Calendar c = Calendar.getInstance();
        c.setTime(date1);   //设置当前日期
        c.add(Calendar.DATE, count); //日期加1
        Date date2 = c.getTime(); //结果
        return date2;
	}
	/**
	 * 传入一个日期和间隔天数，取到想要的日期
	 */
	public static Date changeDays(String date,int count)
	{
		Date date1=(Date)parseDate(date);
		//String dateStr = DateUtils.nowInFormat("yyyy-MM-dd");
		//Date now =DateUtils.parseDate(dateStr);
		Calendar c = Calendar.getInstance();
        c.setTime(date1);   //设置当前日期
        c.add(Calendar.DATE, count); //日期加1
        Date date2 = c.getTime(); //结果
        return date2;
	}
	
	/**
	 * 传入一个日期和间隔天数，取到想要的日期
	 */
	public static Date changeHours(Date date,int count)
	{
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.HOUR, count); //小时加1
        Date date2 = c.getTime(); //结果
		return date2; 
	}
	
	/**
	 * 传入一个日期和间隔分钟数，取到想要的日期时间
	 */
	public static Date changeMinute(Date date,int count)
	{
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.MINUTE, count); //加上间隔时间的分钟数
        Date date2 = c.getTime(); //结果
		return date2; 
	}
	/**
	 * 传入一个日期和间隔天数，取到想要的日期
	 */
	public static Date changeMonth(Date date,int count)
	{
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.MONTH, count); //月加1
        Date date2 = c.getTime(); //结果
		return date2; 
	}
	
	/**
	 * 传入一个日期和间隔天数，取到想要的日期
	 */
	public static Date changeYear(Date date,int count)
	{
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.YEAR, count); //年加1
        Date date2 = c.getTime(); //结果
		return date2; 
	}
	
	/**
	 * 传入一个日期和  秒数,取到想要的日期,如果是负数是减，正数是增加
	 * @param date
	 * @return
	 */
	public static Date changeSecond(Date date, int count) {    
	    Calendar calendar = Calendar.getInstance();    
	    calendar.setTime(date);    
	    calendar.add(Calendar.SECOND, count);    
	    return calendar.getTime();    
	} 
	/**
	 * 传入一个日期和  秒数,取到想要的日期,如果是负数是减，正数是增加
	 * @param date
	 * @return
	 */
	public static Date changeSecond(String date, int count) {  
		Date date1=(Date)parseDate(date);
	    Calendar calendar = Calendar.getInstance();    
	    calendar.setTime(date1);    
	    calendar.add(Calendar.SECOND, count);    
	    return calendar.getTime();    
	}
	
	/**
	 * 检查当前时间是否在配置时间之内
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean checkDate(Date startDate, Date endDate) {
		boolean result = false;
		if(startDate != null && endDate != null) {
			Date nowDate = DateUtils.now();
			if(DateUtils.compareToSecond(nowDate, startDate) > 0
					&& DateUtils.compareToSecond(endDate, nowDate) > 0) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 检查当前时间是否在配置时间之内(2个时间可以都为null)
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean checkDate2(Date startDate, Date endDate) {
		boolean result = false;
		if(startDate != null && endDate != null) {
			Date nowDate = DateUtils.now();
			if(DateUtils.compareToSecond(nowDate, startDate) > 0
					&& DateUtils.compareToSecond(endDate, nowDate) > 0) {
				result = true;
			}
		} else if(startDate == null && endDate != null) {
			Date nowDate = DateUtils.now();
			if(DateUtils.compareToSecond(endDate, nowDate) > 0) {
				result = true;
			}
		} else if(startDate != null && endDate == null) {
			Date nowDate = DateUtils.now();
			if(DateUtils.compareToSecond(nowDate, startDate) > 0) {
				result = true;
			}
		} else {
			result = true;
		}
		return result;
	}
	
	
	
	/**
	 * 获取倒计时字符串  (date2 - date1)
	 * @param date1		
	 * @param date2	
	 * @return
	 */
	public static String getCountdownStr(Date date1,Date date2) {
		long nd = 24*60*60;//一天的秒数
		long nh = 60*60;//一小时的秒数
		long nm = 60;//一分钟的秒数
		long ns = 1;//一秒钟的毫秒数long diff;try {
		//获得两个时间的毫秒时间差异
		long diff = getSencondDiffer(date2, date1);
		long day = diff/nd;//计算差多少天
		long hour = diff%nd/nh;//计算差多少小时
		long min = diff%nd%nh/nm;//计算差多少分钟
		long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
		StringBuffer strBuf = new StringBuffer();
		if(day>0)
			strBuf.append(day).append("天");
		if(hour>=0)
			strBuf.append(hour).append("小时");
		if(min>=0)
			strBuf.append(min).append("分钟");
		if(sec>=0)
			strBuf.append(sec).append("秒");
		return strBuf.toString();
	}
	
	/**
	 * 获取本周一
	 * @param date
	 * @return
	 */
	public static Date getNowWeekMonday(Date date) {    
       Calendar cal = Calendar.getInstance();    
       cal.setTime(date);    
       cal.add(Calendar.DAY_OF_MONTH, -1); //解决周日会出现 并到下一周的情况    
       cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);    
       return cal.getTime();    
    }
	
	
	/**
	 * 获取上周一
	 * @param date
	 * @return
	 */
	public static Date getLastWeekMonday(Date date) {    
       Date a = DateUtils.changeDays(date, -1);    
       Calendar cal = Calendar.getInstance();    
       cal.setTime(a);    
       cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周    
       cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);    
       return cal.getTime();    
   }
	/**
	 * 获取上周日
	 * @param date
	 * @return
	 */
	public static Date getLastWeekSunday(Date date) {    
       Date a = DateUtils.changeDays(date, -1);    
       Calendar cal = Calendar.getInstance();    
       cal.setTime(a);    
       cal.set(Calendar.DAY_OF_WEEK, 1);    
       return cal.getTime();    
    }
	
	
	
}
