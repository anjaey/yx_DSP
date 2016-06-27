package com.hy.util.tglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 翻页标签
 * @author linw
 *
 */
public class PageParamTag extends TagSupport {

	private static final long serialVersionUID = -8963957071950556995L;
	
	private String name;
	
	private String value;
	
	@Override
	public int doEndTag() throws JspTagException {
		
		Tag tag = (Tag) getParent();
		if (tag instanceof PageTag) {
			PageTag pageTag = (PageTag) tag;
			pageTag.getParamMap().put(name, value);
		} else if (tag instanceof PageWebTag) {
			PageWebTag pageWebTag = (PageWebTag) tag;
			pageWebTag.getParamMap().put(name, value);
		}
	    return EVAL_PAGE;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
