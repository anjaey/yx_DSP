package com.hy.util.common;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 系统 路径 工具
 * @author linw
 *
 */
public class DirUtil {
	
	private static ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("dir");
	
	private static String OS_NAME = "os.name";
	private static String OS = "Windows";
	
	/**
	 * 上传路径
	 * @return
	 */
	public static String getDirUpload() {
		String dirUpload = null;
		if (System.getProperty(OS_NAME).startsWith(OS)) {
			dirUpload = resourceBundle.getString("dir.upload.win");
		} else {
			dirUpload = resourceBundle.getString("dir.upload.linux");
		}
		return dirUpload;
	}
	
	/**
	 * 服务器 路径 DSP
	 * @return
	 */
	public static String getDirDoMainDsp() {
		String dirDoMain = resourceBundle.getString("dir.doMain.dsp");;
		return dirDoMain;
	}
	
	/**
	 * 服务器 路径 ADMIN
	 * @return
	 */
	public static String getDirDoMainAdmin() {
		String dirDoMain = resourceBundle.getString("dir.doMain.admin");;
		return dirDoMain;
	}
	
	/**
	 * 服务器 路径 API
	 * @return
	 */
	public static String getDirDoMainApi() {
		String dirDoMain = resourceBundle.getString("dir.doMain.admin");;
		return dirDoMain;
	}
}
