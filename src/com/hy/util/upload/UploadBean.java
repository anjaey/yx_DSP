package com.hy.util.upload;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传对象
 * @author linw
 *
 */
public class UploadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6569363597735031L;
	
	/**
	 * 文件名 旧
	 */
	private String nameOld;
	
	/**
	 * 文件名 新
	 */
	private String nameNew;
	
	/**
	 * 保存路径
	 */
	private String path;
	
	/**
	 * 后缀名
	 */
	private String suffix;
	
	/**
	 * 大小
	 */
	private Long size;
	
	/**
	 * 上传文件
	 */
	private MultipartFile multipartFile;

	public String getNameOld() {
		return nameOld;
	}

	public void setNameOld(String nameOld) {
		this.nameOld = nameOld;
	}

	public String getNameNew() {
		return nameNew;
	}

	public void setNameNew(String nameNew) {
		this.nameNew = nameNew;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
}
