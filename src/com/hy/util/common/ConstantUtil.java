package com.hy.util.common;

/**
 * 常量池,所有相关常量都写在这
 *
 * @author 张强 2014年9月22日 下午5:26:31
 * @version 0.0.1
 */
public interface ConstantUtil {
	
	/**
	 * 用户导航
	 */
	public String SESSION_NAV_USER = "userNav";

	/**
	 * 请求不合法
	 */
	public String GET_OVER_TIME = "getovertime";
	
	/**
	 * 请求不合法
	 */
	public String GET_NOT_LEGAL = "getnotlegal";
	
	/**
	 * 验证码错误或者失效
	 */
	public String IMG_CODE_NULL = "10";
	
	/**
	 * 找回密码的验证码sessionid
	 */
	public String GET_PWD_IMGSESSIONID = "getpwdimgsessionid";
	
	/**
	 * 验证码信息在session 的id
	 */
	public String COMMON_IMG_SESSIONID = "imgserssion";
	
	/**
	 * 登录错误次数
	 * 
	 */
	public Integer LOGIN_RECAPTCHA_NUM = 3;
	
	/**
	 * 登录时验证码不输入次数
	 */
	public String RECAPTCHA_NUM = "recaptchanumdsp";
	
	/**
	 * 账号密码输入错误次数，关系到是否显示验证码。
	 * 
	 */
	public String POSTCOUNT_login_pwd = "postcountloginpwd";
	
	/**
	 * 默认分页数量
	 */
	public Integer PAGE_SIZI = 10;
	
	/**
	 * CookieUtil工具类,默认生命时间
	 */
	public Integer COOKIE_AGE = 30 * 60 * 60;
	public String COOKIE_USERINFO = "userinfo";
	public String COOKIE_USER_ROLES = "userroles";
	public String COOKIE_USER_DETAIL = "userdetail";
	
	public String JSONUTILE_ISNULL = "(:null,|:NULL,)";
	public String JSONUTILE_REPLACE = 	":\"\",";
	public String JSONUTILE_JSONNULL= "{}" ;
	
	/**
	 * ueditor 上传相关变量
	 */
	public String UEDITOR_UPLOAD_URL = "admin/uedit";

	/**
	 * 配置文件 路径 /config.properties
	 */
	public String CONFIG_PATH = "/config.properties";
	
	/**
	 * 成功的状态
	 */
	public String RETURN_SUCCESS = "1";
	
	/**
	 * 失败的状态
	 */
	public String RETURN_FAIL = "0";
	
	/**
	 * 用户名重复
	 */
	public String USER_NAME_REPEATED = "100";
	
	/**
	 * 登录用户
	 */
	public String SESSION_LOGIN_USER = "sessionLoginUser";
	
	/**
	 * 登录时用户不存在
	 */
	public String USER_LOGIN_USERNAMENOTHINGNESS = "0";
	
	/**
	 * 登录成功
	 */
	public String USER_LOGIN_SUCCESS = "1";
	
	/**
	 * 密码错误
	 */
	public String USER_LOGIN_USERNAMEORPWDNOT = "2";	
	
	/**
	 * 全局设置 返回数据
	 */
	public String SYSTEM_DATA_RETURN = "returned";
	
	/**图片格式：JPG*/
	public  String PICTRUE_FORMATE_JPG = "jpg";
	
	/**
	 * FTP中上传的一些其他类型的文件（logo...）
	 */
	public String FTP_OTHERROOTDIR_NAME = "other";
	
	public String FTP_NOTRESOURCE_DEFAULT = "/res/adx/images/proimg_03.png";
	
	/*返回的map包含的数据*/
	public String RESULT_PRIMARYKEY = "primaryKey";
	
	public String RESULT_ROWS = "rows";
	
	public String RESULT_PAGEINDEX = "pageIndex";
	
	public String RESULT_PAGESIZE = "pageSize";
	
	public String RESULT_ORDERPARAM = "orderParam";
	
	public String RESULT_ORDERRANK = "orderRank";
	
	public String RESULT_ERRORCODE = "errorCode";
	
	public String RESULT_DATA = "list";
	
	public String RESULT_TOTAL = "total";
	
	public String RESULT_COUNTPAGE = "countpage";
	
	public String RESULT_FUZZY = "fuzzy_query";
	
	
}
