package com.hy.util.velocity;

import java.io.File;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityUtils {
	
	protected static Log log = LogFactory.getLog(VelocityUtils.class);

	private VelocityEngine velocityEngine;
	
	private VelocityContext velocityContext = new VelocityContext();
	
	// res 路径
	private String reaPath;
	// 模板路径
	private String vmPath;
	
	// 模板名称
	private String template;
	
	public VelocityUtils(ServletContext servletContext, String vmPath) throws Exception {
		reaPath = servletContext.getRealPath("WEB-INF" + File.separator + "res");
		this.vmPath = vmPath;
		
		this.initVelocityEngine();
	}
	
	/**
	 * Velocity引擎初始化
	 * @throws EmailException
	 */
	public void initVelocityEngine() throws Exception {
		try {
			velocityEngine = new VelocityEngine();
			velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, reaPath + vmPath);
			velocityEngine.setProperty("runtime.log.logsystem.class","org.apache.velocity.runtime.log.NullLogSystem");
			velocityEngine.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
			velocityEngine.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
			velocityEngine.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");   
			velocityEngine.init();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/**
	 * 按照模板格式获取需要发送的邮件内容
	 * @return
	 * @throws Exception
	 */
	public String getContent() throws Exception {
		
		try {
			
			Template t = velocityEngine.getTemplate(template);
			StringWriter writer = new StringWriter();
			t.merge(velocityContext, writer);
			
			return writer.toString();
		} catch (Exception e){
			log.error(e);
			throw e;
		}
	}

	public VelocityContext getVelocityContext() {
		return velocityContext;
	}

	public void setVelocityContext(VelocityContext velocityContext) {
		this.velocityContext = velocityContext;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
