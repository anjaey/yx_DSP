package com.hy.util.mail;

import java.io.File;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * 该类为抽象类，需要具体发送邮件时，继承此类，并设置from,to,subject,template等属性。
 * 
 * 子类需要实现initVelocityContext（）方法，使用该类的context将具体的内容填入到vm模板中
 * 
 * @author linw
 *
 */
public abstract class MailContent {

	protected static Log log = LogFactory.getLog(MailContent.class);
	
	// 收件人(多个;分割)
	protected String to;
	
	// 邮件内容
	protected String content;
	
	// 发件人
	protected String personal;
	
	// 主题
	protected String subject;
	
	// 使用的邮件模板
	protected String template;
	
	protected VelocityEngine velocityEngine;
	
	protected VelocityContext velocityContext = new VelocityContext();

	private String reaPath;
	private String vmMailPath;
	
	public MailContent(ServletContext servletContext) {
		reaPath = servletContext.getRealPath("WEB-INF" + File.separator + "res");
		vmMailPath = File.separator + "vm" + File.separator + "mail";
	}
	
	/**
	 * 模板内容设置
	 * 通过context.put(key,value)将值赋给vm模板中的变量
	 */
	protected abstract void initVelocityContext();
	
	/**
	 * Velocity引擎初始化
	 * @throws EmailException
	 */
	public void initVelocityEngine() throws Exception {
		try {
			velocityEngine = new VelocityEngine();
			velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, reaPath + vmMailPath);
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
		
		if (template == null) {
			return content;
		}
		
		try {
			initVelocityEngine();
			initVelocityContext();
			
			Template t = velocityEngine.getTemplate(template);
			StringWriter writer = new StringWriter();
			t.merge(velocityContext, writer);
			
			return writer.toString();
		} catch (Exception e){
			throw e;
		}
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
