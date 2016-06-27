package com.hy.util.upload;

/**
 * 上传文件 异常
 * @author linw
 *
 */
public class UploadException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1073855807271251136L;

	public UploadException() {
		super();
	}
	
	public UploadException(String message) {
		super(message);
	}

	public UploadException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UploadException(Throwable cause) {
		super(cause);
	}
}
