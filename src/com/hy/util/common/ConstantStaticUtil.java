package com.hy.util.common;

/**
 * 常量 静态
 *
 * @author linw
 */
public interface ConstantStaticUtil {
	
	/**
	 * 上传 广告主资质 文件 地址
	 */
	public final static String UPLOAD_CREDENTIALS_URL_FILE_PATH = "/upload/advertiser/file";
	
	/**
	 * 上传 创意 图片 地址
	 */
	public final static String UPLOAD_CREATIVE_URL_IMG_PATH = "/upload/creative/img";
	
	/**
	 * 上传 用户 图片 地址
	 */
	public final static String UPLOAD_USER_URL_IMG_PATH = "/upload/user/img";
	
	/**
	 * 用户状态
	 */
	public final static String USERBASIC_STATE_LIST = "USERBASIC_STATE_LIST";
	// 1：激活
	public final static String USERBASIC_STATE_1 = "1";
	// 2：锁定
	public final static String USERBASIC_STATE_2 = "2";
	// 3：未激活
	public final static String USERBASIC_STATE_3 = "3";
	

	/**
	 * DSP 状态
	 */
	public final static String DSP_INFO_STATUS_LIST = "DSP_INFO_STATUS_LIST";
	// 0：失效
	public final static String DSP_INFO_STATUS_0 = "0";
	// 1：生效
	public final static String DSP_INFO_STATUS_1 = "1";
	/**
	 * DSP 创意是否需要审核（0：不需要，1：需要）
	 */
	public final static String DSP_INFO_IS_CREATIVE_CHECK_LIST = "DSP_INFO_IS_CREATIVE_CHECK_LIST";
	// 0：不需要
	public final static String DSP_INFO_IS_CREATIVE_CHECK_0 = "0";
	// 1：需要
	public final static String DSP_INFO_IS_CREATIVE_CHECK_1 = "1"; 
	
	/**
	 * 广告主 资质状态
	 */
	public final static String ADVERTISER_CREDENTIALS_STATUS_LIST = "ADVERTISER_CREDENTIALS_STATUS_LIST";
	// 0：已提交
	public final static String ADVERTISER_CREDENTIALS_STATUS_0 = "0";
	// 1：未提交
	public final static String ADVERTISER_CREDENTIALS_STATUS_1 = "1";
	
	/**
	 * 广告主 资质审核状态
	 */
	public final static String ADVERTISER_CREDENTIALS_CHECK_STATUS_LIST = "ADVERTISER_CREDENTIALS_CHECK_STATUS_LIST";
	// 0：待审核
	public final static String ADVERTISER_CREDENTIALS_CHECK_STATUS_0 = "0";
	// 1：审核成功
	public final static String ADVERTISER_CREDENTIALS_CHECK_STATUS_1 = "1";
	// 2：审核失败
	public final static String ADVERTISER_CREDENTIALS_CHECK_STATUS_2 = "2";
	
	
	/**
	 * 创意 审核状态
	 */
	public final static String CREATIVE_STATUS_LIST = "CREATIVE_STATUS_LIST";
	// 0：审核中
	public final static String CREATIVE_STATUS_0 = "0";
	// 1：审核成功
	public final static String CREATIVE_STATUS_1 = "1";
	// 2：审核失败
	public final static String CREATIVE_STATUS_2 = "2";
	
	/**
	 * 创意 流量类型
	 */
	public final static String CREATIVE_TRAFFIC_TYPE_LIST = "CREATIVE_TRAFFIC_TYPE_LIST";
	// 创意 流量类型 list 一期 只有PC端流量和移动端流量
	public final static String CREATIVE_TRAFFIC_TYPE_LIST1 = "CREATIVE_TRAFFIC_TYPE_LIST1";
	// 1：web
	public final static String CREATIVE_TRAFFIC_TYPE_1 = "1";
	// 2：mobile
	public final static String CREATIVE_TRAFFIC_TYPE_2 = "2";
	// 3：video
	public final static String CREATIVE_TRAFFIC_TYPE_3 = "3";
	
	/**
	 * 创意 创意类型
	 */
	public final static String CREATIVE_CREATIVE_TYPE_LIST = "CREATIVE_CREATIVE_TYPE_LIST";
	// 1：图片
	public final static String CREATIVE_CREATIVE_TYPE_1 = "1";
	// 2：flash
	public final static String CREATIVE_CREATIVE_TYPE_2 = "2";
	// 3：视频
	public final static String CREATIVE_CREATIVE_TYPE_3 = "3";
	
	
	/**
	 * 日志 类型 list
	 */
	public final static String LOG_TYPE_LIST = "LOG_TYPE_LIST";
	// 增加
	public final static String LOG_TYPE_1 = "1";
	// 修改
	public final static String LOG_TYPE_2 = "2";
	// 查询
	public final static String LOG_TYPE_3 = "3";
	// 删除
	public final static String LOG_TYPE_4 = "4";
	
	/**
	 * 日志 表 list
	 */
	public final static String LOG_TABLE_LIST = "LOG_TABLE_LIST";
	// DSP
	public final static String LOG_TABLE_DSP_INFO = "DSP_INFO";
	
	// 广告主
	public final static String LOG_TABLE_ADVERTISER = "ADVERTISER";
	
	/**
	 * 日志 字段 list
	 */
	public final static String LOG_COLUMN_LIST = "LOG_COLUMN_LIST";
	// DSP : IP设置
	public final static String LOG_COLUMN_DSP_INFO_LIMIT_IP = "LIMIT_IP";
	// DSP : Web端流量控制数
	public final static String LOG_COLUMN_DSP_INFO_WEB_TRAFFIC_CONTROL = "WEB_TRAFFIC_CONTROL";
	// DSP : 移动端流量控制数
	public final static String LOG_COLUMN_DSP_INFO_MOBILE_TRAFFIC_CONTROL = "MOBILE_TRAFFIC_CONTROL";
	// DSP : 视频流量控制数
	public final static String LOG_COLUMN_DSP_INFO_VIDEO_TRAFFIC_CONTROL = "VIDEO_TRAFFIC_CONTROL";
	// DSP : 状态
	public final static String LOG_COLUMN_DSP_INFO_STATUS = "STATUS";
	
	// 广告主 : 客户资质审核状态
	public final static String LOG_COLUMN_ADVERTISER_CREDENTIALS_CHECK_STATUS = "CREDENTIALS_CHECK_STATUS";
	
	/**
	 * 用户 
	 */
	//列 list
	public final static String LOG_COLUMN_USER_LIST = "LOG_COLUMN_USER_LIST";
	//表明
	public final static String LOG_TABLE_USER_INFO = "USER_INFO";
	//状态
	public final static String LOG_COLUMN_USER_STATE = "USER_STATE";
	//姓名
	public final static String LOG_COLUMN_USER_COMPELLATION = "USER_COMPELLATION";
	//是否删除
	public final static String LOG_COLUMN_USER_ISDELETE = "USER_ISDELETE";
	//qq
	public final static String LOG_COLUMN_USER_QQ = "USER_QQ";
	//微信
	public final static String LOG_COLUMN_USER_WECHAT = "USER_WECHAT";
	//手机号
	public final static String LOG_COLUMN_USER_MOBILEPHONE = "USER_MOBILEPHONE";
	//联系邮箱
	public final static String LOG_COLUMN_USER_CONNECTION_EMIAL = "USER_CONNECTION_EMIAL";
	//三国花名
	public final static String LOG_COLUMN_USER_EPITHET = "USER_EPITHET";
	//角色
	public final static String LOG_COLUMN_USER_ROLE = "USER_ROLE";
	
	
	/**
	 * 汇款记录
	 */
	//表名
	public final static String LOG_TABLE_REMITTANCE_RECORD = "REMITTANCE_RECORD";
	// 汇款时间
	public final static String LOG_COLUMN_REMITTANCE_TIME = "REMITTANCE_TIME";
	//汇款金额
	public final static String LOG_COLUMN_REMITTANCE_MONEY = "REMITTANCE_MONEY";
	//状态
	public final static String LOG_COLUMN_REMITTANCE_STATE = "REMITTANCE_STATE";
	
	/**
	 * 月账单
	 */
	//表名
	public final static String LOG_TABLE_FINANCIAL_RESULTS = "FINANCIAL_RESULTS";
	// 实际消费金额
	public final static String LOG_COLUMN_FINANCIAL_RESULTS_REALSPENDING_MONEY = "FINANCIAL_RESULTS_REALSPENDING_MONEY";
	// 发票状态
	public final static String LOG_COLUMN_FINANCIAL_RESULTS_INVOICE_STATE = "FINANCIAL_RESULTS_INVOICE_STATE";
	// 到期时间
	public final static String LOG_COLUMN_FINANCIAL_RESULTS_BILLEXPIRE_TIME = "FINANCIAL_RESULTS_BILLEXPIRE_TIME";
	// 账单状态
	public final static String LOG_COLUMN_FINANCIAL_RESULTS_STATE = "FINANCIAL_RESULTS_BILLEXPIRE_STATE";
	// 发布状态	
	public final static String LOG_COLUMN_FINANCIAL_RESULTS_BILLEXPIRE_ISSUEDSTATE = "FINANCIAL_RESULTS_BILLEXPIRE_ISSUEDSTATE";
	
	
	/**
	 * 行业分类映射
	 */
	//表名
	public final static String LOG_TABLE_DSP_SORTMAPPING = "DSP_SORTMAPPING";
	// DSP映射名称
	public final static String LOG_COLUMN_DSP_SORTMAPPING_MAPPING_NAME = "SORTMAPPING_MAPPING_NAME";
	// DSP映射ID
	public final static String LOG_COLUMN_DSP_SORTMAPPING_MAPPING_ID = "SORTMAPPING_MAPPING_ID";
	
	/**
	 *	角色
	 */
	//表名
	public final static String LOG_TABLE_ROLE_INFO = "ROLE_INFO";
	// 角色名称
	public final static String LOG_COLUMN_ROLE_INFO_NAME = "ROLE_INFO_NAME";
	// 权限
	public final static String LOG_COLUMN_ROLE_INFO_PERMISSIONS = "ROLE_INFO_PERMISSIONS";
	
	
}

