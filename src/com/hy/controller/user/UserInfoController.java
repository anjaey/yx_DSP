package com.hy.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.hy.business.user.IPrivilegeBusiness;
import com.hy.business.user.IRoleBusiness;
import com.hy.business.user.IUserBusiness;
import com.hy.controller.common.FileController;
import com.hy.dao.mybatis.model.Userbasic;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantStaticUtil;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.JsonUtil;
import com.hy.util.common.ListMapUtil;

/**
 * 用户相关控制器
 * @author hy
 *
 */
@Controller("adminUser")
public class UserInfoController extends FileController {

	@Autowired
	IUserBusiness userBusiness;
	@Autowired
	IRoleBusiness roleBusiness;
	@Autowired
	IPrivilegeBusiness privilegeBusiness;
	
	/**
	 * 根据登录用户角色。查询用户导航信息
	 * @author hy
	 * @date 2016年6月27日上午10:17:00
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/user/navinfo/findAll", method = RequestMethod.POST)
	public void findUserNav() {
		Userbasic userbasic = (Userbasic) this.request.getSession().getAttribute(ConstantUtil.SESSION_LOGIN_USER);
		List<Map<String, Object>> listmap = privilegeBusiness.selectNavByLoginUserid(null, userbasic.getId());
		this.writeJson(listmap);
	}
	
	/**
	 * 查看用户的session 状态，
	 * 用户防止用户退出后， 点击浏览器的后退按钮，阻止浏览器缓存页面。
	 * @author hy
	 * @date 2016年5月27日上午10:11:59
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/common/user/session/State", method = RequestMethod.GET)
	public void userInfoSessionState() {
		Map<String, Object> map = new HashMap<String, Object>();
		Object obj = this.getSession().getAttribute(ConstantUtil.COMMON_IMG_SESSIONID);
		if (CommonUtil.isEmpty(obj)) {
			map.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL);
		} else {
			map.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_SUCCESS);
		}
		this.writeJson(map);
	}

	/**
	 * 跳转到注册页面
	 * @author hy
	 * @date 2016年4月29日下午4:13:19
	 * @return
	 * @update
	 * @date
	 */
	@RequestMapping("/official/user/toregister")
	public ModelAndView toregister() {
		return forwardPage("official/register");
	}

	/**
	 * 注册
	 * @author hy
	 * @date 2016年5月5日下午2:26:33
	 * @update advertiser
	 * @date
	 */
	@RequestMapping(value = "/official/user/register", method = RequestMethod.POST)
	public void register(@RequestParam Map<String, Object> map) {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		
	 	String data = map.get("data").toString();
	 	map = JsonUtil.getMapJsonStrMap(data);
		
		//判断验证码
	 	Object obj = map.get("yzm");
	 	Object sessionimg = this.getSession().getAttribute(ConstantUtil.COMMON_IMG_SESSIONID);
	 	if (CommonUtil.isEmpty(obj) || CommonUtil.isEmpty(sessionimg)) {
	 		returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.IMG_CODE_NULL);
			this.writeJson(returnmap);
			return;
	 	}
	 	
	 	//判断验证码是否相等
	 	if (!obj.toString().equals(sessionimg)) {
	 		returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.IMG_CODE_NULL);
			this.writeJson(returnmap);
			return;
	 	}
	 	
	 	
		returnmap = userBusiness.insertUser(map);
		
		this.writeJson(returnmap);
	}

	/**
	 * 跳转到忘记密码第一步页面
	 * @author hy
	 * @date 2016年4月29日下午4:13:19
	 * @return
	 * @update
	 * @date
	 */
	@RequestMapping("/official/index/getpwd1")
	public ModelAndView togetpwd1() {
		return forwardPage("web/adx/getpwd1");
	}
	
	/**
	 * 跳转到忘记密码第二步页面
	 * @author hy
	 * @date 2016年4月29日下午4:13:19
	 * @return
	 * @update
	 * @date
	 */
	@RequestMapping("/official/index/getpwd2")
	public ModelAndView togetpwd2(@RequestParam Map<String, Object> map, Model model) {
		model.addAllAttributes(map);
		return forwardPage("web/adx/getpwd2");
	}
	
	/**
	 * 找回密码 中发邮件
	 * @author hy
	 * @date 2016年5月23日上午10:21:28
	 * @update
	 * @date
	 */
	@RequestMapping("/official/user/getpwdToEmail")
	public void getpwdToEmail(@RequestParam Map<String, Object> map) {
		Map<String, Object> returnmap = userBusiness.updatePwdAndtoEmail(map, this.request);
		this.writeJson(returnmap);
	}
	
	/**
	 * 找回密码 
	 * @author hy
	 * @date 2016年5月23日上午10:21:28
	 * @update
	 * @date
	 */
	@RequestMapping("/official/user/getPwdAndToPage")
	public ModelAndView getPwdAndToPage(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> returnmap = userBusiness.getPwdAndToPage(map);
		
		//把参数攒回去
		model.addAllAttributes(returnmap);
		
		//如果验证成功，跳转到成功页面
		Object obj = returnmap.get(ConstantUtil.SYSTEM_DATA_RETURN);
		String returnState = obj.toString();
		if ("1".equals(returnState)) {
			return forwardPage("web/adx/getpwd3");
		} else {
			//如果失败跳转到失败页面
			return forwardPage("web/adx/getPwdError");
		}
	}
	
	/**
	 * 修改用户密码
	 * @author hy
	 * @date 2016年5月5日下午2:26:33
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/user/updateUserPwd", method = RequestMethod.POST)
	public void updateUserPwd(@RequestParam Map<String, Object> map) {
		//暂时没有处理返回值和状态
		Userbasic userbasic = (Userbasic)this.getSession().getAttribute(ConstantUtil.COMMON_IMG_SESSIONID);
		Map<String, Object> returnmap = userBusiness.updateUserPwd(map, userbasic);
		this.writeJson(returnmap);
	}

	/**
	 * 退出登录
	 * @author hy
	 * @date 2016年5月11日上午10:10:27
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/user/quitLogin", method = RequestMethod.GET)
	public void quitLogin(Model model) {
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 
		response.setDateHeader ("Expires", 0); 
		this.getSession().removeAttribute(ConstantUtil.COMMON_IMG_SESSIONID);
		this.getSession().removeAttribute(ConstantUtil.SESSION_LOGIN_USER);
	}

	/**
	 * 根据用户id查看用户详情
	 * @author hy
	 * @date 2016年5月5日下午2:26:33
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/user/findUserOne", method = RequestMethod.POST)
	public void findUserOne(@RequestParam Map<String, Object> map) {
		if (!CommonUtil.isEmpty(map)) {
			Map<String, Object> userinfo = userBusiness.selectUserInfoByid(map);
			this.writeJson(userinfo);
		}
	}

	/**
	 * 根据session的用户id对比数据库的信息
	 * 查看信息是否改变。
	 * @author hy
	 * @date 2016年5月5日下午2:26:33
	 * @update
	 * @date
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/user/findUserInfoUnalterable", method = RequestMethod.POST)
	public void findUserInfoUnalterable() {
		Map<String, Object> returnmap = new HashMap<String, Object>();
		returnmap.put(ConstantUtil.SYSTEM_DATA_RETURN, ConstantUtil.RETURN_FAIL); // 默认是异常的，
		try {
			Userbasic userbasic = (Userbasic) this.getSession().getAttribute(ConstantUtil.COMMON_IMG_SESSIONID);
			if (!CommonUtil.isEmpty(userbasic)) {
				Map<String, Object> map = ListMapUtil.convertEntityToMap(userbasic);
				Map<String, Object> userinfo = userBusiness.selectUserInfoByid(map);
				Map<String, Object> userBasic = (Map<String, Object>)userinfo.get("userBasic");
				returnmap = userBusiness.selectUnalterableUserInfoSessionAndUserInfodata(
						ListMapUtil.convertEntityToMap(userbasic), userBasic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(returnmap);
	}

	/**
	 * 根据session的用户id查看用户详情
	 * @author hy
	 * @date 2016年5月5日下午2:26:33
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/user/findUserOneBySession", method = RequestMethod.POST)
	public void findUserOneBySession() {
		Map<String, Object> userinfo = new HashMap<String, Object>();
		try {
			Userbasic userbasic = (Userbasic) this.getSession().getAttribute(ConstantUtil.COMMON_IMG_SESSIONID);
			if (!CommonUtil.isEmpty(userbasic)) {
				Map<String, Object> map = ListMapUtil.convertEntityToMap(userbasic);
				userinfo = userBusiness.selectUserInfoByid(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.writeJson(userinfo);
	}
	
	/**
	 * 在session 得到用户信息
	 * @author hy
	 * @date 2016年5月10日下午6:24:11
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/user/findUserOneTopage", method = RequestMethod.GET)
	public ModelAndView findUserOneTopage(Model model) {
		try {
			Userbasic userbasic = (Userbasic) this.getSession().getAttribute(ConstantUtil.COMMON_IMG_SESSIONID);
			if (!CommonUtil.isEmpty(userbasic)) {
				Map<String, Object> map;
				map = ListMapUtil.convertEntityToMap(userbasic);
				Map<String, Object> returnmap = userBusiness.selectUserInfoByid(map);
				model.addAttribute("userinfo", returnmap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.forwardPage("/admin/user/user/myCenter");
	}

	/**
	 * 官网--》用户登录
	 * @author hy
	 * @date 2016年5月4日上午9:57:27
	 * @param map
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/official/user/login", method = RequestMethod.POST)
	public void login(@RequestParam Map<String, Object> map) {
		Map<String, Object> userMap = userBusiness.login(map, this.request);
		this.writeJson(userMap);
	}

	/**
	 * 提交头像 上传文件 json
	 * 
	 * @date 2016年5月9日上午11:25:59
	 */
	@RequestMapping(value = "/admin/user/user/usericoUpload")
	@ResponseBody
	public void submitUserIcoUpload() {
		String suffixType = "BMP,JPG,JPEG,PNG,GIF";
		Map<String, Object> map = uploadProFile(ConstantStaticUtil.UPLOAD_USER_URL_IMG_PATH, suffixType);
		this.writeJson(map);
	}

}

