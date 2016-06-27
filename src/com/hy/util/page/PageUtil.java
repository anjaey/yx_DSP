package com.hy.util.page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hy.util.common.QueryPage;

public abstract class PageUtil {

	protected Log log = LogFactory.getLog(this.getClass());
	
	protected QueryPage queryPage;
	
	public PageUtil(QueryPage queryPage) {
		this.queryPage = queryPage;
		
		initQueryPage();
	}

	private void initQueryPage() {
		//如果传入的当前页数大于总页数,设置当前页面为总页数
		if (queryPage.getTargetPage() > queryPage.getPageCount()) {
			queryPage.setTargetPage(queryPage.getPageCount());
		}
		//如果传入的当前页数小于等于0,设置当前页面为第一页
		else if (queryPage.getTargetPage() <= 0) {
			queryPage.setTargetPage(1); 
		}
	}
	
	/**
	 * 首页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getFirstPagePath() {
		StringBuffer sb = new StringBuffer();
		sb.append("pg_targetPage_js(1)");
		return sb.toString();
	}
	
	/**
	 * 末页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getLastPagePath() {
		StringBuffer sb = new StringBuffer();
		sb.append("pg_targetPage_js(" + queryPage.getPageCount() + ")");
		return sb.toString();
	}

	/**
	 * 上一页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getPreviousPagePath() {
		StringBuffer sb = new StringBuffer();
		sb.append("pg_targetPage_js(" + (queryPage.getTargetPage() - 1) + ")");
		return sb.toString();
	}
	
	/**
	 * 下一页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getNextPagePath() {
		StringBuffer sb = new StringBuffer();
		sb.append("pg_targetPage_js(" + (queryPage.getTargetPage() + 1) + ")");
		return sb.toString();
	}
	
	/**
	 * 每一个页数
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @param num 页数
	 * @return
	 */
	protected String getNumPagePath(int num) {
		StringBuffer sb = new StringBuffer();
		sb.append("pg_targetPage_js(" + num + ")");
		return sb.toString();
	}
	
	protected String getCheckPageSizeJS() {
		StringBuffer sb = new StringBuffer();
		sb.append("<script type=\"text/javascript\">");
		sb.append(" function pg_checkPageSize(obj) { ");
		sb.append(" document.getElementById(\"pg_pageSize\").value=obj.value; ");
		sb.append(" pg_targetPage_js(1); ");
		sb.append(" } ");
		sb.append("</script>");
		return sb.toString();
	}
	
	public abstract String getContent();
}
