/**
 * CodeDisplayTag.java
 * Product:Performance
 * Version:1.0
 * Copyright 2009 by DNE
 * All Rights Reserved.
 */
package com.hy.util.tglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hy.util.common.CodeUtil;

/**
 * @author linw
 * 根据code xml文件中的配制的值，显示对应的国际化文本。
 * 例如：
 * <code-type name="Performance_Position">
		<option code="1">程序员</option>
		<option code="2">项目经理</option>
	</code-type>
	
	如果传进来的value=1,name=Performance_Position,该标签将显示程序员
 */
public class CodeDisplayTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7241936785161376026L;
	
	private Log log = LogFactory.getLog(this.getClass());

	private String name;
	
	private String value;
	
	public int doStartTag() throws JspException {
		if (!StringUtils.isBlank(name)){
			String codeValue = CodeUtil.getCodeValue(name, value);
			if (StringUtils.isEmpty(codeValue)) {
				codeValue = "";
				log.error("CodeTag标签出错！(name:" + name + ") (value:" + value + ") 结果为空！");
			}
			try {
				pageContext.getOut().write(codeValue);
			} catch (IOException e) {
				log.error("CodeTag标签出错！", e);
			}
		}
		
		return super.doStartTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
