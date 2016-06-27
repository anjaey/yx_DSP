package com.hy.util.export.xls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.hy.util.export.AbstractExporter;
import com.hy.util.export.CellBean;

public class XlsExport extends AbstractExporter {

	private String fileName;

	private String fileType;

	@SuppressWarnings("rawtypes")
	private List titleList = new ArrayList();

	@SuppressWarnings("rawtypes")
	public void buildExcelHead(HttpServletResponse response, String head) throws IOException {

		StringBuffer header = new StringBuffer();
		header.append("<meta http-equiv=Content-Type content=\"text/html; charset=utf-8\">");
		response.reset();
		response.setContentType("application/" + this.fileType);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(this.fileName.getBytes("gb2312"), "ISO-8859-1") + "." + this.fileType);
		header.append("<table border=1px>\r\n");
		header.append("<tr>\r\n");

		if (StringUtils.isNotEmpty(head)) {
			header.append("<td height=\"70\" colspan=\"" + (getTitleList().isEmpty() ? 0 : getTitleList().size()) + "\"  width=200px style=\"font-weight:bold;font-size=10px;text-align: center;\">");
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
	 * 添加Excel标题属性
	 * @param title 标题
	 * @param align 颜色
	 * @param height 高
	 * @param width 宽
	 * @param num 列
	 * @return
	 */
	public List<CellBean> setExcelTitles(String[] title, String[] align, String[] height, String[] width, int num) {
		List<CellBean> tileList = new ArrayList<CellBean>();
		for (int i = 0; i < num; i++) {
			CellBean cellBean = new CellBean();
			cellBean.setAlign(align[i]); // 颜色
			cellBean.setTitle(title[i]); // 标题
			cellBean.setHeight(height[i]); // 高
			cellBean.setWidth(width[i]); // 宽
			tileList.add(cellBean);
		}
		return tileList;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getTitleList() {
		return titleList;
	}

	@SuppressWarnings("rawtypes")
	public void setTitleList(List titleList) {
		this.titleList = titleList;
	}

}
