package com.hy.util.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

/**
 * word 工具
 * @author sslf
 * @datetime 2015年7月6日下午2:23:36
 */
public class WordUtil {

	private Log log = LogFactory.getLog(WordUtil.class);
	
	/**
	 * word读取
	 * @param pathname word 文件路径
	 * @return
	 * @author sslf
	 */
	public String read(String pathname){
		if (pathname.endsWith(".docx")){
			return read07(pathname);
		}else {
			return read03(pathname);
		}
	}

	/**
	 * 读取word 07版
	 * @param pathname
	 * @return
	 * @author sslf
	 */
	public String read07(String pathname){
		String result = "";
		OPCPackage opcPackage;
		POIXMLTextExtractor extractor = null;
		try {
			opcPackage = POIXMLDocument.openPackage(pathname);
			extractor = new XWPFWordExtractor(opcPackage);
			result = extractor.getText();
		} catch (IOException e) {
			log.info(e.getStackTrace());
		} catch (XmlException e) {
			log.info(e.getStackTrace());
		} catch (OpenXML4JException e) {
			log.info(e.getStackTrace());
		}
		return result;
	}
	
	/**
	 * 读取word 03版
	 * @param pathname
	 * @return
	 * @author sslf
	 */
	public String read03(String pathname) {
		InputStream is = null;
		String result = "";
		WordExtractor word = null;
		try {
			is = new FileInputStream(pathname);
			word = new WordExtractor(is);
			result = word.getText();
		} catch (FileNotFoundException e) {
			log.info(e.getStackTrace());
		} catch (IOException e) {
			log.info(e.getStackTrace());
		} finally {
			try {
				word.close();
			} catch (IOException e) {
				log.info(e.getStackTrace());
			}
			try {
				is.close();
			} catch (IOException e) {
				log.info(e.getStackTrace());
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		WordUtil word = new WordUtil();
		System.out.println(word.read("d:/aa.docx"));
	}
}
