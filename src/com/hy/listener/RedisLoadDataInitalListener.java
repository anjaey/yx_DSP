package com.hy.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.ContextLoaderListener;

import com.hy.dao.common.impl.CommonDaoImpl;

//@WebListener
public class RedisLoadDataInitalListener extends ContextLoaderListener{
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		CommonDaoImpl commonDaoImpl = (CommonDaoImpl) ctx.getBean("commonDaoImpl");
		RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) ctx.getBean("redisTemplate");
		Object sqls = ctx.getBean("sql");
		
		System.out.println("sql = "+sqls);
		String sql = "select * from adx_creative";
		try {
			 List<Map<String, Object>>  result = commonDaoImpl.selectList(sql, null);
			 System.out.println(" result "+result);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.contextInitialized(event);
	}

}
