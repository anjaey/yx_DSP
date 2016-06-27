package com.hy.controller.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hy.util.common.AuthImage;
import com.hy.util.common.ConstantUtil;

/**
 * 公共控制器
 * @author hy
 *
 */
@Controller
public class CommonController extends BaseController {

	/**
	 * 生成验证码图片
	 * @author hy
	 * @date 2016年5月10日下午2:03:09
	 * @update
	 * @date
	 */
	@RequestMapping("/function/common/img/createimg")
	public void createimg(){
		try {
			AuthImage.createImg(this.request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	
//	/**
//	 * 生成找回密码验证码图片
//	 * @author hy
//	 * @date 2016年5月10日下午2:03:09
//	 * @update
//	 * @date
//	 */
//	@RequestMapping("/function/common/img/createimgtoGetpwd")
//	public void createimgtoGetpwd(@RequestParam Map<String, Object> map){
//		try {
//			//返回验证码值
//			Object obj = AuthImage.createImg(this.request, response);
//			this.getSession().setAttribute(ConstantUtil.GET_PWD_IMGSESSIONID, obj);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 判断登录的验证码是否超过3次 超过三次就显示验证码。
	 * @author hy
	 * @date 2016年5月20日下午6:27:13
	 * @update
	 * @date
	 */
	@RequestMapping("/function/common/img/loginReCaptchaShow")
	public void loginReCaptchaShow() {
		//目前暂时一次性得到ＤＳＰ　和　ＳＳＰ　的 次数
		//如果客户端是DSP 的 就取DSP  反之。
		Object postcountadx = this.getSession().getAttribute(ConstantUtil.RECAPTCHA_NUM);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postcountadx", postcountadx);
		this.writeJson(map);
	}
}
