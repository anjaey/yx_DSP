package com.hy.dao.common;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;

import com.hy.util.common.PropertiesUtil;  
  
/**
 * jdbc 连接类
 * @author hy
 *
 */
public class DBHelper {
	public static final String url = PropertiesUtil.getProperty("jdbc.properties", "url");  
	public static final String name = PropertiesUtil.getProperty("jdbc.properties", "driverClassName");   
	public static final String user = PropertiesUtil.getProperty("jdbc.properties", "name");
	public static final String password = PropertiesUtil.getProperty("jdbc.properties", "psd");
	public Connection conn = null;  
	public PreparedStatement pst = null;  

	public DBHelper() {
		try {  
			Class.forName(name);//指定连接类型  
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, password);//获取连接  
			} else {
			}
		} catch (Exception e) {  
			e.printStackTrace();  
		}
	}

	public void close() {  
		try {  
			this.conn.close();  
			this.pst.close();  
		} catch (SQLException e) {  
			e.printStackTrace();  
		}  
	}  

}
