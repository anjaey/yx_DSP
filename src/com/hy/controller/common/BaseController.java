package com.hy.controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.hy.dao.mybatis.model.Userbasic;
import com.hy.model.Response;
import com.hy.util.common.ConstantUtil;
import com.hy.util.common.JsonUtil;
import com.hy.util.common.QueryPage;
import com.hy.util.page.PageAdxUtil;
import com.hy.util.page.PageUtil;
import com.hy.util.velocity.VelocityUtils;

public class BaseController {
	protected static Log log = LogFactory.getLog(BaseController.class);
	
	/**
	 * BaseController父类注入
	 */
	protected HttpServletRequest request = null;

	/**
	 * BaseController父类注入
	 */
	protected static HttpServletResponse response = null;
	
	/**
	 * 绑定参数前缀
	 * @param binder
	 */
	@InitBinder("queryPage")    
    public void initBinderQueryPage(WebDataBinder binder) {    
		binder.setFieldDefaultPrefix("queryPage.");    
    }
	
	/**
	 * 得到在session中登录的userid
	 * @author hy
	 * @date 2016年6月16日下午5:06:37
	 * @return
	 * @update
	 * @date
	 */
	public Integer getSessionLoginUserid() {
		Userbasic userbasic = (Userbasic) this.request.getSession().getAttribute(ConstantUtil.SESSION_LOGIN_USER);
		int userid = userbasic.getId();
		return userid;
	}
	
	/**
	 * 注入请求
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	protected void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	/**
	 * 初始化并设置分页对象和值
	 * 
	 * @author hy
	 * @date 2016年5月17日下午4:12:03
	 * @param vmname  vm 文件名称
	 * @param vmPath  vm 文件路径
	 * @param listmap  值
	 * @param queryPage  分页对象
	 * @throws Exception
	 * @update
	 * @date
	 */
	public Map<String, Object> initpage(String vmname, String vmPath, List<Map<String, Object>> listmap, QueryPage queryPage) throws Exception {
		Map<String, Object> map = new HashMap<>();
		VelocityUtils velocityUtils = new VelocityUtils(request.getServletContext(), vmPath);
		velocityUtils.setTemplate(vmname);
		velocityUtils.getVelocityContext().put("datalist", listmap);
		String content = velocityUtils.getContent();
		
		PageUtil pageUtil = new PageAdxUtil(queryPage);
		String queryPageStr = pageUtil.getContent();
		
		map.put("data", content);
		map.put("queryPageStr", queryPageStr);
		return map;
	}
	
	/**
	 * 初始化路径,存入全局变量
	 * @param request
	 * @param response
	 * @param model
	 */
	@ModelAttribute
	public void initPath(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String base = request.getContextPath();

		String fullPath = request.getScheme() + "://" + request.getServerName() + base;
		model.addAttribute("base", base);
		model.addAttribute("fullPath", fullPath);
	}
	
	/**
	 * BaseController 将JSON数据写出到页面
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @param jsonStr 需要的JSON字符串
	 */
	protected void writeJson(Object jsonObj) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html");
			out = response.getWriter();
			String jsonStr = null;
			if (jsonObj instanceof String) {
				jsonStr = jsonObj.toString();
			} else {
				jsonStr = JsonUtil.ObjectToJson(jsonObj);
			}
			
			out.write(jsonStr);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			log.error("将结果JSON数据写出到页面时出错!", e);
		}
	}
	
	/**
	 * BaseController 将JSON数据写出到页面, 重载的一个方法,如果是JSON字符串,可以直接调这个方法
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @param jsonStr 需要的JSON字符串
	 */
	protected void writeJsonStr(String jsonStr) {
		PrintWriter out = null;
		try {
			out = this.response.getWriter();
			out.write(jsonStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			log.error("将结果JSON数据写出到页面时出错!", e);
		}
	}
	
	/**
	 * 增 、删 、改时JSON 提示
	 *
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @param altName     json KEY
	 * @param value	  json value
	 * @version 0.0.1
	 */
	protected void writeJson(String altName,Object value){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(altName, value);
		
		String json = JsonUtil.ObjectToJson(map);
		writeJson(json);
	}
	
	/**
	 * 获取当前session
	 * 
	 * @return 返回session
	 */
	protected HttpSession getSession() {
		return request.getSession();
	}
	
	/**
	 * 获取某个session值列表
	 * @param key 需要获取的session
	 * @return
	 */
	protected Object getAttribute(String key) {
		HttpSession session = getSession();
		return session.getAttribute(key);
	}
	
	/**
	 * 设置session值
	 * @param key 需要获取的session
	 */
	protected void setAttribute(String key, Object obj) {
		HttpSession session = getSession();
		session.setAttribute(key, obj);
	}
	
	/**
	 * 删除session值
	 * @param key 需要删除的session KEY
	 */
	protected void removeAttribute(String key) {
		HttpSession session = getSession();
		session.removeAttribute(key);
	}
	
	/**
	 * 生成 ModelandView  供返回页面 
	 * @param page
	 * @return
	 * @date 2015年7月24日上午10:42:51
	 */
	
	protected ModelAndView forwardPage(String page) {
		return new ModelAndView(page);
	}
	
	/**
	 * 通用异常处理
	 * 
	 * @param view
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = Throwable.class)
	public Object exceptionHandler(Throwable exception,HttpServletRequest request,HttpServletResponse response) {
		exception.printStackTrace();
		//log.error(EXPTION_ATTENTION + request.getRequestURI());
		//LOGGER.error(exception.getMessage());
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("error", "请求错误");
//		result.put("msg", exception.getMessage());
//		result.put("response", new HashMap<String,String>(1));
////		response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
//		System.err.println("result = "+result);
		Response re = new Response();
		re.setError("请求错误");
		re.setResponse(exception.getMessage());
		re.setStatus(-2);
		return com.hy.util.common.JsonUtils.toJson(re);
	}
	
	protected String success(Map<String, Object> vals,int status) {
		Response response = new Response();
		response.setError("");
		response.setResponse("");
		response.setStatus(status);
		return com.hy.util.common.JsonUtils.toJson(response);
	}
	
//	private Object ok(Map<String, Object> result) {
//		/*MappingJackson2JsonView view = new SecurityMappingJackson2JsonView();*/
//		ModelAndView modelAndView = new ModelAndView("", result);
//		return modelAndView;
//	}

}
