package com.hy.constant;

public class ApiConstant {

	public static class Response {
		public static final int STATUS_TOKEN_ERR = -1;
		public static final int STATUS_ERR = 0;
		public static final int STATUS_SUC = 1;
	}

	public static class Dsp {
		
		/**
		 * redis DSP 创意 存放index 
		 */
		public final static Integer REDIS_DB_DSP_INDEX = 1;
		
		/**
		 * dsp每秒钟请求次数保存在redis中的过期时间，单位：秒
		 */
		public final static int DSP_REQUESTS_EXPIRATION_TIME = 1;

		/**
		 * 请求dsp超时时间 单位：秒
		 */
		public final static int REQUESTDSP_TIME_OUT = 500;

		/**
		 * 不需要流量控制
		 */
		public final static int NO_LIULIANG_CONTROLLER = 1;

		/**
		 * dsp存储在redis当中的key
		 */
		public final static String DSP_REDIS_KEY = "dsp";

		/**
		 * 中互联dspid
		 */
		public final static String DSP_ID_ZHL = "10001";

		/**
		 * 中互联返回值表示不参与竞价的代码
		 */
		public final static Integer DSP_NOBIDDING_ZHL = 0;

		/**
		 * 中互联竞价计算因子
		 */
		public final static Integer DSP_BIDDING_PRICE_ZHL = 10000;

		/**
		 * dsp响应超时
		 */
		public final static Integer DSP_BIDDING_RESPONSE_STATUS_TEIME_OUT = 0;

		/**
		 * dsp响应结果解析错误
		 */
		public final static Integer DSP_BIDDING_RESPONSE_STATUS_PARSE_ERROR = 1;

		/**
		 * dsp响应无效竞价
		 */
		public final static Integer DSP_BIDDING_RESPONSE_STATUS_INVOID = 2;

		/**
		 * dsp响应结果有效竞价，但非最高价
		 */
		public final static Integer DSP_BIDDING_RESPONSE_STATUS_NOHIGHESTPRICE = 3;

		/**
		 * 最高价
		 */
		public final static Integer DSP_BIDDING_RESPONSE_NOHIGHESTPRICE = 0;

		/**
		 * 不是最高价
		 */
		public final static Integer DSP_BIDDING_RESPONSE_HIGHESTPRICE = 0;

		/**
		 * dsp竞价成功后接受通知的地址和格式
		 */
		public final static String WIN_NOTICE_URL = "${H_URL}?impid=${AUCTION_IMP_ID}&bidimpid=${AUCTION_BID_ID}&price=${AUCTION_PRICE}";

		/**
		 * 从数据库中得到所有dsp信息的sql
		 */
		public final static String SQL_GETALLDSP = "SELECT dsp_id,token,limit_ip,current_key,check_key,web_traffic_control,video_traffic_control,mobile_traffic_control,rtb_url,effective_status,win_notice_url FROM adx_dsp_info WHERE status = 1 ";

		/**
		 * 从数据库中进行dsp的token验证的sql
		 */
		public final static String SQL_DSP_AUTH = "	SELECT dsp_id FROM adx_dsp_info WHERE dsp_id = ? AND token = ? AND status = 1 ";

	}

	public static class Creative {
		
		/**
		 * redis 数据库 创意 存放index 
		 */
		public final static Integer REDIS_DB_CREATIVE_INDEX = 2;

		/**
		 * 从数据库中根据dsp得到所属创意的sql
		 */
		public final static String SQL_GETCREATIVES_BYDSP = " SELECT c.creative_id, c.traffic_type, c.creative_type, c.target_url, c.click_url, c.advert_id, c.monitor_url, c.height, c.weight, c.creative_address, c.creative_app_name, c.creative_app_down_url, c.creative_app_des, c.creative_app_size, a.id, ad.id, ad.dsp_id FROM adx_creative c INNER JOIN adx_advertiser a ON c.advertiser_id = a.id INNER JOIN adx_dsp_info ad ON ad.id = a.dsp_id WHERE c. STATUS = 1 AND ad.dsp_id =? ";

	    /**
	     * 新增创意sql
	     */
		public final static String SQL_INSERT_ONE = "insert into adx_creative (creative_id,advertiser_id,traffic_type,creative_type,target_url,click_url,advert_id,monitor_url,height,weight,creative_address,creative_app_name,creative_app_down_url,creative_app_des,creative_app_size,create_time,status,dsp_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		/**
		 * 新增创意时的初始化状态
		 */
		public final static int INSERT_INIT_STATUS = 0;
		
	 
		
		/**
		 * 创建成功
		 */
		public final static int INSERT_SUCCESS = 1;
		
		/**
		 * 重复创建
		 */
		public final static int INSERT_REPEATED = -2;
		
		/**
		 * 未知原因创建失败
		 */
		public final static int INSERT_UNKNOWN = -3;
		
		/**
		 * token验证失败
		 */
		public final static int INSERT_TOKEN = -4;
		
		/**
		 * 广告主id或者dspid不存在
		 */
		public final static int INSERT_NODSPORAD= -6;
		
	}
	
	public static class Advertiser{
		/**
		 * 超出一次限制创建条数
		 */
		public final static int CREATE_AD_LIMITED = -1;
		
		/**
		 * 创建成功
		 */
		public final static int CREATE_AD_SUCCESS = 1;
		
		/**
		 * 重复创建
		 */
		public final static int CREATE_AD_REPEATED = -2;
		
		/**
		 * 未知原因创建失败
		 */
		public final static int CREATE_AD_UNKNOWN = -3;
		
		/**
		 * 参数解析错误
		 */
		public final static int CREATE_AD_PARSE= -5;
		
		/**
		 * 一次创建广告主的条数限制
		 */
		public final static int CREATE_AD_LIMIT = 5;
		
		/**
		 * 创建广告主sql
		 */
		public final static String CREATE_AD_SQL = "insert into adx_advertiser (advertiser_id,name,credentials_name,web_name,web_url,telphone,address,create_time,dsp_id) values (?,?,?,?,?,?,?,?,?)";
	    
		/**
		 * 根据dsp传过来的的广告主id得到adx平台的唯一id
		 */
		public final static String GETAD_BYDSP_SQL = "select id from adx_advertiser where advertiser_id = ? and dsp_id = ? ";
	}

	public static class Ssp {

		/**
		 * ssp响应码 成功
		 */
		public final static int SSP_RESPONSE_SUCCESS = 1;

		/**
		 * ssp响应码 失败
		 */
		public final static int SSP_RESPONSE_FAILE = -1;

		/**
		 * ssp响应码 无效竞价
		 */
		public final static int SSP_RESPONSE_INVALID = 0;

	}
	
	
	public static class Kafka{
		public final static String BIDDING_TOPC = "testtopic";
	}

}
