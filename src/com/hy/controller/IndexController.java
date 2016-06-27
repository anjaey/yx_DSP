package com.hy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hy.controller.common.BaseController;

/**
 * 主页跳转 以及其他跳转方法
 * @author hy
 *
 */
@Controller
public class IndexController extends BaseController{
	
	/**
	 * 跳转官网
	 * @author hy
	 * @date 2016年4月29日下午4:13:19
	 * @return
	 * @update
	 * @date
	 */
	@RequestMapping("/")
	public ModelAndView toadminIndex() {
		return forwardPage("index");
	}
	
	/**
	 * 跳转到登录页面
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/official/login")
	public ModelAndView tologin() {
		return forwardPage("official/login");
	}
	
	/**
	 * 跳转到后台主页页面
	 * @author hy
	 * @date 2016年5月3日下午5:54:48
	 * @update
	 * @date
	 */
	@RequestMapping(value = "/admin/toadminindex")
	public ModelAndView toadminindex() {
		return forwardPage("admin/index");
	}
}

