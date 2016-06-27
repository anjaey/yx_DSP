package com.hy.util.tglib;

import javax.servlet.jsp.JspException;

/**
 * 翻页标签
 * @author linw
 *
 */
public class PageTag extends PageBaseTag {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1611127770071634786L;

	@Override
	public int doEndTag() throws JspException {
		try {
			//如果传入的当前页数大于总页数,设置当前页面为总页数
			if (queryPage.getTargetPage() > queryPage.getPageCount()) {
				queryPage.setTargetPage(queryPage.getPageCount());
			}
			//如果传入的当前页数小于等于0,设置当前页面为第一页
			else if (queryPage.getTargetPage() <= 0) {
				queryPage.setTargetPage(1); 
			}
			
			StringBuffer sb = new StringBuffer();
			
			if (queryPage.getTargetPage() > 1) {
				sb.append("<a href=\""+getPreviousPagePath()+"\" class=\"dataPage_last\" direction=\"last\">< 上一页</a>");
			} else {
				sb.append("<a class=\"dataPage_last\" direction=\"last\">< 上一页</a>");
			}
			
			int startNum = 1;    // 开始页数
			int endNum = 1;    // 结束页数
			
			int num = queryPage.getPageCount() - queryPage.getTargetPage();
			if (num >= 9) {
				endNum = queryPage.getTargetPage() + 5;
				
				startNum = endNum - 9;
				if (startNum < 1) {
					startNum = 1;
					
					if (endNum < 9) {
						endNum = 10;
					}
				}
				
			} else {
				endNum = queryPage.getPageCount();
				
				startNum = endNum - 9;
				if (startNum < 1) {
					startNum = 1;
				}
			}
			
			for (int i = startNum; i<=endNum; i++) {
				if (i == queryPage.getTargetPage()) {
					sb.append("<a class=\"dataPage_number dataPage_numberFocus\">" + i + "</a>");
				} else {
					sb.append("<a href=\"" + getNumPagePath(i) + "\" class=\"dataPage_number\">" + i + "</a>");
				}
			}
			
			if (queryPage.getTargetPage() < queryPage.getPageCount()) {
				sb.append("<a href=\"" + getNextPagePath() + "\" class=\"dataPage_next\" direction=\"next\">下一页 ></a>");
			} else {
				sb.append("<a class=\"dataPage_next\" direction=\"next\">下一页 ></a>");
			}
			
			pageContext.getOut().write(sb.toString());
			
		} catch (Exception e) {
			log.error("翻页标签出错！", e);
		}
		return super.doEndTag();
	}
}
