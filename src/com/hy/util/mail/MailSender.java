package com.hy.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 邮件发送核心类
 * @author linw
 *
 */
public class MailSender implements Runnable {

	private static Log log = LogFactory.getLog(MailSender.class);
	
	private static ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("mail");
	
	/**
	 * 邮件发送内容
	 */
	private MailContent mailContent;
	
	@Override
	public void run() {
		String type = resourceBundle.getString("mail.sender.type");
		if (StringUtils.isBlank(type)) {
			log.error("邮件发送失败！请在base.properties中配制发送邮件类型(属性名：mail.sender.type 值：lotus/smtp");
			return;
		}
		try {
			sendMail(mailContent, type);
		} catch (Exception e) {
			log.error("邮件发送失败！", e);
		}
	}
	
	/**
	 * 发送邮件
	 * @author linw
	 * @date 2016年5月7日下午2:34:11
	 * @param mailContent
	 * @param type lotus,smtp
	 * @throws Exception
	 */
	public void sendMail(MailContent mailContent, String type) throws Exception {
		if ("smtp".equalsIgnoreCase(type)) {
			sendMailWithSMTP(mailContent);
		} else if ("lotus".equalsIgnoreCase(type)) {
			sendMailWithLotus(mailContent);
		}  
	}
	
	/**
	 * 以SMTP方式发送邮件
	 * @param mailContent
	 * @throws Exception
	 */
	private void sendMailWithSMTP(MailContent mailContent) throws Exception {
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		sender.setHost(resourceBundle.getString("mail.smtp.host"));
		sender.setUsername(resourceBundle.getString("mail.smtp.username"));
		sender.setPassword(resourceBundle.getString("mail.smtp.password"));
		sender.setPort(Integer.parseInt(resourceBundle.getString("mail.smtp.port")));
		sender.setProtocol(resourceBundle.getString("mail.smtp.protocol"));
		
		InternetAddress address = new InternetAddress();
		address.setAddress(resourceBundle.getString("mail.smtp.from"));
		try {
			address.setPersonal(mailContent.getPersonal());
		} catch (UnsupportedEncodingException e) {
			log.error(e);
			throw e;
		}
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
		
		try {
			
			mimeMessageHelper.setFrom(address);
			
			String to = mailContent.getTo();
			if (to.indexOf(";") != -1) {
				mimeMessageHelper.setTo(to.split(";"));
			} else {
				mimeMessageHelper.setTo(to);
			}
			
			mimeMessageHelper.setSubject(mailContent.getSubject());
			
			String text = mailContent.getContent();
			mimeMessageHelper.setText(text, true);
			
		} catch (MessagingException e) {
			log.error(e);
			throw e;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		
		sender.send(mimeMessage);
	}

	/**
	 * 以lotus方式发送邮件
	 * 
	 * @param mailContent
	 * @throws EmailException
	 */
	private void sendMailWithLotus(MailContent mailContent) throws Exception {
		
	}

	public MailContent getMailContent() {
		return mailContent;
	}

	public void setMailContent(MailContent mailContent) {
		this.mailContent = mailContent;
	}

	public static ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}
