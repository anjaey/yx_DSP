package com.hy.util.upload;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.hy.util.common.DateUtil;
import com.hy.util.common.StringUtils;
import com.hy.util.common.UuidUtil;

/**
 * 上传工具
 * @author linw
 *
 */
public class UploadUtils {
	
	private static final Log log = LogFactory.getLog(UploadUtils.class);
	
	/**
	 * 最大限制
	 */
	private Long maxSize;
	
	/**
	 * 后缀名限制
	 */
	private String suffixStr;
	
	/**
	 * 显示大小类型
	 */
	private String showSizeType;
	
	public static final String MB = "MB";
	public static final String KB = "KB";
	
	public UploadUtils() {
		showSizeType = MB;
	}
	
	/**
	 * 获取上传文件
	 * @throws ApplicationException 
	 */
	public Map<String, List<UploadBean>> getUploadFiles(HttpServletRequest request) throws Exception {
		
		Map<String, List<UploadBean>> map = new HashMap<String, List<UploadBean>>();
		
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
        	// 转换成多部分request
        	
        	// 不使用注解
        	// MultipartHttpServletRequest multiRequest = multipartResolver.resolveMultipart(request);
        	// 使用注解
        	MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
            	// input name的名称
            	String inputName = iter.next();
            	
            	List<UploadBean> uploadBeanList = new ArrayList<UploadBean>();
            	
                // 取得上传文件 
            	List<MultipartFile> fileList = multiRequest.getFiles(inputName);
            	if (fileList != null && !fileList.isEmpty()) {
            		for (MultipartFile file : fileList) {
            			// 取得当前上传文件的文件名称  
                        String fileName = file.getOriginalFilename();  
                        // 如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                        if (fileName.trim() != "") {
                        	//生成uuid，防止图片重名
                        	String uuid = UuidUtil.generateClusterUUID();
                        	
                        	UploadBean uploadBean = new UploadBean();
                        	uploadBean.setMultipartFile(file);
                        	uploadBean.setNameOld(uuid + "-" + fileName);
                        	
                        	// 文件大小
                        	if (maxSize != null 
                        			&& file.getSize() > maxSize) {
                        		throw new UploadException("上传文件失败：文件（" + fileName + "）大于" + this.getFileSizeType(maxSize));
                        	}
                        	uploadBean.setSize(file.getSize());
                        	
                        	// 文件后缀名
                        	String suffix = null;
                        	if (fileName.lastIndexOf(".") > -1) {
                        		suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                        	}
                        	if (!StringUtils.isEmpty(suffixStr)) {
                        		List<String> suffixList = StringUtils.splitToList(suffixStr);
                        		if (suffixList != null && !suffixList.isEmpty()) {
                        			boolean checkSuffix = false;
                        			for (String suffixTemp : suffixList) {
                        				if (StringUtils.isEmpty(suffixTemp)) {
                        					continue;
                        				}
                        				if (suffixTemp.equalsIgnoreCase(suffix)) {
                        					checkSuffix = true;
                        				}
                        			}
                        			if (!checkSuffix) {
                        				throw new UploadException("上传文件失败：文件（" + fileName + "）后缀名不符合" + suffixStr);
                        			}
                        		}
                        	}
                        	uploadBean.setSuffix(suffix);
                        	
                        	uploadBeanList.add(uploadBean);
                        }  
            		}
            	}
            	
            	if (!uploadBeanList.isEmpty()) {
            		map.put(inputName, uploadBeanList);
            	} else {
                	map.put(inputName, null);
            	}
            }
        }
        return map;
	}
	
	/**
	 * 获取上传文件 单个name
	 * @param request
	 * @param name
	 * @return
	 * @throws UploadException
	 */
	public List<UploadBean> getUploadFiles(HttpServletRequest request, String name) throws UploadException {
		
		List<UploadBean> uploadBeanList = new ArrayList<UploadBean>();
		
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
        	// 转换成多部分request
        	
        	// 不使用注解
        	// MultipartHttpServletRequest multiRequest = multipartResolver.resolveMultipart(request);
        	// 使用注解
        	MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
            	// input name的名称
            	String inputName = iter.next();
            	
            	if (inputName.equals(name)) {
            		// 取得上传文件 
                	List<MultipartFile> fileList = multiRequest.getFiles(inputName);
                	if (fileList != null && !fileList.isEmpty()) {
                		for (MultipartFile file : fileList) {
                			// 取得当前上传文件的文件名称  
                            String fileName = file.getOriginalFilename();  
                            // 如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                            if (fileName.trim() != "") {
                            	
                            	UploadBean uploadBean = new UploadBean();
                            	uploadBean.setMultipartFile(file);
                            	uploadBean.setNameOld(fileName);
                            	
                            	// 文件大小
                            	if (maxSize != null 
                            			&& file.getSize() > maxSize) {
                            		throw new UploadException("上传文件失败：文件（" + fileName + "）大于" + this.getFileSizeType(maxSize));
                            	}
                            	uploadBean.setSize(file.getSize());
                            	
                            	// 文件后缀名
                            	String suffix = null;
                            	if (fileName.lastIndexOf(".") > -1) {
                            		suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                            	}
                            	if (!StringUtils.isEmpty(suffixStr)) {
                            		List<String> suffixList = StringUtils.splitToList(suffixStr);
                            		if (suffixList != null && !suffixList.isEmpty()) {
                            			boolean checkSuffix = false;
                            			for (String suffixTemp : suffixList) {
                            				if (StringUtils.isEmpty(suffixTemp)) {
                            					continue;
                            				}
                            				if (suffixTemp.equalsIgnoreCase(suffix)) {
                            					checkSuffix = true;
                            				}
                            			}
                            			if (!checkSuffix) {
                            				throw new UploadException("上传文件失败：文件（" + fileName + "）后缀名不符合" + suffixStr);
                            			}
                            		}
                            	}
                            	uploadBean.setSuffix(suffix);
                            	
                            	uploadBeanList.add(uploadBean);
                            }  
                		}
                	}
            	}
            }
        }
        return uploadBeanList;
	}
	
	/**
	 * 显示大小类型
	 * @param byteFile
	 * @return
	 */
	private String getFileSizeType(long byteFile) {
		
		String result = null;
		
		if (byteFile == 0) {
			result = "0" + showSizeType;
			return result;
        }
		
		if (MB.equals(showSizeType)) {
			
			long mb = 1024 * 1024;  
			result = byteFile/mb + MB;
			
		} else if (KB.equals(showSizeType)) {
			
			long kb = 1024;  
			result = byteFile/kb + KB;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		UploadUtils uploadUtils = new UploadUtils();
		uploadUtils.showSizeType = UploadUtils.KB;
		System.out.println(uploadUtils.getFileSizeType(500 * 1024));
	}

	/**
	 * 保存 上传文件
	 * @throws Exception 
	 * @throws ApplicationException 
	 */
	public void saveUploadFiles(UploadBean uploadBean, String dir, String path) throws Exception {
		
		if (uploadBean != null) {
			
			MultipartFile multipartFile = uploadBean.getMultipartFile();
			String suffix = uploadBean.getSuffix();
			
			// 文件名 新
			String nameNew = DateUtil.date2String(Calendar.getInstance().getTime(), DateUtil.PATTERN_yyyyMMddHHmmss);
			nameNew = nameNew + getRandNum(5);
			
			// 上传路径
			String saveUploadPath = path + "/" + nameNew + "." + suffix;
			
	        try {
	        	
	        	File localFile = new File(dir + saveUploadPath);
				if (!localFile.exists() && !localFile.isDirectory()) {
					localFile.mkdirs();
				}
	        	
				multipartFile.transferTo(localFile);
			} catch (IllegalStateException e) {
				log.error(e);
				throw new UploadException("上传文件保存失败", e);
			} catch (IOException e) {
				log.error(e);
				throw new UploadException("上传文件保存失败", e);
			}
			
	        uploadBean.setPath(saveUploadPath);
	        uploadBean.setNameNew(nameNew);
		}
	}
	
	/**
	 * 获取随机数
	 * @author linw
	 * @date 2016年5月9日下午2:02:44
	 * @param length 随机数长度
	 * @return
	 * @throws Exception
	 */
	private String getRandNum(int length) throws Exception {
		
		if (length < 1) {
			throw new Exception("长度小于1");
		}
		
		StringBuffer regExp = new StringBuffer();
		StringBuffer numMax = new StringBuffer();
		numMax.append("1");
		for (int i=0; i<length; i++) {
			regExp.append("0");
			numMax.append("0");
		}
		
		int num = new Random().nextInt(Integer.valueOf(numMax.toString()));
		
		DecimalFormat format = new DecimalFormat(regExp.toString());
		String randNum = format.format(num);
		
		return randNum;
	}
	
	public Long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(Long maxSize) {
		this.maxSize = maxSize;
	}

	public String getSuffixStr() {
		return suffixStr;
	}

	public void setSuffixStr(String suffixStr) {
		this.suffixStr = suffixStr;
	}

	public String getShowSizeType() {
		return showSizeType;
	}

	public void setShowSizeType(String showSizeType) {
		this.showSizeType = showSizeType;
	}
}
