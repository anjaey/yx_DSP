package com.hy.util.tglib;

import javax.servlet.jsp.JspException;

/**
 * 翻页标签 前台
 * @author linw
 *
 */
public class PageWebTag extends PageBaseTag {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6392230922683299077L;

	@Override
	public int doEndTag() throws JspException {
		try {
			
			StringBuffer sb = new StringBuffer();
			
			sb.append("<a href=\"" + getFirstPagePath() + "\" class=\"dataPage_first\" direction=\"first\">首页</a>");
			
			if (queryPage.getTargetPage() > 1) {
				sb.append("<a href=\"" + getPreviousPagePath() + "\" class=\"dataPage_prev\" direction=\"prev\">< 上一页</a>");
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
				sb.append("<a href=\"" + getNextPagePath() + "\" class=\"dataPage_next\" direction=\"next\">&nbsp;&nbsp;〉</a>");
			} else {
				sb.append("<a class=\"dataPage_next\" direction=\"next\">下一页 ></a>");
			}
			
			sb.append("<a href=\"" + getLastPagePath() + "\" class=\"dataPage_last\" direction=\"last\">末页</a>");
			
			
			sb.append("<span class=\"dataPage_sum\">");
			sb.append("共<span>" + queryPage.getRecordCount() + "</span>条记录，每页显示");
			
			sb.append("<select id=\"pg_pageSize\" onchange=\"pg_checkPageSize();\">");
			if (queryPage.getPageSize() == 50) {
				sb.append("<option>20</option>");
				sb.append("<option selected=\"selected\">50</option>");
			} else {
				sb.append("<option selected=\"selected\">20</option>");
				sb.append("<option>50</option>");
			}
			sb.append("</select>条");
			sb.append("</span>");
			
			sb.append("<input type=\"hidden\" id=\"pg_url\" value=\"" + getPagePath() + "\">");
			sb.append(getCheckPageSizeJS());
			
			pageContext.getOut().write(sb.toString());
			
		} catch (Exception e) {
			log.error("翻页标签出错！", e);
		}
		return super.doEndTag();
	}
}
