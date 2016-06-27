package com.hy.util.tglib;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hy.util.common.QueryPage;

/**
 * 翻页标签 base
 * @author linw
 *
 */
public class PageBaseTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 961000214441782099L;

	protected Log log = LogFactory.getLog(this.getClass());
	
	protected QueryPage queryPage;
	
	private String action;

	private String namespace;
	
	private Map<String,String> paramMap = new HashMap<String,String>();
	
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
	
	@Override
	public int doStartTag() throws JspException {
		queryPage = (QueryPage) pageContext.getRequest().getAttribute("queryPage");
		paramMap.clear();
		
		initQueryPage();
		
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * 首页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getFirstPagePath() {
		String path = getActionPath();
		StringBuffer sb = new StringBuffer();
		sb.append(path);
		sb.append("?queryPage.targetPage=1");
		sb.append("&queryPage.pageSize=" + queryPage.getPageSize());
		sb.append(getParamStr());
		return sb.toString();
	}
	
	/**
	 * 末页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getLastPagePath() {
		String path = getActionPath();
		StringBuffer sb = new StringBuffer();
		sb.append(path);
		sb.append("?queryPage.targetPage=" + queryPage.getPageCount());
		sb.append("&queryPage.pageSize=" + queryPage.getPageSize());
		sb.append(getParamStr());
		return sb.toString();
	}

	/**
	 * 上一页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getPreviousPagePath() {
		String path = getActionPath();
		StringBuffer sb = new StringBuffer();
		sb.append(path);
		sb.append("?queryPage.targetPage=" + (queryPage.getTargetPage() - 1));
		sb.append("&queryPage.pageSize=" + queryPage.getPageSize());
		sb.append(getParamStr());
		return sb.toString();
	}
	
	/**
	 * 下一页
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getNextPagePath() {
		String path = getActionPath();
		StringBuffer sb = new StringBuffer();
		sb.append(path);
		sb.append("?queryPage.targetPage=" + (queryPage.getTargetPage() + 1));
		sb.append("&queryPage.pageSize=" + queryPage.getPageSize());
		sb.append(getParamStr());
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
		String path = getActionPath();
		StringBuffer sb = new StringBuffer();
		sb.append(path);
		sb.append("?queryPage.targetPage=" + num);
		sb.append("&queryPage.pageSize=" + queryPage.getPageSize());
		sb.append(getParamStr());
		return sb.toString();
	}
	
	/**
	 * url
	 * @author linw
	 * @date 2016年5月12日上午11:39:31
	 * @return
	 */
	protected String getPagePath() {
		String path = getActionPath();
		StringBuffer sb = new StringBuffer();
		sb.append(path);
		sb.append("?1=1");
		sb.append(getParamStr());
		return sb.toString();
	}
	
	/**
	 * 获取参数 str
	 * @author linw
	 * @date 2016年5月5日上午9:01:45
	 * @return
	 * @update
	 * @date
	 */
	protected String getParamStr() {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String,String> param : paramMap.entrySet()) {
			String key = param.getKey();
			String value = param.getValue();
			if (!StringUtils.isEmpty(key) 
					&& !StringUtils.isEmpty(value)) {
				try {
					sb.append("&");
					sb.append(key);
					sb.append("=");
					sb.append(URLEncoder.encode(value,"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					log.error(e);
				}
			}
		}
		return sb.toString();
	}
	
	protected String getCheckPageSizeJS() {
		StringBuffer sb = new StringBuffer();
		sb.append("<script type=\"text/javascript\">");
		sb.append(" function pg_checkPageSize() { ");
		
		sb.append(" var pageSize = document.getElementById(\"pg_pageSize\").value; ");
		sb.append("	var r1 = /^[1-9]\\d*$/; ");
		
		sb.append("	if (!r1.test(pageSize)) { ");
		sb.append(" alert(\"请输入正整数\"); ");
		sb.append("	return; ");
		sb.append("	} ");
		
		sb.append(" var url = document.getElementById(\"pg_url\").value; ");
		sb.append(" window.location.href = url + \"&queryPage.pageSize=\" + pageSize; ");
		
		sb.append(" } ");
		sb.append("</script>");
		return sb.toString();
	}
	
	protected String getActionPath() {
		String path = pageContext.getServletContext().getContextPath() + namespace + "/" + action;
		return path;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}
}
