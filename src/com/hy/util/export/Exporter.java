package com.hy.util.export;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface Exporter {
	
	public void buildExcelHead(HttpServletResponse response, String head) throws IOException;

	public void buildExcelBody(HttpServletResponse response, List<String> excelData) throws IOException;

	public void buildExcelFoot(HttpServletResponse response) throws IOException;
}
