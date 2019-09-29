package com.my.java.util.exportjar;

import java.nio.charset.StandardCharsets;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExportExcelUtil {

//	public  static void setResponseHeader(HttpServletResponse response, String fileName) {
//        try {
//            response.setContentType("application/form-data");
//            fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1");
//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
	
	public static CellStyle initExcelHeaderStyle(HSSFWorkbook wb) {
		// 设置副标题字体
		Font fontContent = wb.createFont();
		fontContent.setFontHeightInPoints((short) 14);
		fontContent.setColor(HSSFColor.BLACK.index);
		fontContent.setFontName("Arial");
		
		//设置样式
		CellStyle cellStyleText = wb.createCellStyle();
		cellStyleText.setFont(fontContent);
		cellStyleText.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyleText.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cellStyleText.setWrapText(true);
		cellStyleText.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
		cellStyleText.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyleText.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyleText.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyleText.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyleText.setBorderTop(HSSFCellStyle.BORDER_THIN);
		return cellStyleText;
	}
	
	/**
	 * 初始化表格样式
	 */
	public static CellStyle initExcelCellStyle(HSSFWorkbook wb) {
		// 设置文本字体
		Font fontText = wb.createFont();
		fontText.setFontHeightInPoints((short) 12);
		fontText.setColor(HSSFColor.BLACK.index);
		fontText.setFontName("Arial");

		// 文本样式
		CellStyle cellStyleText = wb.createCellStyle();
		cellStyleText.setFont(fontText);
		cellStyleText.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyleText.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cellStyleText.setWrapText(true);
		return cellStyleText;
	}
	
	/**
	 * 初始化表格
	 */
	public static HSSFWorkbook initExcelStyle(String sheetName) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(30);
		return wb;
	}
	
	/**
	 * 初始化标题
	 */
	public static HSSFWorkbook initExcelHeader(HSSFWorkbook wb,String[] headers,int index) {
		HSSFRow rowContent = wb.getSheetAt(0).createRow(index);
		CellStyle cellStyleText = ExportExcelUtil.initExcelHeaderStyle(wb);
		for(int i = 0;i < headers.length;i++) {
			HSSFCell cellContentStore = rowContent.createCell(i);
		    cellContentStore.setCellValue(headers[i]);
		    cellContentStore.setCellStyle(cellStyleText);
		}
	    return wb;
	}
	
	/**
	 * 初始化标题
	 */
	public static HSSFWorkbook initExcelHeader(HSSFWorkbook wb,String[] headers,int index,int sheetIndex) {
		HSSFRow rowContent = wb.getSheetAt(sheetIndex).createRow(index);
		CellStyle cellStyleText = ExportExcelUtil.initExcelHeaderStyle(wb);
		for(int i = 0;i < headers.length;i++) {
			HSSFCell cellContentStore = rowContent.createCell(i);
		    cellContentStore.setCellValue(headers[i]);
		    cellContentStore.setCellStyle(cellStyleText);
		}
	    return wb;
	}
	
	/**
	 * 初始化汇总行
	 */
	public static HSSFWorkbook initExcelTotals(HSSFWorkbook wb,String[] headers,String[] totalsData,int index) {
		HSSFRow rowContent = wb.getSheetAt(0).createRow(index);
		CellStyle cellStyleText = ExportExcelUtil.initExcelCellStyle(wb);
		for(int i = 0;i < headers.length;i++) {
			HSSFCell cellContentStore = rowContent.createCell(i*2);
		    cellContentStore.setCellValue(headers[i]);
		    cellContentStore.setCellStyle(cellStyleText);
		}
		for(int i = 0;i < totalsData.length;i++) {
			HSSFCell cellContentStore = rowContent.createCell(i*2+1);
		    cellContentStore.setCellValue(totalsData[i]);
		    cellContentStore.setCellStyle(cellStyleText);
		}
	    return wb;
	}
}
