/**
 * 时间对象的格式化
 * @param date
 * @param format
 * @returns
 */
function formatDate(date, format) {
    /* 
     * eg:format="yyyy-MM-dd hh:mm:ss"; 
     */  
    var o = {  
        "M+" : date.getMonth() + 1, // month  
        "d+" : date.getDate(), // day  
        "h+" : date.getHours(), // hour  
        "m+" : date.getMinutes(), // minute  
        "s+" : date.getSeconds(), // second  
        "q+" : Math.floor((date.getMonth() + 3) / 3), // quarter  
        "S" : date.getMilliseconds()  
        // millisecond  
    }  
  
    if (/(y+)/.test(format)) {  
        format = format.replace(RegExp.$1, (date.getFullYear() + "").substr(4  
                        - RegExp.$1.length));  
    }  
  
    for (var k in o) {  
        if (new RegExp("(" + k + ")").test(format)) {  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1  
                            ? o[k]  
                            : ("00" + o[k]).substr(("" + o[k]).length));  
        }  
    }  
    return format;  
}

/**
 * 时间对象的格式化
 * 默认：yyyy-MM-dd hh:mm:ss
 * @param date
 * @returns
 */
function formatDate2(date) {
	var format = formatDate(date, "yyyy-MM-dd hh:mm:ss");
    return format;  
}

/**
 * 字符串转换时间
 */
function parseDate(dateStr) {  
    var date = eval('new Date(' + dateStr.replace(/\d+(?=-[^-]+$)/, function (a) { 
    	return parseInt(a, 10) - 1;
    }).match(/\d+/g) + ')');  
    return date;  
}

/**
 * 传入一个日期和间隔秒数，取到想要的日期
 * @param date
 * @param second 秒数
 */
function changeSecond(date, second) {
	var time = date.getTime();
	time += second * 1000;
	return new Date(time);
}

/**
 * 传入一个日期和间隔分钟数，取到想要的日期
 * @param date
 * @param minute 分钟数
 */
function changeMinute(date, minute) {
	var num = minute * 60;
	return changeSecond(date, num);
}

/**
 * 传入一个日期和间隔小时数，取到想要的日期
 * @param date
 * @param hour 小时数
 */
function changeHour(date, hour) {
	var num = hour * 60;
	return changeMinute(date, num);
}

/**
 * 传入一个日期和间隔天数，取到想要的日期
 * @param date
 * @param hours 天数
 */
function changeDay(date, day) {
	var num = day * 24;
	return changeHour(date, num);
}

/**
 * 传入数字（毫秒）转换时间str
 * @param millisecond 毫秒
 * @returns {String}
 */
function getTimeByMillisecond(millisecond) {
	if (millisecond < 0) {
		millisecond = 0;
	}
	var days = Math.floor(millisecond/(3600*24));
	var hours = Math.floor((millisecond-days*24*3600)/3600);   
	var minutes = Math.floor((millisecond-days*24*3600-hours*3600)/60);   
	var seconds = Math.floor(millisecond%60);   
	var msg = days+"天"+hours+"时"+minutes+"分"+seconds+"秒";
	return msg;
}

/**
 * 传入数字（秒）转换时间str
 * @param second
 * @returns {String}
 */
function getTimeBySecond(second) {
	var millisecond = second / 1000;
	return getTimeByMillisecond(millisecond);
}

/**
 * 获取最大时间
 * @param start_id 开始时间ID
 * @param end_id 结束时间ID
 * @param maxDay 最大天数
 */
function getMaxDate(start_id, end_id, maxDay) {
	
	var start_obj = $("#" + start_id);
	var end_obj = $("#" + end_id);
	
	var start = start_obj.val();
	var end = end_obj.val();
	
	var start_date = parseDate(start);
	var end_date = parseDate(end);
	
	var end_date_temp = changeDay(start_date, maxDay);
	
	if (end_date > end_date_temp) {
		end_obj.val(formatDate(end_date_temp, "yyyy-MM-dd"));
	}
}