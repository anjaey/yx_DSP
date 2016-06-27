package com.hy.util.tglib;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 时间格式化（时间戳转换）
 * @author linw
 *
 */
public class FormatDateTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7507544271740126661L;
	
	private Log log = LogFactory.getLog(this.getClass());

	private String pattern;
	
	private Long value;
	
	@Override
	public int doEndTag() throws JspTagException {
		
		try {
			if (value != null) {
				
				if (StringUtils.isEmpty(pattern)) {
					pattern = "yyyy-MM-dd HH:mm:ss";
				}
				
		        SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
		        String dateStr = sdf.format(new Date(value));  
				
				pageContext.getOut().write(dateStr);
			}
		} catch (Exception e) {
			log.error(e);
		}
	    return EVAL_PAGE;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
}
