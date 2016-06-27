package com.hy.util.page;

import com.hy.util.common.QueryPage;

public class PageAdxUtil extends PageUtil {

	public PageAdxUtil(QueryPage queryPage) {
		super(queryPage);
	}

	@Override
	public String getContent() {
		
		int targetPage = queryPage.getTargetPage();
		int pageCount = queryPage.getPageCount();
		int pageSize = queryPage.getPageSize();
		
		StringBuffer sb = new StringBuffer();
		
		if (targetPage > 1) {
			sb.append("<a onclick=\"" + getPreviousPagePath() + ";\" class=\"dataPage_last\" direction=\"last\">< 上一页</a>");
		} else {
			sb.append("<a class=\"dataPage_last\" direction=\"last\">< 上一页</a>");
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
			sb.append("<a onclick=\"" + getNextPagePath() + ";\" class=\"dataPage_next\" direction=\"next\">下一页 ></a>");
		} else {
			sb.append("<a class=\"dataPage_next\" direction=\"next\">下一页 ></a>");
		}
		
		sb.append("<input type=\"hidden\" name=\"queryPage.targetPage\" id=\"pg_targetPage\" value=\"" + targetPage + "\" />");
		sb.append("<input type=\"hidden\" name=\"queryPage.pageSize\" id=\"pg_pageSize\" value=\"" + pageSize + "\" />");
		
		return sb.toString();
	}

}
