package com.hy.util.common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**Excel数据处理
 * @author 邓鹏
 * @date 2015年7月16日下午3:17:58
 * @version 1.2
 */
public class ExcelOperateUtil {
 
    static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static short[] yyyyMMdd = {14, 31, 57, 58, 179, 184, 185, 186, 187, 188};
    static short[] HHmmss = {20, 32, 190, 191, 192};
    static List<short[]> yyyyMMddList = Arrays.asList(yyyyMMdd);
    static List<short[]> hhMMssList = Arrays.asList(HHmmss);
    
   
    /**
     * 导出excle
     * @param workbook 
     * @param out
     * @date 2015年7月16日下午3:16:21
     */
    public static void export2Excel(Workbook workbook,OutputStream out){
    	try {
    		workbook.write(out);
    		out.flush();
    		if(null!=out){
    			out.close();
    		}
    		workbook.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * web 下载 
     * @param workbook
     * @param out
     * @param response
     * @param fileName
     * @date 2015年7月16日下午3:44:27
     */
    public static void export2Excel(Workbook workbook,OutputStream out,HttpServletResponse response,String fileName){
		String excelVersion = "";
		if (workbook instanceof HSSFWorkbook) {
			excelVersion = "2003";
		} else if (workbook instanceof XSSFWorkbook) {
			excelVersion = "2007";
		}
		setupMIMEHeader(response, fileName, excelVersion);
		export2Excel(workbook, out);
    }
    
    
    //读写xls和xlsx格式时，HSSFWorkbook针对xls，XSSFWorkbook针对xlsx
    
    /**
     * 根据路径,获取WorkBook对象
     *
     * @param filePath 文件路径
     * @return workbook
     * @throws Exception
     */
    public static Workbook readExcel2Workbook(String filePath) throws Exception {
        Workbook workbook = null;
        File file = new File(filePath);
        if (file.exists()) {
        	if(filePath.endsWith(".xls")){
        			workbook = getHSSFWorkBookByStream(new FileInputStream(file));
        	}else if(filePath.endsWith(".xlsx")){
        		//有可能创建失败
        		try {
        			workbook = getXSSFWorkBookByStream(new FileInputStream(file));
	        	} catch (Exception e) {
	        		workbook = WorkbookFactory.create(file);
	        	}
        	}else{
        		return null;
        	}
        }
        return workbook;
    }
 
    /**
     * 03版 excle 
     * 根据输入流ins获取WorkBook对象
     * @param ins 输入流
     * @return workbook
     * @throws Exception
     */
    public static Workbook getHSSFWorkBookByStream(InputStream ins) throws Exception {
    	return new  HSSFWorkbook(ins);
    }
    /**
     * 07版 excle 
     * 根据输入流ins获取WorkBook对象
     * @param ins   
     * @return
     * @throws Exception
     */
    public static Workbook getXSSFWorkBookByStream(InputStream ins) throws Exception {
    	return new  XSSFWorkbook(ins);
    }
    
    

	/**
	 * 设置请求头
	 * @param response
	 * @param fileName
	 * @param wb
	 * @throws UnsupportedEncodingException
	 */
	public static void setupMIMEHeader(HttpServletResponse response,String fileName, String excelVersion) {
		response.setHeader("Expires", "-1");
		String inlineName;
		try {
			inlineName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
			inlineName = "unknown";
		}
		if ("2003".equals(excelVersion)) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "inline;filename="
					+ inlineName + ".xls");
		} else if ("2007".equals(excelVersion)) {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-disposition", "inline;filename="
					+ inlineName + ".xlsx");
		} else {
			throw new IllegalStateException(
					"Only 2003 and 2007 excel exports defined.  Add another else if branch to add extra functionality.");
		}
	}

	/**
	 * 设置请求头
	 * @param response
	 * @param fileName
	 * @param wb
	 * @throws UnsupportedEncodingException
	 */
	public static void setupMIMEHeader(HttpServletResponse response,String fileName, Workbook wb) throws UnsupportedEncodingException {
		String excelVersion = "";
		if (wb instanceof HSSFWorkbook) {
			excelVersion = "2003";
		} else if (wb instanceof XSSFWorkbook) {
			excelVersion = "2007";
		}
		setupMIMEHeader(response, fileName, excelVersion);
	}
 
    /**
     * 根据Workbook,sheetIndex获取sheet对象
     *
     * @param book WorkBook对象
     * @param number sheetIndex ,从1开始
     * @return sheet
     * @throws Exception
     */
    public static Sheet getSheetByNum(Workbook book, int number) throws Exception {
        return book.getSheetAt(number - 1);
    }
 
    /**
     * 根据 Workbook对象返回该Workbook对象中所有sheet的Map数组.
     *
     * @param book
     * @return Map<sheetIndex , sheetName>
     * @throws Exception
     */
    public static Map<Integer, String> getSheetNameByBook(Workbook book) throws Exception {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        int sheetNum = book.getNumberOfSheets();
        for (int indexSheet = 1; indexSheet <= sheetNum; indexSheet++) {
            Sheet sheet = getSheetByNum(book, indexSheet);
            map.put(indexSheet, sheet.getSheetName());
        }
        return map;
    }
 
    /**
     * 获取workbook数据Map集合
     *
     * @param book
     * @return Map<Integer, List<List<String>>> @
     * throws Exception
     */
    public static Map<Integer, List<List<String>>> getWorkbookDatas(Workbook book) throws Exception {
        Map<Integer, List<List<String>>> bookdatas = new HashMap<Integer, List<List<String>>>();
        int sheetNum = book.getNumberOfSheets();
        for (int indexSheet = 1; indexSheet <= sheetNum; indexSheet++) {
            Sheet sheet = getSheetByNum(book, indexSheet);
            bookdatas.put(indexSheet, getSheetDataList(sheet));
        }
        return bookdatas;
    }
 
    /**
     * 获取sheet中的数据
     *
     * @param sheet
     * @return List<List<String>> @
     * throws Exception
     */
    public static List<List<String>> getSheetDataList(Sheet sheet) throws Exception {
        List<List<String>> sheetdatas = new ArrayList<List<String>>();
        //需要先合并单元格数据
        mergedRegion(sheet);
        int lastRowNum = getRowNum(sheet);
        int lastCellNum = getColumnNum(sheet);
        for (int i = 0; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            sheetdatas.add(getRowDataList( row, lastCellNum));
        }
        return sheetdatas;
    }
 
    /**
     * 获取的数据对象是符合easyui格式的标准JSON对象数据集[{A:x,B:xx,C:xxx},{A:x,B:xx,C:xxx}]
     *
     * @param sheet
     * @return
     */
    public static List<Map<String, String>> getSheetDataMap(Sheet sheet) {
        List<Map<String, String>> sheetdatas = new ArrayList<Map<String, String>>();
        int lastRowNum = getRowNum(sheet);
        Row row;
        for (int i = 0; i < lastRowNum; i++) {
            row = sheet.getRow(i);
            Map<String, String> map = getRowDataMap(sheet, row);
            if (!map.isEmpty()) {
                sheetdatas.add(map);
            }
        }
        return sheetdatas;
    }
 
    /**
     * 获取的数据对象是符合dHtml格式的非标准JSON对象数据集[{id:1 , data:[x,xx,xxx]},{id:2
     * ,data:[x,xx,xxx]}]
     *
     * @param sheet
     * @return
     */
    public static List<Map<String, Object>> getSheetDataMapAndId(Sheet sheet) throws Exception {
        List<Map<String, Object>> sheetdatas = new ArrayList<Map<String, Object>>();
        List<List<String>> sheetLists = getSheetDataList(sheet);
        for (int i = 0; i < sheetLists.size(); i++) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("id", i);
            dataMap.put("data", sheetLists.get(i));
            sheetdatas.add(dataMap);
        }
        return sheetdatas;
    }
 
    /**
     * 读取一行的数据,返回的是数据集合List,[x,xx,xxx]
     *
     * @param row
     */
    public static List<String> getRowDataList(Row row, int lastCellNum) {
        List<String> rowdatas = new ArrayList<String>();
        if (row == null) {
            for (int i = 0; i < lastCellNum; i++) {
                rowdatas.add("");
            }
        } else {
            for (int i = 0; i < lastCellNum; i++) {
                rowdatas.add(getCellData(row.getCell(i)));
            }
        }
        return rowdatas;
    }
    
    /**
     * 获取 一列row 里面的值 
     * @param sheet
     * @param row
     * @return
     */
    public static List<String> getRowDataList(Row row){
    	 List<String> rowdatas = new ArrayList<String>();
         if (row != null) {
        	 for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
        		 rowdatas.add(getCellData(row.getCell(i)));
        	 }
         } 
    	return rowdatas;
    	
    }
    
    
 
    /**
     * 获取一行的数据集合,体现的是Map<String , String>{A:x,B:xx,C:xxx}
     *
     * @param row
     * @return
     */
    public static Map<String, String> getRowDataMap(Sheet sheet, Row row) {
        Map<String, String> rowdatas = new LinkedHashMap<String, String>();
        String cellVaue;
        int columnNum = 0;
        int lastCellNum = getColumnNum(sheet);
        for (int j = 0; j < lastCellNum; j++) {
            cellVaue = getCellData(row.getCell(j));
            rowdatas.put(getCharByNum(columnNum) + "", cellVaue);
            columnNum = columnNum + 1;
        }
        return rowdatas;
    }
 
    /**
     * 获取指定Sheet中指定一列的数据.
     *
     * @param sheet 指定的Sheet
     * @param colIndex 指定的列
     * @return
     * @throws Exception
     */
    public static List<String> getColumnDataList(Sheet sheet, int colIndex) throws Exception {
        List<String> coldatas = new ArrayList<String>();
        int lastRowNum = getRowNum(sheet);
        for (int i = 0; i < lastRowNum; i++) {
            coldatas.add(getSheetCellValueWithRowIndexAndColIndex(sheet, i, colIndex));
        }
        return coldatas;
    }
 
    /**
     * 返回指定sheet页的最大行数,例如:25,则表示下标从0...24
     *
     * @param book
     * @param sheetIndex
     * @return
     */
    public static int getRowNum(Sheet sheet) {
        return sheet.getLastRowNum() + 1;
    }
 
    /**
     * 返回指定sheet页的最大列数,例如:25,则表示下标从0...24
     *
     * @param book
     * @param sheetIndex
     * @return 列数
     */
    public static int getColumnNum(Sheet sheet) {
        int maxclNum = 0;
        int lastRowNum = getRowNum(sheet);
        for (int i = 0; i < lastRowNum; i++) {
            if (sheet.getRow(i) != null) {
                int tempNum = sheet.getRow(i).getLastCellNum();
                if (tempNum > maxclNum) {
                    maxclNum = tempNum;
                }
            }
        }
        return maxclNum;
    }
 
    /**
     * 获取单元格的名称 按照excel常见的名称 例如A1
     *
     * @param int rowInt 行数 从0开始
     * @param int columnInt 列数 从0开始
     * @return String
     */
    public static String getCellName(int rowInt, int columnInt) {
        CellReference cellReference = new CellReference(rowInt, columnInt);
        return cellReference.formatAsString();
    }
 
    /**
     * 获取指定单元格的行坐标
     *
     * @param cellName 例如A1
     * @return 2
     */
    public static int getCellRowIndex(String cellName) {
        CellReference cellReference = new CellReference(cellName);
        return cellReference.getRow();
    }
 
    /**
     * 获取指定单元格的列坐标
     *
     * @param cellName 例如A1
     * @return 0
     */
    public static int getCellColIndex(String cellName) {
        CellReference cellReference = new CellReference(cellName);
        return cellReference.getCol();
    }
 
    /**
     * 获取指定sheet中指定rowNum和cellNum的值
     *
     * @param sheet
     * @param rowNum
     * @param cellNum
     * @return
     * @throws Exception
     */
    public static String getSheetCellValueWithRowIndexAndColIndex(Sheet sheet, int rowNum, int cellNum) throws Exception {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        return getCellData(cell);
    }
 
    /**
     * 获取给定SHEET中指定单元格的值
     *
     * @param sheet 指定SHEET
     * @param cellName 格式为：A1,B3
     * @return
     */
    public static String getSheetCellValueWithCellName(Sheet sheet, String cellName) {
        CellReference cellReference = new CellReference(cellName);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        return getCellData(cell);
    }
 
    /**
     * 获得cell单元格的TypeNumber,范围是0~5
     *
     * @param cell
     * @return
     */
    public static int getColumnTypeNumber(Cell cell) {
        if (cell != null) {
            int type = cell.getCellType();
            return type;
        }
        return -1;
    }
 
    /**
     * 获取指定Sheet页 所有合并单元格数据信息
     *
     * @param sheet
     * @return List<Map<String, String>>
     */
    public static List<Map<String, String>> getSheetRegion(Sheet sheet) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        //合并的单元格数量
        int merged = sheet.getNumMergedRegions();
        //预读合并的单元格
        for (int i = 0; i < merged; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            Map<String, String> map = new LinkedHashMap<String, String>();
            int colstart = range.getFirstColumn();
            int colend = range.getLastColumn();
            int rowstart = range.getFirstRow();
            int rowend = range.getLastRow();
            map.put("colstart", colstart + "");
            map.put("colend", colend + "");
            map.put("rowstart", rowstart + "");
            map.put("rowend", rowend + "");
            map.put("field", getCharByNum(colstart));
            map.put("colspan", (colend - colstart + 1) + "");
            map.put("rowspan", (rowend - rowstart + 1) + "");
            map.put("index", rowstart + "");
            list.add(map);
        }
        return list;
    }
 
    /**
     * 获取sheet中指定column的列宽度,这里的宽度是近似宽度,不是很精确
     *
     * @param sheet
     * @param cloumI
     * @return
     */
    public static int getColumnWidth(Sheet sheet, int cloumI) {
        return new BigDecimal(sheet.getColumnWidth(cloumI) * 37 / 1200).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }
 
    /**
     * 获取sheet中指定column的列宽度集合,这里的宽度是近似宽度,不是很精确
     *
     * @param sheet
     * @return
     */
    public static List<Integer> getColumnWidths(Sheet sheet) {
        List<Integer> columnWidths = new ArrayList<Integer>();
        int lastCellNum = getColumnNum(sheet);
        for (int i = 0; i < lastCellNum; i++) {
            columnWidths.add(new BigDecimal(sheet.getColumnWidth(i) * 37 / 1200).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
        }
        return columnWidths;
    }
 
    /**
     * 获取一个Sheet的冻结信息,包括冻结列和冻结行
     *
     * @param sheet
     * @return
     * @throws Exception
     */
    public static Map<String, Short> getSheetFrazenColAndRow(Sheet sheet) throws Exception {
        Map<String, Short> frazenMap = new HashMap<String, Short>();
        PaneInformation paneInformation = sheet.getPaneInformation();
        if (paneInformation != null) {
            //有多少列是冻结的
            frazenMap.put("freezeCol", paneInformation.getVerticalSplitLeftColumn());
            //有多少行是冻结
            frazenMap.put("freezeRow", paneInformation.getHorizontalSplitTopRow());
        }
        return frazenMap;
    }
 
    /**
     * 获取单元中值(字符串类型)
     *
     * @param cell
     * @return
     */
    public static String getCellData(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            try {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_BLANK://空白
                        cellValue = "";
                        break;
                    case Cell.CELL_TYPE_NUMERIC: //数值型 0----日期类型也是数值型的一种
                        if (DateUtil.isCellDateFormatted(cell)) {
                            short format = cell.getCellStyle().getDataFormat();
 
                            if (yyyyMMddList.contains(format)) {
                                sFormat = new SimpleDateFormat("yyyy-MM-dd");
                            } else if (hhMMssList.contains(format)) {
                                sFormat = new SimpleDateFormat("HH:mm:ss");
                            }
                            Date date = cell.getDateCellValue();
                            cellValue = sFormat.format(date);
                        } else {
                            Double numberDate = new BigDecimal(cell.getNumericCellValue()).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
                            cellValue = numberDate + "";
                        }
                        break;
                    case Cell.CELL_TYPE_STRING: //字符串型 1
                        cellValue = replaceBlank(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA: //公式型 2
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cellValue = replaceBlank(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN: //布尔型 4
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_ERROR: //错误 5
                        cellValue = "!#REF!";
                        break;
                }
            } catch (Exception e) {
                System.out.println("读取Excel单元格数据出错：" + e.getMessage());
                return cellValue;
            }
        }
        return cellValue;
    }
 
    public static String replaceBlank(String source) {
        String dest = "";
        if (source != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(source);
            dest = m.replaceAll("");
        }
        return dest;
    }
 
    /**
     * 给SHEET某一个单元格赋值
     *
     * @param sheet 指定单元格
     * @param rowNum 行号
     * @param cellNum 列号
     * @param value 值
     */
    public static void setCellValue(Sheet sheet, int rowNum, int cellNum, String value) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            row.createCell(cellNum).setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
    }
 
    public static void mergedRegion(Sheet sheet) throws Exception {
        //合并的单元格数量
        int merged = sheet.getNumMergedRegions();
        //预读合并的单元格
        for (int i = 0; i < merged; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int y0 = range.getFirstRow();
            int x0 = range.getFirstColumn();
            int y1 = range.getLastRow();
            int x1 = range.getLastColumn();
 
            String value = getSheetCellValueWithRowIndexAndColIndex(sheet, y0, x0);
 
            for (int m = y0; m <= y1; m++) {
                for (int n = x0; n <= x1; n++) {
                    setCellValue(sheet, m, n, value);
                }
            }
        }
    }
 
    /**
     * 生成表头名称,A,B,C,D...
     *
     * @param number
     * @return
     */
    public static String getCharByNum(int number) {
        int index = number / 26 - 1;
        if (index < 0) {
            return (char) (65 + number % 26) + "";
        } else if (index >= 0) {
            return (char) (65 + index) + "" + (char) (65 + number % 26) + "";
        }
        return "@";
    }
 
    /**
     * 补全String字符串,
     *
     * @param str 字符窜
     * @param len 长度
     * @param pre 补全字符
     * @return 补全之后的字符串
     */
    public static String preFillString(String str, int len, char pre) {
        int length = len - str.length();
        for (int i = 0; i < length; i++) {
            str = pre + str;
        }
        return str;
    }
 
    /**
     * 获取颜色的HTML表示方式,
     *
     * @param str getHexString()
     * @return
     */
    public static String getColorByHex(String str) {
        String[] hexString = str.split(":");
        String colorRGB = "";
        for (int i = 0; i < hexString.length; i++) {
            hexString[i] = preFillString(hexString[i], 4, '0');
            colorRGB += hexString[i].substring(0, 2);
        }
        if ("000000".equals(colorRGB)) {
            colorRGB = "";
        }
        return colorRGB;
    }
 
    /**
     * 获取颜色
     *
     * @param shortColor
     * @return
     */
    public static String getColorByShortColor(short shortColor) {
        String returnColor = "";
        for (IndexedColors color : IndexedColors.values()) {
            if (shortColor == color.getIndex()) {
                returnColor = color.toString();
            }
        }
        if ("AUTOMATIC".equals(returnColor)) {
            returnColor = "";
        }
        return returnColor;
    }
 
    /**
     * 获取Sheet中所有单元格样式合集
     *
     * @param sheet
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getSheetCellStyleMaps(Sheet sheet) throws Exception {
        List<Map<String, Object>> sheetCellStyles = new ArrayList<Map<String, Object>>();
        int lastRowNum = getRowNum(sheet);
        Row row;
        for (int i = 0; i < lastRowNum; i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            int columnNumMax = getColumnNum(sheet);
            for (int j = 0; j < columnNumMax; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                Map<String, Object> cellMap = getCellStyleMap(sheet, cell);
                cellMap.put("y", i);
                cellMap.put("x", j);
                sheetCellStyles.add(cellMap);
            }
        }
        return sheetCellStyles;
    }
 
    /**
     * 获取Sheet中,某一个Cell的样式,Cell的背景颜色单独去取,借助于HSSFSheet和XSSFSheet
     *
     * @param sheet
     * @param cell
     * @return
     */
    public static Map<String, Object> getCellStyleMap(Sheet sheet, Cell cell) {
        Map<String, Object> cellStyleMap = new HashMap<String, Object>();
 
        Short alignShort = cell.getCellStyle().getAlignment();
        String alignment = "c";
        if (alignShort == 1) {
            alignment = "l";
        } else if (alignShort == 3) {
            alignment = "r";
        }
 
        CellStyle cellStyle = cell.getCellStyle();
        Workbook workbook = sheet.getWorkbook();
        Font font = workbook.getFontAt(cellStyle.getFontIndex());
        cellStyleMap.put("fontColor", getColorByShortColor(font.getColor()));
        cellStyleMap.put("fontBold", font.getBoldweight());
        cellStyleMap.put("fontSize", font.getFontHeightInPoints());
        cellStyleMap.put("alignment", alignment);
        try {
            HSSFCellStyle hSSFCellStyle = (HSSFCellStyle) cell.getCellStyle();
            cellStyleMap.put("cellColor", getColorByHex(hSSFCellStyle.getFillForegroundColorColor().getHexString()));
        } catch (Exception e) {
            XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cell.getCellStyle();
            String xssfCellColor = "";
            if (xSSFCellStyle.getFillBackgroundColorColor() != null) {
                xssfCellColor = xSSFCellStyle.getFillForegroundColorColor().getARGBHex().substring(2);
            }
            xssfCellColor = "000000".equals(xssfCellColor) ? "" : xssfCellColor;
            cellStyleMap.put("cellColor", xssfCellColor);
        }
        return cellStyleMap;
    }
    
    
    /**
     * 填充数据 默认第一个 sheet
     * @param workbook
     * @param startRow 指定从哪一行开始  （语意上的序号）
     * @param list 要填充的值  Map格式： key为属性名 对应 模板中的 标识符号，Object 为要替换的值
     */
    public static void fillCellValue( Workbook workbook,int startRow,List<Map<String, Object>> list){
    	fillCellValue(workbook, 1, startRow, list);
    }
 
    /**
     * 填充数据
     * @param workbook
     * @param sheetIndex 指定 sheet的索引（语意上的序号）
     * @param startRow 指定从哪一行开始  （语意上的序号）
     * @param list 要填充的值  Map格式： key为属性名 对应 模板中的 标识符号，Object 为要替换的值
     */
    public static void fillCellValue( Workbook workbook,int sheetIndex,int startRow,List<Map<String, Object>> list){
    	 Sheet sheet= workbook.getSheetAt(sheetIndex-1);
    	 CellStyle contentStyle = workbook.createCellStyle();
    	 Font contentFont = workbook.createFont();
    	 setDefaultCellStyle(contentStyle,contentFont);
    	 //设置每行每列的值
    	 Row row=sheet.getRow(startRow-1);
    	 if(null==row){
    		 return;
    	 }
    	 int startClum=row.getFirstCellNum();
    	 List<String>  key = getRowDataList(row);
    	 String[] keys=key.toArray(new String[key.size()]);//获取 替代的 行的 key
    	 sheet.removeRow(row);//删除 占位 需要替代的那一行
    	 
         for (short i = 0; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow((short) i+startRow-1);
            // 在row行上创建一个方格
            for(short j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j+startClum);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(contentStyle);
            }
         }
    }
    
    
    
    /**
     * 值覆盖所有 需要被填充的位置 默认第一个 sheet
     * @param workbook
     * @param list
     * @throws Exception 
     */
    public static void fillCellValue(Workbook workbook,Map<String, Object> map) throws Exception{
    	fillCellValue(workbook,1,map);
    }
    
    public static void fillCellValue(Workbook workbook,int sheetIndex,Map<String, Object> map) throws Exception{
    		Sheet sheet=getSheetByNum(workbook, sheetIndex);
    		for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
    			Row row = sheet.getRow(i);
    			if(row!=null){
    				for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
    					Cell cell = row.getCell(j);
    					String value = getCellData(cell);
    					if(map.containsKey(value)){
    						cell.setCellValue(map.get(value).toString());
    					}
    				}
    			}
    		}
    }
    
    
    /**
     * 设置默认样式
     * @param contentStyle 
     * @param contentFont
     */
    public static void setDefaultCellStyle(CellStyle contentStyle,Font contentFont) {
    	
    	//设置字体
    	contentFont.setFontName("宋体");
		contentFont.setFontHeightInPoints((short) 10);
		contentFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		contentFont.setCharSet(Font.DEFAULT_CHARSET);
		contentFont.setColor(IndexedColors.BLACK.index);
		
		//设置样式
		contentStyle.setAlignment(CellStyle.ALIGN_CENTER);
		contentStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		contentStyle.setFont(contentFont);
		contentStyle.setBorderTop(CellStyle.BORDER_THIN);
		contentStyle.setBorderBottom(CellStyle.BORDER_THIN);
		contentStyle.setBorderLeft(CellStyle.BORDER_THIN);
		contentStyle.setBorderRight(CellStyle.BORDER_THIN);
		contentStyle.setTopBorderColor(IndexedColors.BLACK.index);
		contentStyle.setBottomBorderColor(IndexedColors.BLACK.index);
		contentStyle.setLeftBorderColor(IndexedColors.BLACK.index);
		contentStyle.setRightBorderColor(IndexedColors.BLACK.index);
		contentStyle.setWrapText(true); // 字段换行
	}
    
    
    
    public static void main(String[] args) throws Exception {
        Workbook workbook = readExcel2Workbook("D://test.xlsx");
        System.out.println(workbook.getClass().getName());
        Sheet sheet = getSheetByNum(workbook, 1);
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "张三");
        map.put("password", "123456");
        map.put("status", "成功了");
        map.put("realname", "张三");
        list.add(map);
        list.add(map);
        fillCellValue(workbook, 1, 3, list);
        HashMap<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("qq", "4425456");
        hashMap.put("msn", "3884546");
        fillCellValue(workbook, hashMap);
        
        
       //  List<Map<String, String>> sheetRegion = getSheetRegion(sheet);
         System.out.println(JsonUtil.ObjectToJson(getSheetDataMapAndId(sheet)));
         OutputStream out =new FileOutputStream(new File("d://test4.xlsx"));
         export2Excel(workbook, out);
    }
}