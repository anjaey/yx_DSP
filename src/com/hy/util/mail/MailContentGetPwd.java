package com.hy.util.mail;

import javax.servlet.ServletContext;

/**
 * 密码设置 邮件内容
 * @author linw
 *
 */
public class MailContentGetPwd extends MailContent {

	public MailContentGetPwd(ServletContext servletContext) {
		super(servletContext);
	}
	
	// 域名
	private String doMainName;
	
	// 设置密码url
	private String getPwdurl;
	
	// 邮箱
	private String email;
	
	@Override
	protected void initVelocityContext() {
		velocityContext.put("doMainName", doMainName);
		velocityContext.put("getPwdurl", getPwdurl);
		velocityContext.put("email", email);
	}

	public String getDoMainName() {
		return doMainName;
	}

	public void setDoMainName(String doMainName) {
		this.doMainName = doMainName;
	}

	public String getGetPwdUrl() {
		return getPwdurl;
	}

	public void setGetPwdUrl(String setPwdUrl) {
		this.getPwdurl = setPwdUrl;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
