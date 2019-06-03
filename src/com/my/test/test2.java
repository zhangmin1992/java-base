package com.my.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class test2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	String path = "/Users/min.zhang/Desktop/aa.xls";	
	HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
    HSSFSheet sheet = null;
    int index = 0;
    String result = "[";
    String temp = "";
        sheet = workbook.getSheetAt(1);
        for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum，获取最后一行的行标
            HSSFRow row = sheet.getRow(j);
            temp = "[";
            if (row != null) {
            	index ++;
            	if(row.getCell(0) != null) {
            		temp = "{value:'" + index +"',code:'" + "0" + row.getCell(0) + "0000'";
            	}
            	if(row.getCell(1) != null) {
            		temp = temp + ",label:'" + row.getCell(1) + "'}," ;
            	}
            }
            result = result + temp;
        }
        System.out.println(result);
  }

}
