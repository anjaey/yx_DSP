package com.hy.develop.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.hy.util.common.CommonUtil;
import com.hy.util.common.ConstantUtil;

/**
 * 请求,响应前置处理,将他们压入到管理栈中.
 *
 * @author 2014年9月22日 下午3:55:22
 * @version 0.0.1
 */
public class ReqRespToThread extends HandlerInterceptorAdapter {
	
	
	@SuppressWarnings("unused")
	private Log log = LogFactory.getLog(ReqRespToThread.class);

	@Override
	public boolean preHandle(HttpServletRequest request,  
			HttpServletResponse response, Object handler) throws Exception {
		
		Object userobj = request.getSession().getAttribute(ConstantUtil.SESSION_LOGIN_USER);
		if (CommonUtil.isEmpty(userobj)) {  //进入登录页面
			response.sendRedirect(request.getContextPath()+"/official/login");
			return false;
		}
		return true;
	}
	

}
