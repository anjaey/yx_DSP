package com.hy.util.export;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractExporter implements Exporter {
	
	protected String excelName = "sheet1";
	
	protected final Log log = LogFactory.getLog(AbstractExporter.class);

	/**
	 * 创建excel标题
	 * 
	 * @param response
	 * @param head
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public void buildExcelHead(HttpServletResponse response, String head) throws IOException {

		StringBuffer header = new StringBuffer();
		header.append("<meta http-equiv=Content-Type content=\"text/html; charset=utf-8\">");
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + this.excelName + ".xls");
		header.append("<table border=1px>\r\n");
		header.append("<tr>\r\n");

		if (StringUtils.isNotEmpty(head)) {
			header.append("<td height=\"50\" colspan=\"" + getTitleList().size() + "\" width=200px>");
			header.append(head);
			header.append("</td></tr><tr>");
		}

		for (Iterator iter = getTitleList().iterator(); iter.hasNext();) {
			CellBean cell = (CellBean) iter.next();
			StringBuffer sb = new StringBuffer("");
			if (StringUtils.isNotEmpty(cell.getHeight())) {
				sb.append(" height=\"" + cell.getHeight() + "\" ");
			}
			if (StringUtils.isNotEmpty(cell.getWidth())) {
				sb.append(" width=\"" + cell.getWidth() + "\" ");
			}

			header.append("<td  align=\"center\" bgcolor=\"#99ccff\"" + sb.toString() + ">" + cell.getTitle() + "</td>");
		}
		header.append("</tr>\r\n");
		response.getWriter().print(header.toString());
		response.flushBuffer();
	}

	/**
	 * 需实现此抽象方法,使用二维数组是为了解决数据库中某一条记录对应EXCEL多条记录.
	 * 
	 * @param obj
	 * @return
	 */
	// public abstract Object[][] getContentArray(Object obj);

	/**
	 * 完成excel的导出
	 * 
	 * @param response
	 * @throws IOException
	 */
	public void buildExcelFoot(HttpServletResponse response) throws IOException {
		log.debug("start build foot....");
		StringBuffer footer = new StringBuffer("</table>\r\n");
		response.getWriter().print(footer.toString());
		response.flushBuffer();
		response.getWriter().close();
	}

	/**
	 * 设置excel的标题
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public abstract List getTitleList();

	/**
	 * 如果需要设置excel内容的显示样式,需覆盖此方法
	 * 
	 * @return
	 */
	public Object[] getContentStyle() {
		return null;
	}

	/**
	 * 创建excel主体部分
	 * 
	 * @param response
	 * @param excelData
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public void buildExcelBody(HttpServletResponse response, List<String> excelData) throws IOException {
		log.debug("start build body....");
		StringBuffer body = new StringBuffer("");

		log.debug("excelData=" + excelData.size());

		for (Iterator iter = excelData.iterator(); iter.hasNext();) {
			body.append("<tr>\r\n");
			String[] line = (String[]) iter.next();

			for (int i = 0; i < line.length; i++) {
				body.append("<td style=\"mso-number-format:\\@;\">\r\n");
				if (line[i] == null) {
					body.append("&nbsp;");
				} else {
					body.append(line[i]);
				}
				body.append("</td>\r\n");
			}
			body.append("</tr>\r\n");
		}
		response.getWriter().print(body.toString());
		response.flushBuffer();
	}
	
	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}
}
