package com.hy.util.mail;

import javax.servlet.ServletContext;

/**
 * 密码设置 邮件内容
 * @author linw
 *
 */
public class MailContentSetPwd extends MailContent {

	public MailContentSetPwd(ServletContext servletContext) {
		super(servletContext);
	}
	
	// 域名
	private String doMainName;
	
	// 设置密码url
	private String setPwdUrl;
	
	// 邮箱
	private String email;
	
	@Override
	protected void initVelocityContext() {
		velocityContext.put("doMainName", doMainName);
		velocityContext.put("setPwdUrl", setPwdUrl);
		velocityContext.put("email", email);
	}

	public String getDoMainName() {
		return doMainName;
	}

	public void setDoMainName(String doMainName) {
		this.doMainName = doMainName;
	}

	public String getSetPwdUrl() {
		return setPwdUrl;
	}

	public void setSetPwdUrl(String setPwdUrl) {
		this.setPwdUrl = setPwdUrl;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
