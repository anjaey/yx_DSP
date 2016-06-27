package com.hy.business.popularizeActivity.impl;

/**
 * 活动管理查询中的sql
 * 
 * @author hy
 *
 */
public class SelectActivitySql {

	/**
	 * 查询字段sql 以及关联语句
	 */
	public static String fileSql = "select a.activity_id, a.name, d.emil, a.start_time,a.end_time, a.create_time from"
		+ " yx_popularize_activity a left join"
		+ " yx_advertiser b on a.create_user = b.id left join"
		+ " yx_advertisement_group_basic c on c.activity_id = a.id left join"
		+ " yx_userbasic d on d.id = b.user_id where and 1=1";
	
	/**
	 * 查询草稿sql
	 * 用户创建推广活动&广告组数量为0时，活动状态为草稿。
	 * 
	 */
	public static String draftSql = " and c.id is null";
	
	/**
	 * 查询已激活sql
	 * 广告组数量>=1&广告创意数量>=1时，活动状态为已激活。
	 * 
	 */
	public static String activatedSql = " and c.id is not null";
	
	/**
	 * 推广中：当前日期在推广日期范围内且广告主资金账户余额不为0时，活动状态为推广中。
	 * 
	 */
	public static String getPromotionSql (String startTime, String endTime) {
		return " and a.start_time >= '' and a.end_time <= '' and b.price > 0";
	}
	
	/**
	 * 推迟：（当前日期在推广日期范围内）&（广告组资金账户余额<=0）时，活动状态为推迟
	 * 
	 */
	public static String postponeSql = " and a.start_time >= '' and a.end_time <= '' and b.price <= 0 a.state = 1";
	
	/**
	 * 已暂停：（广告主进行暂停推广活动操作）或（（当前日期在推广日期范围内）&（消费>=预算））时，活动状态为已暂停
	 * 
	 */
	public static String pauseSql = " and (a.start_time >= '' and a.end_time <= '' and b.price <= 0) or a.state = 0";
	
	/**
	 * 已过期：当前日期大于推广的结束日期时，活动状态为已过期。
	 * 
	 */
	public static String expireSql = " and a.end_time < '结束日期'";
	
}
