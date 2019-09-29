package com.my.java.util.exportjar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.util.IOUtils;


public class ExportDataToExcel {

	public static <T> File export(List<T> models, String fileName,String sheetName) throws Exception {
		//1.标题头
        List<String> header = ExtractFileHeader.generator(models.get(0).getClass());

        //2.实体属性
        Field[] fields = models.get(0).getClass().getDeclaredFields();

        //3.workbook初始化
        HSSFWorkbook workbook = ExportExcelUtil.initExcelStyle(sheetName);
        CellStyle headStyleText = ExportExcelUtil.initExcelHeaderStyle(workbook);
        CellStyle cellStyleText = ExportExcelUtil.initExcelCellStyle(workbook);

        //4.标题样式设置
        HSSFRow row = workbook.getSheet(sheetName).createRow(0);
        for (int i = 0; i < header.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(headStyleText);
            cell.setCellValue(header.get(i));
        }

        //5.内容展示
        Iterator<T> it = models.iterator();
        int index = 0;
        while (it.hasNext()) {
        	//6.创建行
            index++;
            row = workbook.getSheet(sheetName).createRow(index);
            T t = (T) it.next();
            //7.根据列类型 来获取列值
            int cellIndex = 0;
            for (Field f : fields) {
            	Comment comment = f.getAnnotation(Comment.class);
				if (comment.isNeedComment()) {
					HSSFCell cell = row.createCell(cellIndex);
					cell.setCellStyle(cellStyleText);
					f.setAccessible(true);
					Object obj = f.get(t);
					if (obj.getClass().isPrimitive() || obj instanceof String || obj instanceof Integer
		                    || obj instanceof Long || obj instanceof Boolean || obj instanceof BigDecimal 
		                    || obj instanceof Float || obj instanceof Double) {
						cell.setCellValue(obj.toString());
		            }
					else if (f.getType().equals(Date.class)) {
						Date dateValue = (Date) f.get(t);
						SimpleDateFormat simpleDateFormat = constant.getInstance(comment.dateStyle());
						cell.setCellValue(simpleDateFormat.format(dateValue));
					}else {
						throw new Exception("暂不支持的数据类型"+f.getType().getName());
					}
					cellIndex++;
				}
			}
        }

        //创建文件
        File file = new File(fileName);
        OutputStream out = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(out);
        }
        return file;
	}
	 
}
