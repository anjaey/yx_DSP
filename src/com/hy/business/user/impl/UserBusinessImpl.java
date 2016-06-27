package com.hy.business.user.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hy.business.user.IUserBusiness;
import com.hy.dao.mybatis.mapper.AdvertiserMapper;
import com.hy.dao.mybatis.mapper.UserbasicMapper;
import com.hy.dao.mybatis.model.Advertiser;
import com.hy.dao.mybatis.model.AdvertiserCriteria;
import com.hy.dao.mybatis.model.Userbasic;
import com.hy.dao.mybatis.model.UserbasicCriteria;
import com.hy.dao.mybatis.model.UserbasicCriteria.Criteria;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.DirUtil;
import com.hy.util.common.ListMapUtil;
import com.hy.util.common.MD5Util;
import com.hy.util.common.UuidUtil;
import com.hy.util.mail.MailContentGetPwd;
import com.hy.util.mail.MailSender;


/**
 * 用户接口实现
 * @author hy
 *
 */
@Service
public class UserBusinessImpl implements IUserBusiness{

	@Autowired
	private UserbasicMapper userbasicMapper;
	@Autowired
	private AdvertiserMapper advertiserMapper;

	/**
	 * 
	 * 验证码判断
	 * @author hy
	 * @date 2016年5月20日下午5:29:36
	 * @param obj  验证码
	 * @param statestr  用户类型
	 * @param returnParam 返回值
	 * @param reqeust 
	 * @return  true  验证码验证成功  false 验证失败 
	 * @update
	 * @date
	 */
	private boolean reCaptcha(Map<String, Object> map, Map<String, Object> returnParam, HttpServletRequest reqeust) {

		Object errorcount = reqeust.getSession().getAttribute(ConstantUtil.RECAPTCHA_NUM);

		if (!CommonUtil.isEmpty(errorcount)) {
			Integer error = (Integer)errorcount;
			if (error > 3) {
				//验证码
				Object obj = map.get("yanzeng");
				//调用验证方法。
				return beginreCaptcha(returnParam, reqeust, obj.toString());
			}
		} else {
			reqeust.getSession().setAttribute(ConstantUtil.RECAPTCHA_NUM, 1);
		}

		return true;
	}

	/**
	 * 开始验证
	 * @author hy
	 * @date 2016年5月20日下午5:38:30
	 * @return
	 * @update
	 * @date
	 */
	public boolean beginreCaptcha(Map<String, Object> returnParam, HttpServletRequest reqeust, String reCaptcha) {		
		Object sessionimg = reqeust.getSession().getAttribute(ConstantUtil.COMMON_IMG_SESSIONID);

		if (CommonUtil.isEmpty(sessionimg)) {
			returnParam.put("state", ConstantUtil.IMG_CODE_NULL);
			return false;
		}

		if (!sessionimg.toString().toLowerCase().equals(reCaptcha.toLowerCase())) {
			returnParam.put("state", ConstantUtil.IMG_CODE_NULL);

			//把验证码设置为kong 防止大量重复请求破坏.
			reqeust.getSession().setAttribute(ConstantUtil.COMMON_IMG_SESSIONID, null);
			return false;
		}

		//验证成功
		return true;
	}

	@Override
	public Map<String, Object> login(Map<String, Object> map, HttpServletRequest reqeust) {
		Map<String, Object> returnParam = new HashMap<String, Object>();

		//验证码验证
//		boolean isok = reCaptcha(map, returnParam, reqeust);
//		if (!isok) {
//			return returnParam;
//		}

		//取出用户名
		Object emailobj = map.get("email");
		if (!CommonUtil.isEmpty(emailobj)) {
			Userbasic userbasic = null;
			UserbasicCriteria userbasicCriteria = new UserbasicCriteria();
			Criteria criteria = userbasicCriteria.createCriteria();
			criteria.andIsdeleteEqualTo(1);
			criteria.andTypeEqualTo(2);  //DSP用户

			String userobjStr = emailobj.toString();  //登录邮箱。
			criteria.andEmailEqualTo(userobjStr);

			userbasic = userbasicMapper.selectByExampleForOne(userbasicCriteria);
			if (!CommonUtil.isEmpty(userbasic)) {
				//用户名符合要求，继续判断。
				String pwd = userbasic.getPwd();
				String pwdstr = map.get("pwd").toString();
				String newpwd = MD5Util.string2MD5(pwdstr);

				if (newpwd.equals(pwd)) {  //密码相同，登录成功
					returnParam.put("state", ConstantUtil.USER_LOGIN_SUCCESS);

					//保存用户信息到session 
					reqeust.getSession().setAttribute(ConstantUtil.SESSION_LOGIN_USER, userbasic);
				} else {  //密码错误， 增加次数。
					pwdErrorThree(reqeust);
					returnParam.put("state",ConstantUtil.USER_LOGIN_USERNAMEORPWDNOT);
				}
			} else {
				pwdErrorThree(reqeust);

				//用户名不存在
				returnParam.put("state", ConstantUtil.USER_LOGIN_USERNAMENOTHINGNESS);
			}
		}
		return returnParam;
	}

	/**
	 * 密码错误3次后的处理方式
	 * @author hy
	 * @date 2016年5月20日下午7:05:42
	 * @update
	 * @date
	 */
	private void pwdErrorThree(HttpServletRequest reqeust) {
		//判断密码输入错误， 超过3次 显示验证码
		Object obj = reqeust.getSession().getAttribute(ConstantUtil.RECAPTCHA_NUM);
		if (!CommonUtil.isEmpty(obj)) {
			int errorindex = (Integer)obj;
			errorindex = errorindex + 1;
			reqeust.getSession().setAttribute(ConstantUtil.RECAPTCHA_NUM, errorindex);
		} else {
			reqeust.getSession().setAttribute(ConstantUtil.RECAPTCHA_NUM, 1);
		}
	}

	@Override
	public Map<String, Object> selectUserInfoByid(Map<String, Object> map) {
		Integer userid = Integer.parseInt(map.get("id").toString());

		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			//查询基本信息
			Userbasic userBasic = userbasicMapper.selectByPrimaryKey(userid);
			returnMap.put("userBasic", ListMapUtil.convertEntityToMap(userBasic));

			//查询DSP详细信息
			AdvertiserCriteria ac = new AdvertiserCriteria();
			ac.createCriteria().andUserIdEqualTo(userid);
			Advertiser advertiser = advertiserMapper.selectByExampleForOne(ac);
			returnMap.put("advertiser", ListMapUtil.convertEntityToMap(advertiser));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnMap;
	}

	public Map<String, Object> updateUserPwd(Map<String, Object> map, Userbasic userbasic) {
		Map<String, Object> retuanmap = new HashMap<String, Object>();
		try {
			Object obj = map.get("oldpwd");
			Object obj1 = map.get("newpwd");
			if (!CommonUtil.isEmpty(obj) && !CommonUtil.isEmpty(userbasic)
					&& !CommonUtil.isEmpty(obj1)) {
				//判断输入密码是否正确
				String pwdstr = userbasic.getPwd();
				String oldpwd = obj.toString();
				oldpwd = MD5Util.string2MD5(oldpwd);
				if (!pwdstr.equals(oldpwd)) {
					retuanmap.put("state", 0);
				} else {
					//修改密码
					String newpwd = MD5Util.string2MD5(obj1.toString());
					userbasic.setPwd(newpwd);
					if (!CommonUtil.isEmpty(userbasic)) {
						userbasicMapper.updateByPrimaryKeySelective(userbasic);
						retuanmap.put("state", 1);
					}
				}
			} else {
				retuanmap.put("state", 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retuanmap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> insertUser(Map<String, Object> map) {
		Map<String, Object> retuanmap = new HashMap<String, Object>();
		try {
			Object userbasicObj = map.get("userbasic");
			Object advertiserObj = map.get("advertiser");

			Map<String, Object> userbasicmap = (Map<String, Object>)userbasicObj;
			Map<String, Object> advertisermap = (Map<String, Object>)advertiserObj;
			if (!CommonUtil.isEmpty(userbasicmap) && 
					!CommonUtil.isEmpty(advertisermap)) {
				Object emailobj = userbasicmap.get("email");

				//判断邮箱是否重复
				UserbasicCriteria uc = new UserbasicCriteria();
				Criteria criteria = uc.createCriteria();
				criteria.andEmailEqualTo(emailobj.toString()); //邮箱。
				criteria.andIsdeleteEqualTo(1);  //未删除的。

				List<Userbasic> listuserBasic = userbasicMapper.selectByExample(uc);
				if (!CommonUtil.isEmpty(listuserBasic) && listuserBasic.size() > 0) {
					//用户名重复
					retuanmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.USER_NAME_REPEATED);
					return retuanmap;
				}

				//添加用户基本表，账号和密码
				Userbasic ub = (Userbasic)ListMapUtil.setEntityValue(userbasicmap, Userbasic.class);

				//把密码加密
				ub.setPwd(MD5Util.string2MD5(ub.getPwd()));
				ub.setType(1);
				ub.setIsdelete(1);
				ub.setCreatetime(new Date().getTime());
				userbasicMapper.insertSelective(ub);

				//用户id
				Integer id = ub.getId();

				//添加用户详情表关联信息
				Advertiser advertiser = (Advertiser)ListMapUtil.setEntityValue(advertisermap, Advertiser.class);
				
				advertiser.setUserId(id);
				advertiser.setCheckState(0); //注册后默认为未审核，未审核不能登录
				advertiser.setAccountState(1);  //注册后默认为启用
				advertiserMapper.insertSelective(advertiser);
				
				retuanmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
			} else {
				retuanmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			retuanmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		}
		return retuanmap;
	}

	@Override
	public Map<String, Object> updatePwdAndtoEmail(Map<String, Object> map, HttpServletRequest reqeust) {
		Map<String, Object> returnmap = new HashMap<String, Object>();

		//判断验证码
		Object imgobj = map.get("imgvalue");
		Object imgobj1 = reqeust.getSession().getAttribute(ConstantUtil.GET_PWD_IMGSESSIONID);
		if (CommonUtil.isEmpty(imgobj) || CommonUtil.isEmpty(imgobj1)) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.IMG_CODE_NULL);
			return returnmap;
		}
		if (!imgobj.toString().toLowerCase().equals(imgobj1.toString().toLowerCase())) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.IMG_CODE_NULL);
			return returnmap;
		}

		//-----------------------其他验证---------------
		Object obj = map.get("userNameOremail");
		if (CommonUtil.isEmpty(obj)) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			return returnmap;
		}
		String usernameOrEmail = obj.toString();
		//判断用户类型。用正则判断
		String emailMatch = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

		Userbasic ub = null;
		UserbasicCriteria uc = new UserbasicCriteria();
		if(usernameOrEmail.matches(emailMatch)) {  //输入的邮箱
			//根据邮箱查询用户信息
			uc.createCriteria().andEmailEqualTo(usernameOrEmail);
			ub = userbasicMapper.selectByExampleForOne(uc);

		} else {
			// 输入的账号
			//根据账号查询邮箱
			Criteria criteria = uc.createCriteria();
			criteria.andUsernameEqualTo(usernameOrEmail);
			criteria.andIsdeleteEqualTo(1); //位删除的
			ub = userbasicMapper.selectByExampleForOne(uc);
		}
		if (CommonUtil.isEmpty(ub)) {  //用户名密码不存在。
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			return returnmap;
		}

		//--------------发送邮箱-----------------------

		//得到当前时间并设置过期时间。
		Timestamp outDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期
		long date = outDate.getTime() / 1000 * 1000;// 忽略毫秒数  mySql 取出时间是忽略毫秒数的

		//设置秘钥key = 用户名+过期时间+key
		//生成秘钥
		String uuid = UuidUtil.generateUUID();
		String key = "email=" + ub.getEmail() + "&time=" + date + "&key=" + uuid;

		//修改过期时间和key
		ub.setGetPwdCode(uuid);
		ub.setGetPwdOuttime(date);
		int rowno = userbasicMapper.updateByPrimaryKeySelective(ub);
		if (rowno == 0) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			return returnmap;
		}

		//生成路径
		String path = "/web/user/getPwdAndToPage/?" + key + "&username=" + ub.getUsername();

		MailContentGetPwd mailContent = new MailContentGetPwd(reqeust.getSession().getServletContext());
		String doMainName = DirUtil.getDirDoMainDsp();

		mailContent.setTemplate("getpwd.vm");
		mailContent.setTo(ub.getEmail());
		mailContent.setSubject("找回密码");
		mailContent.setPersonal("ADX");
		mailContent.setDoMainName(doMainName);
		mailContent.setGetPwdUrl(path);  // 目标连接
		mailContent.setEmail(ub.getEmail());

		MailSender mailSender = new MailSender();
		mailSender.setMailContent(mailContent);
		new Thread(mailSender).start();

		returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		returnmap.put("email", ub.getEmail());
		return returnmap;
	}



	@Override
	public Map<String, Object> getPwdAndToPage(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		//判断是否超时
		Object dateObj = map.get("time");
		Object usernameObj = map.get("username");
		Object keyObj = map.get("key");
		if (CommonUtil.isEmpty(dateObj) || CommonUtil.isEmpty(usernameObj) || CommonUtil.isEmpty(keyObj)) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.GET_NOT_LEGAL);
			return returnmap;
		}

		//请求时间
		long datelong = Long.parseLong(dateObj.toString());
		long newlong = new Timestamp(datelong - 30 * 60 * 1000).getTime();// 30分钟前面
		long oldlong = new Date().getTime();

		if (newlong > oldlong) {  //超时
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.GET_OVER_TIME);
			return returnmap;

		}

		//判断用户名是否正确: 根据用户名 + key 同时查询，保证2个数据统一。
		UserbasicCriteria uc = new UserbasicCriteria();
		Criteria criteria = uc.createCriteria();
		criteria.andUsernameEqualTo(usernameObj.toString());
		criteria.andGetPwdCodeEqualTo(keyObj.toString());
		Userbasic userBasic = userbasicMapper.selectByExampleForOne(uc);
		if (CommonUtil.isEmpty(userBasic)) { //请求不合法。可能会有篡改。
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.GET_NOT_LEGAL);
			return returnmap;
		}

		//验证成功。
		returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		returnmap.put("username", userBasic.getUsername());
		return returnmap;
	}

	@Override
	public Map<String, Object> updateUserPwdByUsername(Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();

		Object usernameobj = map.get("username");
		Object pwdobj = map.get("pwd");
		if (CommonUtil.isEmpty(usernameobj) || CommonUtil.isEmpty(usernameobj)) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			return returnmap;
		}

		Userbasic userBasic = new Userbasic();
		userBasic.setPwd(MD5Util.string2MD5(pwdobj.toString()));
		//把KEY 值修改为空，保证当前修改密码的连接失效
		userBasic.setGetPwdCode("");
		UserbasicCriteria uc = new UserbasicCriteria();
		uc.createCriteria().andUsernameEqualTo(usernameobj.toString());
		userbasicMapper.updateByExampleSelective(userBasic, uc);

		returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		return returnmap;
	}

	@Override
	public Map<String, Object> selectUnalterableUserInfoSessionAndUserInfodata(Map<String, Object> ubsession,
			Map<String, Object> ubdata) {
		Map<String, Object> returnmap = new HashMap<String, Object>();

		if (CommonUtil.isEmpty(ubsession) || CommonUtil.isEmpty(ubdata)) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			return returnmap;
		}

		String sessionpwd = ubsession.get("pwd").toString();
		String datapwd = ubdata.get("pwd").toString();
		String state = ubdata.get("state").toString();
		// 如果密码改变 或者 用户状态非正常是，需要重新登录
		if (!sessionpwd.equals(datapwd) || !"1".equals(state)) {
			returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
			return returnmap;
		}

		returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);	
		return returnmap;
	}

}
