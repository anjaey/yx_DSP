package com.hy.util.page;

import com.hy.util.common.QueryPage;

public class PageDspUtil extends PageUtil {

	public PageDspUtil(QueryPage queryPage) {
		super(queryPage);
	}

	@Override
	public String getContent() {
		
		int targetPage = queryPage.getTargetPage();
		int pageCount = queryPage.getPageCount();
		int pageSize = queryPage.getPageSize();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<a onclick=\"" + getFirstPagePath() + ";\" class=\"dataPage_first\" direction=\"first\">首页</a>");
		
		if (targetPage > 1) {
			sb.append("<a onclick=\"" + getPreviousPagePath() + ";\" class=\"dataPage_prev\" direction=\"prev\">〈&nbsp;&nbsp;</a>");
		} else {
			sb.append("<a class=\"dataPage_prev\" direction=\"prev\">〈&nbsp;&nbsp;</a>");
		}
		
		int startNum = 1;    // 开始页数
		int endNum = 1;    // 结束页数
		
		int num = pageCount - targetPage;
		if (num >= 9) {
			endNum = targetPage + 5;
			
			startNum = endNum - 9;
			if (startNum < 1) {
				startNum = 1;
				
				if (endNum < 9) {
					endNum = 10;
				}
			}
			
		} else {
			endNum = pageCount;
			
			startNum = endNum - 9;
			if (startNum < 1) {
				startNum = 1;
			}
		}
		
		for (int i = startNum; i<=endNum; i++) {
			if (i == targetPage) {
				sb.append("<a class=\"dataPage_number dataPage_numberFocus\">" + i + "</a>");
			} else {
				sb.append("<a onclick=\"" + getNumPagePath(i) + ";\" class=\"dataPage_number\">" + i + "</a>");
			}
		}
		
		if (targetPage < pageCount) {
			sb.append("<a onclick=\"" + getNextPagePath() + ";\" class=\"dataPage_next\" direction=\"next\">&nbsp;&nbsp;〉</a>");
		} else {
			sb.append("<a class=\"dataPage_next\" direction=\"next\">&nbsp;&nbsp;〉</a>");
		}
		
		sb.append("<a onclick=\"" + getLastPagePath() + ";\" class=\"dataPage_last\" direction=\"last\">末页</a>");
		
		
		sb.append("<span class=\"dataPage_sum\">");
		sb.append("共<span>" + queryPage.getRecordCount() + "</span>条记录，每页显示");
		
		sb.append("<select onchange=\"pg_checkPageSize(this);\">");
		if (pageSize == 50) {
			sb.append("<option>20</option>");
			sb.append("<option selected=\"selected\">50</option>");
		} else {
			sb.append("<option selected=\"selected\">20</option>");
			sb.append("<option>50</option>");
		}
		sb.append("</select>条");
		sb.append("</span>");
		
		sb.append(getCheckPageSizeJS());

		sb.append("<input type=\"hidden\" name=\"queryPage.targetPage\" id=\"pg_targetPage\" value=\"" + targetPage + "\" />");
		sb.append("<input type=\"hidden\" name=\"queryPage.pageSize\" id=\"pg_pageSize\" value=\"" + pageSize + "\" />");
		
		
		return sb.toString();
	}
}
