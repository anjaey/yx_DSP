package com.hy.util.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * 文本工具
 * @author sslf
 * @datetime 2015年7月6日上午11:09:56
 */
public class TextUtil {

	private Log log = LogFactory.getLog(TextUtil.class);
	
	/** 
	 * 根据传入的文本文件路径，获取文件的内容，指定获取文本的编码格式，读文件的话，最好是gbk，因为windows保存的文本默认是gbk
	 * @param path 文本文件所在路径
	 * @param encodString 编码格式
	 * @return 文本文件内容
	 * @author cjw
	 */
	public String read(String path,String encodString){
		log.debug("准备读取文件");
		
		encodString = encodString.trim();
		StringBuffer sb = new StringBuffer("");
		
		FileInputStream fi = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			fi = new FileInputStream(path);
			isr = new InputStreamReader(fi,encodString);
			br = new BufferedReader(isr);
			
			String data = "";
			while ((data = br.readLine()) != null) {
				sb.append(data);
			}
			
		} catch (FileNotFoundException e) {
			log.info("路径有误");
		} catch (UnsupportedEncodingException e) {
			log.info("不支持的编码格式");
		} catch (IOException e) {
			log.info("读取文本内容时发生io错误");
		} finally {
			// 关闭流
			try {
				br.close();
			} catch (IOException e) {
				log.info("关闭BufferedReader出错");
			}
			try {
				isr.close();
			} catch (IOException e) {
				log.info("关闭InputStreamReader出错");
			}
			try {
				fi.close();
			} catch (IOException e) {
				log.info("关闭FileInputStream出错");
			}
		}
		
		log.debug("文件读取结束");
		return sb.toString();
	}
	
	/**
	 * 保存文件
	 * @param path 保存路径
	 * @param content 保存内容
	 * @param encodString 保存编码格式
	 * @author sslf
	 */
	public void writer(String pathname,String content,String encodString){
		File file = new File(pathname);
		FileOutputStream out = null;
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			} 
			// 默认追加
			out = new FileOutputStream(file,true);
			out.write(content.getBytes(encodString));
			
		} catch (FileNotFoundException e) {
			log.info("路径有误");
		} catch (UnsupportedEncodingException e) {
			log.info("不支持的编码格式");
		} catch (IOException e) {
			log.info("文件不存在，创建文件失败");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				log.info("输出流没有正常关闭");
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		TextUtil text = new TextUtil();
		/*System.out.println(text.read("d:/aa.docx", " gbk"));*/
		
		text.writer("d:/bb1.txt", "这是我的测试文件内容", "utf-8");
		
		
	}
}
