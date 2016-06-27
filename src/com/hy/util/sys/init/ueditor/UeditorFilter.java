package com.hy.util.sys.init.ueditor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UeditorFilter implements Filter {

	@Override
	public void destroy() {
		//  Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getRequestURI();
		System.out.println(url);
		if (url.contains("/common/js/ueditor/jsp/")) {
			chain.doFilter(req, res);
		}else{
			chain.doFilter(req, res);
		}
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//  Auto-generated method stub
		
	}
	

}