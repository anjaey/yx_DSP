package com.hy.util.export;

import java.io.Serializable;

/**
 * @author <a href="mailto:zhangzhi@dne.com.cn">zhangzhi</a>
 * @version $Revision: 1.1 $ $Date: 2008-1-2 下午03:02:24
 */
public class CellBean implements Serializable {
	
	private String title;
	private String height;
	private String width;
	private String align;

	/**
	 * @param title
	 * @param height
	 * @param width
	 * @param align
	 */
	public CellBean(String title, String height, String width, String align) {
		super();
		this.title = title;
		this.height = height;
		this.width = width;
		this.align = align;
	}

	/**
	 * @param title
	 * @param height
	 * @param width
	 */
	public CellBean(String title, String height, String width) {
		this.title = title;
		this.height = height;
		this.width = width;
	}

	/**
	 * @param title
	 */
	public CellBean(String title) {
		this.title = title;
	}

	public CellBean() {
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

}
